package biz.davidnelson.ocramiusgit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import biz.davidnelson.ocramiusgit.R;
import biz.davidnelson.ocramiusgit.data.model.OcramiusRepo;

public class OcramiusRepoAdapter extends RecyclerView.Adapter<OcramiusRepoAdapter.RepoViewHolder> {

    public interface RepoClickListener {
        void onRepoClicked(String cloneUrl);
    }

    private ArrayList<OcramiusRepo> mOcramiusRepos;
    private static RepoClickListener mRepoClickListener;

    public OcramiusRepoAdapter(ArrayList<OcramiusRepo> repos, RepoClickListener repoClickListener) {
        mOcramiusRepos = repos;
        mRepoClickListener = repoClickListener;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item, parent, false);
        final RepoViewHolder viewHolder = new RepoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        final OcramiusRepo repoItem = mOcramiusRepos.get(position);
        holder.mIdTextView.setText(repoItem.getId());
        holder.mNameTextView.setText(repoItem.getName());
        holder.mOwnerLoginTextView.setText(repoItem.getOwnerLogin());
        holder.mLanguageTextview.setText(repoItem.getLanguage());
        holder.mUpdatedTextview.setText(repoItem.getUpdatedAt());

        holder.cloneUrl = repoItem.getCloneUrl();

        Picasso.with(holder.mOwnerAvatar.getContext())
            .load(repoItem.getOwnerAvatarUrl())
            .resize(100, 100)
            .into(holder.mOwnerAvatar);
    }

    @Override
    public int getItemCount() {
        return mOcramiusRepos.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {

        private ImageView mOwnerAvatar;
        private TextView mIdTextView;
        private TextView mNameTextView;
        private TextView mOwnerLoginTextView;
        private TextView mLanguageTextview;
        private TextView mUpdatedTextview;

        private String cloneUrl;

        RepoViewHolder(View v) {
            super(v);
            mOwnerAvatar = (ImageView) v.findViewById(R.id.imageView_ownerAvatar);
            mIdTextView = (TextView) v.findViewById(R.id.textView_id);
            mNameTextView = (TextView) v.findViewById(R.id.textView_repoName);
            mOwnerLoginTextView = (TextView) v.findViewById(R.id.textView_repoOwnerLogin);
            mLanguageTextview = (TextView) v.findViewById(R.id.textView_repoLanguage);
            mUpdatedTextview = (TextView) v.findViewById(R.id.textView_repoUpdatedAt);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRepoClickListener.onRepoClicked(cloneUrl);
                }
            });
        }
    }
}


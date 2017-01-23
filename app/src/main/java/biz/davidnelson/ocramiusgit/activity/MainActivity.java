package biz.davidnelson.ocramiusgit.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import biz.davidnelson.ocramiusgit.R;
import biz.davidnelson.ocramiusgit.adapter.OcramiusRepoAdapter;
import biz.davidnelson.ocramiusgit.data.model.OcramiusRepo;
import biz.davidnelson.ocramiusgit.data.OcramiusRepoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OcramiusRepoAdapter.RepoClickListener {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(),
            mLayoutManager.getOrientation()));

        getData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getString(R.string.toast_help), Toast.LENGTH_LONG).show();
    }

    private void getData(){

        final OcramiusRepoService request = OcramiusRepoService.retrofit.create(OcramiusRepoService.class);
        final Call<ArrayList<OcramiusRepo>> call = request.getRepos();
        call.enqueue(new Callback<ArrayList<OcramiusRepo>>() {
            @Override
            public void onResponse(Call<ArrayList<OcramiusRepo>> call, Response<ArrayList<OcramiusRepo>> response) {

                final ArrayList<OcramiusRepo> repos = response.body();
                final RecyclerView.Adapter adapter = new OcramiusRepoAdapter(repos, MainActivity.this);
                mRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<OcramiusRepo>> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
   @Override
    public void onRepoClicked(final String cloneUrl) {
        final Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(cloneUrl));
        startActivity(i);

    }
}

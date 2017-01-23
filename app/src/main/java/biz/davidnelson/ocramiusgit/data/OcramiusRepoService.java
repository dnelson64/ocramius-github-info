package biz.davidnelson.ocramiusgit.data;

import java.util.ArrayList;

import biz.davidnelson.ocramiusgit.data.model.OcramiusRepo;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface OcramiusRepoService {
    @GET("users/ocramius/repos")
    Call<ArrayList<OcramiusRepo>> getRepos();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

}
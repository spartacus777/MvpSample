package kizema.anton.podcastmvpsample.podcast_act;

import android.os.Handler;
import android.util.Log;

import java.util.List;

import kizema.anton.podcastmvpsample.api.ApiEndpoint;
import kizema.anton.podcastmvpsample.model.StationModel;
import kizema.anton.podcastmvpsample.model.StationModelList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PodcastInteractorImpl implements PodcastInteractor {

    private Retrofit retrofit;

    public PodcastInteractorImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.metro.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    @Override
    public void loadData(final OnCompletion listener) {

        Log.e("RRR", " ===== LOAD DATA ===== ");


        ApiEndpoint apiService =
                retrofit.create(ApiEndpoint.class);

        Call<StationModelList> call = apiService.listRepos();
        call.enqueue(new Callback<StationModelList>() {
            @Override
            public void onResponse(Call<StationModelList> call, final Response<StationModelList> response) {

                for (StationModel p : response.body().getPodcasts()){
                    p.save();
                    Log.d("RR", p.toString());
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onComplete(response.body().getPodcasts());
                        Log.d("RRR", "Loaded");
                    }
                }, 2000);

            }

            @Override
            public void onFailure(Call<StationModelList> call, Throwable t) {
                Log.d("RR", t + call.toString());

                listener.onError();
            }
        });
    }

    @Override
    public List<StationModel> loadDataFromDB() {
        return StationModel.getAll();
    }
}

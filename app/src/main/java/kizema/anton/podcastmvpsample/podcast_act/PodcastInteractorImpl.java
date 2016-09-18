package kizema.anton.podcastmvpsample.podcast_act;

import android.os.Handler;
import android.util.Log;

import kizema.anton.podcastmvpsample.api.ApiEndpoint;
import kizema.anton.podcastmvpsample.model.PodactDtoList;
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

        Call<PodactDtoList> call = apiService.listRepos();
        call.enqueue(new Callback<PodactDtoList>() {
            @Override
            public void onResponse(Call<PodactDtoList> call, final Response<PodactDtoList> response) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onComplete(response.body().getPodcasts());
                    }
                }, 2000);



                for (PodactDtoList.PodactDto p : response.body().getPodcasts()){
                    Log.d("RR", p.toString());
                }
            }

            @Override
            public void onFailure(Call<PodactDtoList> call, Throwable t) {
                Log.d("RR", t + call.toString());

                listener.onError();
            }
        });
    }
}

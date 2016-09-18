package kizema.anton.podcastmvpsample.podcast_act;

import android.util.Log;

import kizema.anton.podcastmvpsample.model.PodactDtoList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PodcastPresenterImpl implements PodcastPrsenter {

    private PodactView podactView;

    private PodcastInteractor podcastInteractor;

    public PodcastPresenterImpl(PodactView podactView, PodcastInteractor podcastInteractor) {
        this.podactView = podactView;
        this.podcastInteractor = podcastInteractor;
    }

    @Override
    public void getPodcasts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.metro.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiEndpoint apiService =
                retrofit.create(ApiEndpoint.class);

        Call<PodactDtoList> call = apiService.listRepos();
        call.enqueue(new Callback<PodactDtoList>() {
            @Override
            public void onResponse(Call<PodactDtoList> call, Response<PodactDtoList> response) {

                for (PodactDtoList.PodactDto p : response.body().getPodcasts()){
                    Log.d("RR", p.toString());
                }
            }

            @Override
            public void onFailure(Call<PodactDtoList> call, Throwable t) {
                Log.d("RR", t + call.toString());
            }
        });

    }

}

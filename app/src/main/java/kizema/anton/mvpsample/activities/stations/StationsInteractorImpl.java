package kizema.anton.mvpsample.activities.stations;

import android.os.Handler;
import android.util.Log;

import java.util.List;

import kizema.anton.mvpsample.api.ApiEndpoint;
import kizema.anton.mvpsample.model.StationModel;
import kizema.anton.mvpsample.model.StationModelList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StationsInteractorImpl implements StationsInteractor {

    private Retrofit retrofit;

    private ApiEndpoint apiService;

    public StationsInteractorImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.metro.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiEndpoint.class);
    }

    @Override
    public void loadData(final OnCompletion listener) {

        Log.e("RRR", " ===== LOAD DATA ===== ");

        Call<StationModelList> call = apiService.listRepos();
        call.enqueue(new Callback<StationModelList>() {
            @Override
            public void onResponse(Call<StationModelList> call, final Response<StationModelList> response) {

                /**
                 * TODO remove - emulating long-timed job
                 */
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        response.body().save();
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

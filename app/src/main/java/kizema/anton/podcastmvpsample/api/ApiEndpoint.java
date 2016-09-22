package kizema.anton.podcastmvpsample.api;

import kizema.anton.podcastmvpsample.model.StationModelList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("/agencies/lametro/routes/")
    Call<StationModelList> listRepos();

}

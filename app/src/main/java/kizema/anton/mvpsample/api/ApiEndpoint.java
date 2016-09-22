package kizema.anton.mvpsample.api;

import kizema.anton.mvpsample.model.StationModelList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("/agencies/lametro/routes/")
    Call<StationModelList> listRepos();

}

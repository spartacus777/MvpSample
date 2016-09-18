package kizema.anton.podcastmvpsample.api;

import kizema.anton.podcastmvpsample.model.PodactDtoList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("/agencies/lametro/routes/")
    Call<PodactDtoList> listRepos();

}

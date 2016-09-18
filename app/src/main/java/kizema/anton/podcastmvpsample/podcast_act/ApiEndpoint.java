package kizema.anton.podcastmvpsample.podcast_act;

import kizema.anton.podcastmvpsample.model.PodactDtoList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("/agencies/lametro/routes/")
    Call<PodactDtoList> listRepos();

}

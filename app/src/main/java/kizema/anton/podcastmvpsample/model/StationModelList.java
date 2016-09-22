package kizema.anton.podcastmvpsample.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationModelList {

    @SerializedName("items")
    public List<StationModel> podcasts;

    public void setPodcasts(List<StationModel> podcasts) {
        this.podcasts = podcasts;
    }

    public List<StationModel> getPodcasts() {
        return podcasts;
    }

}

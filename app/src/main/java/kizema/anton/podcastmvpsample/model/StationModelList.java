package kizema.anton.podcastmvpsample.model;


import com.activeandroid.ActiveAndroid;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StationModelList {

    @SerializedName("items")
    private List<StationModel> podcasts;

    public void setPodcasts(List<StationModel> podcasts) {
        this.podcasts = podcasts;
    }

    public List<StationModel> getPodcasts() {
        return podcasts;
    }

    public void save(){
        ActiveAndroid.beginTransaction();
        try {
            for (StationModel m : podcasts) {
                m.save();
            }
            ActiveAndroid.setTransactionSuccessful();
        }
        finally {
            ActiveAndroid.endTransaction();
        }
    }
}

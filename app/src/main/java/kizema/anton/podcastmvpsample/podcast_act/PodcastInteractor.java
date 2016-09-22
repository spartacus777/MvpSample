package kizema.anton.podcastmvpsample.podcast_act;

import java.util.List;

import kizema.anton.podcastmvpsample.model.StationModel;

public interface PodcastInteractor {

    interface OnCompletion{
        void onComplete(List<StationModel> list);
        void onError();
    }

    void loadData(OnCompletion listener);

    List<StationModel> loadDataFromDB();
}

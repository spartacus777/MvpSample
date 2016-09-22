package kizema.anton.podcastmvpsample.activities.stations;

import java.util.List;

import kizema.anton.podcastmvpsample.model.StationModel;

public interface StationsInteractor {

    interface OnCompletion{
        void onComplete(List<StationModel> list);
        void onError();
    }

    void loadData(OnCompletion listener);

    List<StationModel> loadDataFromDB();
}

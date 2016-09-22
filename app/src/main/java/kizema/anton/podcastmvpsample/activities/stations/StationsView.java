package kizema.anton.podcastmvpsample.activities.stations;

import java.util.List;

import kizema.anton.podcastmvpsample.model.StationModel;

public interface StationsView {

    void setData(List<StationModel> list);

    void showError();

}

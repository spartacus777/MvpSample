package kizema.anton.mvpsample.activities.stations;

import java.util.List;

import kizema.anton.mvpsample.model.StationModel;

public interface StationsView {

    void setData(List<StationModel> list);

    void showError();

}

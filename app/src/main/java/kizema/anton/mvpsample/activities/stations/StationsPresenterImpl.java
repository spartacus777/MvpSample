package kizema.anton.mvpsample.activities.stations;

import java.util.List;

import kizema.anton.mvpsample.model.StationModel;

public class StationsPresenterImpl implements StationsPresenter {

    private StationsView podactView;

    private StationsInteractor stationsInteractor;

    private boolean loadDataIsInProgress = false;
    private boolean firstTime = true;

    public StationsPresenterImpl(StationsInteractor stationsInteractor) {
        this.stationsInteractor = stationsInteractor;
    }

    @Override
    public void setView(StationsView podactView) {
        this.podactView = podactView;

        loadFromDB();

        if (firstTime){
            load();
            firstTime = false;
        }
    }

    @Override
    public void removeView(StationsView podactView) {
        if (podactView == this.podactView){
            this.podactView = null;
        }
    }

    private void loadFromDB(){
        List<StationModel> list = stationsInteractor.loadDataFromDB();
        podactView.setData(list);
    }

    private void load() {

        if (loadDataIsInProgress){
            return;
        }

        loadDataIsInProgress = true;
        stationsInteractor.loadData(new StationsInteractor.OnCompletion() {
            @Override
            public void onComplete(List<StationModel> list) {
                podactView.setData(list);
                loadDataIsInProgress = false;
            }

            @Override
            public void onError() {
                podactView.showError();
                loadDataIsInProgress = false;
            }
        });
    }

}

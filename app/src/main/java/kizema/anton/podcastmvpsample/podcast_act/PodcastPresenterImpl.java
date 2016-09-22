package kizema.anton.podcastmvpsample.podcast_act;

import java.util.List;

import kizema.anton.podcastmvpsample.model.StationModel;

public class PodcastPresenterImpl implements PodcastPrsenter {

    private PodactView podactView;

    private PodcastInteractor podcastInteractor;

    private boolean loadDataIsInProgress = false;
    private boolean firstTime = true;


    public PodcastPresenterImpl(PodcastInteractor podcastInteractor) {
        this.podcastInteractor = podcastInteractor;
    }

    @Override
    public void setView(PodactView podactView) {
        this.podactView = podactView;

        loadFromDB();

        if (firstTime){
            load();
            firstTime = false;
        }
    }

    @Override
    public void removeView(PodactView podactView) {
        if (podactView == this.podactView){
            this.podactView = null;
        }
    }

    public void loadFromDB(){
        List<StationModel> list = podcastInteractor.loadDataFromDB();
        podactView.setData(list);
    }

    @Override
    public void load() {

        if (loadDataIsInProgress){
            return;
        }

        loadDataIsInProgress = true;
        podcastInteractor.loadData(new PodcastInteractor.OnCompletion() {
            @Override
            public void onComplete(List<StationModel> list) {
                podactView.setData(list);
                loadDataIsInProgress = false;
            }

            @Override
            public void onError() {
                loadDataIsInProgress = false;
            }
        });
    }

}

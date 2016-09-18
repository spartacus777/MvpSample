package kizema.anton.podcastmvpsample.podcast_act;

import java.util.List;

import kizema.anton.podcastmvpsample.model.PodactDtoList;

public class PodcastPresenterImpl implements PodcastPrsenter {

    private PodactView podactView;

    private PodcastInteractor podcastInteractor;

    public PodcastPresenterImpl(PodactView podactView, PodcastInteractor podcastInteractor) {
        this.podactView = podactView;
        this.podcastInteractor = podcastInteractor;
    }

    @Override
    public void setPodactView(PodactView podactView) {
        this.podactView = podactView;
    }

    private boolean loadDataIsInProgress = false;

    @Override
    public void getPodcasts() {

        if (loadDataIsInProgress){
            return;
        }

        loadDataIsInProgress = true;
        podcastInteractor.loadData(new PodcastInteractor.OnCompletion() {
            @Override
            public void onComplete(List<PodactDtoList.PodactDto> list) {
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

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
    public void getPodcasts() {

        podcastInteractor.loadData(new PodcastInteractor.OnCompletion() {
            @Override
            public void onComplete(List<PodactDtoList.PodactDto> list) {
                podactView.setData(list);
            }

            @Override
            public void onError() {

            }
        });
    }

}

package kizema.anton.podcastmvpsample.podcast_act;

import java.util.List;

import kizema.anton.podcastmvpsample.model.PodactDtoList;

public interface PodcastInteractor {

    interface OnCompletion{
        void onComplete(List<PodactDtoList.PodactDto> list);

        void onError();
    }

    void loadData(OnCompletion listener);
}

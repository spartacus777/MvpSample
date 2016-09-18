package kizema.anton.podcastmvpsample.podcast_act;

import java.util.List;

import kizema.anton.podcastmvpsample.model.PodactDtoList;

public interface PodactView {

    void setData(List<PodactDtoList.PodactDto> list);

}

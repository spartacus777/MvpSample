package kizema.anton.podcastmvpsample.podcast_act;


import java.io.Serializable;

public interface PodcastPrsenter extends Serializable{

    void getPodcasts();

    void setPodactView(PodactView podactView);
}

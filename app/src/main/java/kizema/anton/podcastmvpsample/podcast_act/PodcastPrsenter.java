package kizema.anton.podcastmvpsample.podcast_act;


import java.io.Serializable;

public interface PodcastPrsenter extends Serializable{

    void load();

    void setView(PodactView podactView);

    void removeView(PodactView podactView);
}

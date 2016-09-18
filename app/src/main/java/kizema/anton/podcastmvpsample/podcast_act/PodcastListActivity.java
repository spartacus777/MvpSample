package kizema.anton.podcastmvpsample.podcast_act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import kizema.anton.podcastmvpsample.R;

public class PodcastListActivity extends AppCompatActivity implements PodactView{

//    @BindView(R.id.rvPodcasts)
    public RecyclerView rvPodcasts;

    private PodcastPrsenter podcastPrsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        podcastPrsenter = new PodcastPresenterImpl(this, new PodcastInteractorImpl());

        podcastPrsenter.getPodcasts();

    }
}

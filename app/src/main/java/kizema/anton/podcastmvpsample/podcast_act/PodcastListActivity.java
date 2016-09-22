package kizema.anton.podcastmvpsample.podcast_act;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kizema.anton.podcastmvpsample.R;
import kizema.anton.podcastmvpsample.adapters.MainAdapter;
import kizema.anton.podcastmvpsample.model.StationModel;

public class PodcastListActivity extends AppCompatActivity implements PodactView {

    @BindView(R.id.rvPodcasts)
    public RecyclerView rvPodcasts;

    private MainAdapter adapter;

    private PodcastPrsenter podcastPrsenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initPresenter(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        podcastPrsenter.removeView(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("e", podcastPrsenter);
        super.onSaveInstanceState(outState);
    }

    private void init() {
        rvPodcasts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MainAdapter();
        rvPodcasts.setAdapter(adapter);
    }

    private void initPresenter(Bundle savedInstanceState){
        if (savedInstanceState != null) {
            podcastPrsenter = (PodcastPrsenter) savedInstanceState.getSerializable("e");
        } else {
            podcastPrsenter = new PodcastPresenterImpl(new PodcastInteractorImpl());
        }

        podcastPrsenter.setView(this);
    }

    @Override
    public void setData(List<StationModel> list) {
        adapter.setData(list);
    }

}

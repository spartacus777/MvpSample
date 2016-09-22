package kizema.anton.podcastmvpsample.activities.stations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kizema.anton.podcastmvpsample.R;
import kizema.anton.podcastmvpsample.adapters.MainAdapter;
import kizema.anton.podcastmvpsample.model.StationModel;

public class StationsListActivity extends AppCompatActivity implements StationsView {

    private static final String PRESENTER_STR = "wefwefd";

    @BindView(R.id.rvPodcasts)
    public RecyclerView rvStations;

    @BindView(R.id.loading)
    public ProgressBar loading;

    private MainAdapter adapter;

    private StationsPresenter stationsPresenter;

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

        stationsPresenter.removeView(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PRESENTER_STR, stationsPresenter);
        super.onSaveInstanceState(outState);
    }

    private void init() {
        rvStations.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new MainAdapter();
        rvStations.setAdapter(adapter);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();

                if (adapter.getItemCount() == 0){
                    loading.setVisibility(View.VISIBLE);
                } else {
                    loading.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initPresenter(Bundle savedInstanceState){
        if (savedInstanceState != null) {
            stationsPresenter = (StationsPresenter) savedInstanceState.getSerializable(PRESENTER_STR);
        }

        if (stationsPresenter == null){
            stationsPresenter = new StationsPresenterImpl(new StationsInteractorImpl());
        }

        stationsPresenter.setView(this);
    }

    @Override
    public void setData(List<StationModel> list) {
        adapter.setData(list);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error loading data", Toast.LENGTH_SHORT).show();
    }

}

package kizema.anton.mvpsample.activities.stations;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kizema.anton.mvpsample.R;
import kizema.anton.mvpsample.adapters.MainAdapter;
import kizema.anton.mvpsample.model.StationModel;

public class StationsListActivity extends AppCompatActivity implements StationsView {

    private static final String PRESENTER_STR = "wefwefd";

    @BindView(R.id.rvPodcasts)
    public RecyclerView rvStations;

    @BindView(R.id.loading)
    public ProgressBar loading;

    private MainAdapter adapter;

    private StationsPresenter stationsPresenter;

    private RetainedFragment dataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        dataFragment.setData(stationsPresenter);
        stationsPresenter.removeView(this);
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

    private void initPresenter(){

        FragmentManager fm = getSupportFragmentManager();
        dataFragment = (RetainedFragment) fm.findFragmentByTag(PRESENTER_STR);

        if (dataFragment == null) {

            dataFragment = new RetainedFragment();
            fm.beginTransaction().add(dataFragment, PRESENTER_STR).commit();

            stationsPresenter = new StationsPresenterImpl(new StationsInteractorImpl());
            dataFragment.setData(stationsPresenter);
        }

        stationsPresenter = dataFragment.getData();
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

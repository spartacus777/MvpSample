package kizema.anton.mvpsample.activities.stations;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class RetainedFragment extends Fragment {

    // data object we want to retain
    private StationsPresenter data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setData(StationsPresenter data) {
        this.data = data;
    }

    public StationsPresenter getData() {
        return data;
    }
}
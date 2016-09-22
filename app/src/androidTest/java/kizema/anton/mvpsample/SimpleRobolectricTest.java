package kizema.anton.mvpsample;


import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import kizema.anton.mvpsample.activities.stations.StationsListActivity;

import static org.junit.Assert.assertTrue;


@RunWith(RobolectricTestRunner.class)
public class SimpleRobolectricTest {

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {
        StationsListActivity activity = Robolectric.setupActivity(StationsListActivity.class);

        RecyclerView rv = (RecyclerView) activity.findViewById(R.id.rvPodcasts);
        final ProgressBar pb = (ProgressBar) activity.findViewById(R.id.loading);

        assertTrue(rv != null);

//        final RecyclerView.Adapter adapter = rv.getAdapter();
//        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//            @Override
//            public void onChanged() {
//                super.onChanged();
//
//                if (adapter.getItemCount() == 0){
//                    assertTrue(pb.getVisibility() == View.VISIBLE);
//                } else {
//                    assertTrue(pb.getVisibility() == View.GONE);
//                }
//            }
//        });

    }
}

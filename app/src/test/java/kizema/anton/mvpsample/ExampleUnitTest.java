package kizema.anton.mvpsample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import kizema.anton.mvpsample.activities.stations.StationsInteractor;
import kizema.anton.mvpsample.activities.stations.StationsPresenter;
import kizema.anton.mvpsample.activities.stations.StationsPresenterImpl;
import kizema.anton.mvpsample.activities.stations.StationsView;
import kizema.anton.mvpsample.model.StationModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Before
    public void init(){

    }

    @Test
    public void test_view_same_result_as_interactor_gives() throws Exception {

        final List<StationModel> list = new ArrayList<>();
        StationModel s = mockStationModel(1, "test");
        list.add(s);

        StationModel s2 = mockStationModel(2, "dqwd");
        list.add(s2);

        StationsPresenter presenter = new StationsPresenterImpl(new StationsInteractor() {
            @Override
            public void loadData(OnCompletion listener) {
                listener.onComplete(list);
            }

            @Override
            public List<StationModel> loadDataFromDB() {
                return list;
            }
        });

        StationsView view = new StationsView() {
            @Override
            public void setData(List<StationModel> list) {
                assertEquals(list.size(), 2);
                assertTrue(list.get(0).getStationId() == 1);
                assertTrue(list.get(1).getStationId() == 2);
            }

            @Override
            public void showError() {}
        };

        presenter.setView(view);
    }

    private StationModel mockStationModel(int id, String descr){
        StationModel s = Mockito.mock(StationModel.class);
        s.setTitle(descr);
        s.setStationId(id);

        Mockito.when(s.getStationId()).thenReturn(id);
        Mockito.when(s.getTitle()).thenReturn(descr);

        return s;
    }

    @Test
    public void test_update_list() throws Exception {

        final List<StationModel> list = new ArrayList<>();
        final List<StationModel> list1 = new ArrayList<>();

        StationModel s = mockStationModel(1, "test");
        list.add(s);
        list1.add(s);

        StationModel s2 = mockStationModel(2, "ejdew");
        list1.add(s2);

        StationsPresenter presenter = new StationsPresenterImpl(new StationsInteractor() {
            @Override
            public void loadData(OnCompletion listener) {
                listener.onComplete(list1);
            }

            @Override
            public List<StationModel> loadDataFromDB() {
                return list;
            }
        });

        StationsView view = new StationsView() {

            private boolean first = true;

            @Override
            public void setData(List<StationModel> list) {
                if (first){
                    first = false;

                    assertEquals(list.size(), 1);
                    assertTrue(list.get(0).getStationId() == 1);
                    assertTrue(list.get(0).getTitle().equals("test"));
                } else {
                    assertEquals(list.size(), 2);
                    assertTrue(list.get(0).getStationId() == 1);
                    assertTrue(list.get(1).getStationId() == 2);
                }
            }

            @Override
            public void showError() {}
        };

        presenter.setView(view);
    }

}
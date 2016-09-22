package kizema.anton.mvpsample;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import kizema.anton.mvpsample.activities.stations.StationsPresenter;

/**
 * Created by somename on 22.09.2016.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "/src/main/AndroidManifest.xml")
public class RoboTests {

    private StationsPresenter mockPresenter;

    @Before
    public void setup() {
        Context context = RuntimeEnvironment.application;
        // Using a mock Presenter will permit to verify
        // if certain methods were called in Presenter
        mockPresenter = Mockito.mock(StationsPresenter.class);
    }

    @Test
    public void loadData(){
        mockPresenter.removeView(null);
//        assertEquals(mModel.mNotes.size(), notesSize);
    }

}

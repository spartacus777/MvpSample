package kizema.anton.podcastmvpsample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);

        ActiveAndroid.initialize(this);

    }
}

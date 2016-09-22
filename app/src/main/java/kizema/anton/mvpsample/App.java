package kizema.anton.mvpsample;

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

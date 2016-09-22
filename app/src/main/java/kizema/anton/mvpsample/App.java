package kizema.anton.mvpsample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(getApplicationContext());
        LeakCanary.install(this);
    }
}

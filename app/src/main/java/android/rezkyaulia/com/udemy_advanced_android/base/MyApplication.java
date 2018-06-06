package android.rezkyaulia.com.udemy_advanced_android.base;

import android.app.Application;
import android.rezkyaulia.com.udemy_advanced_android.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ActivityInjector getActivityInjector() {
        return activityInjector;
    }
}

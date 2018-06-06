package android.rezkyaulia.com.udemy_advanced_android.di;

import android.app.Activity;
import android.content.Context;
import android.rezkyaulia.com.udemy_advanced_android.base.BaseActivity;
import android.rezkyaulia.com.udemy_advanced_android.base.MyApplication;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */

public class ActivityInjector {
    private Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();
    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors){
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity){
        if (! (activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instanceId = ((BaseActivity) activity).getInstanceId();
        if (cache.containsKey(instanceId)){
            ((AndroidInjector<Activity>) cache.get(instanceId)).inject(activity);
            return;
        }

        AndroidInjector.Factory<Activity> injectFactory =
                (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();

        AndroidInjector<Activity> injector = injectFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }

    void clear(Activity activity){
        if (! (activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }
        cache.remove(((BaseActivity)activity).getInstanceId());
    }

    static ActivityInjector get(Context context){
       return ((MyApplication) context.getApplicationContext()).getActivityInjector();
    }
}

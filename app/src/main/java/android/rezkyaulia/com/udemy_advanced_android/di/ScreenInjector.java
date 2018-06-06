package android.rezkyaulia.com.udemy_advanced_android.di;

import android.app.Activity;
import android.rezkyaulia.com.udemy_advanced_android.base.BaseActivity;
import android.rezkyaulia.com.udemy_advanced_android.base.BaseController;

import com.bluelinelabs.conductor.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@ActivityScope
public class ScreenInjector {

    private Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjectors;
    private final Map<String, AndroidInjector<Controller>> cache = new HashMap<>();

    @Inject
    ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjectors){
        this.screenInjectors = screenInjectors;
    }

    void inject(Controller controller){
        if(!(controller instanceof BaseController)){
            throw new IllegalArgumentException("Controller must be extend BaseController");
        }
        String instanceId = controller.getInstanceId();
        if (cache.containsKey(instanceId)){
            cache.get(instanceId).inject(controller);
            return;
        }

        AndroidInjector.Factory<Controller> injectorFactory =
                (AndroidInjector.Factory<Controller>) screenInjectors.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }

    void clear(Controller controller){
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity){
        if (!(activity instanceof BaseActivity)){
            throw new IllegalArgumentException("Controller must be hosted by BaseActivity");
        }
        return ((BaseActivity) activity).getScreenInjector();
    }
}

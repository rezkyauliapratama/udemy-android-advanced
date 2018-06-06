package android.rezkyaulia.com.udemy_advanced_android.di;

import android.app.Activity;
import android.rezkyaulia.com.udemy_advanced_android.base.BaseActivity;

import com.bluelinelabs.conductor.Controller;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */

public class Injector {
    private Injector(){

    }

    public static   void inject (Activity activity){
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }

    public static void inject(Controller controller){
        ScreenInjector.get(controller.getActivity()).inject(controller);
    }

    public static void clearComponent(Controller controller){
        ScreenInjector.get(controller.getActivity()).clear(controller);
    }
}

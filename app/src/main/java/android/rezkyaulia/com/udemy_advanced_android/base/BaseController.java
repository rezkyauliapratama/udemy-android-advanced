package android.rezkyaulia.com.udemy_advanced_android.base;

import android.content.Context;
import android.rezkyaulia.com.udemy_advanced_android.di.Injector;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */

public abstract class BaseController extends Controller {
    private boolean injected = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        if (!injected){
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }

}

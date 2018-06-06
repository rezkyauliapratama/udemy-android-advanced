package android.rezkyaulia.com.udemy_advanced_android.home;

import android.rezkyaulia.com.udemy_advanced_android.di.ActivityScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{
        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}

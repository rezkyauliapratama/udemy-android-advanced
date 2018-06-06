package android.rezkyaulia.com.udemy_advanced_android.base;

import android.app.Activity;
import android.rezkyaulia.com.udemy_advanced_android.home.MainActivity;
import android.rezkyaulia.com.udemy_advanced_android.home.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@Module(subcomponents = {
        MainActivityComponent.class
})
public interface ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> provideMainActivityInjector(MainActivityComponent.Builder builder);
}

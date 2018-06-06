package android.rezkyaulia.com.udemy_advanced_android.home;

import android.rezkyaulia.com.udemy_advanced_android.di.ControllerKey;
import android.rezkyaulia.com.udemy_advanced_android.trending.TrendingReposComponent;
import android.rezkyaulia.com.udemy_advanced_android.trending.TrendingReposController;

import com.bluelinelabs.conductor.Controller;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}

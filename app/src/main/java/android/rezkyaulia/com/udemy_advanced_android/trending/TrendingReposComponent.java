package android.rezkyaulia.com.udemy_advanced_android.trending;

import android.rezkyaulia.com.udemy_advanced_android.di.ScreenScope;

import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController>{

    }
}

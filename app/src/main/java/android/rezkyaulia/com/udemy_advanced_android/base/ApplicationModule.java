package android.rezkyaulia.com.udemy_advanced_android.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@Module
public class ApplicationModule {

    private Application application;

    ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    Context provideApplicationContext(){
        return this.application;
    }
}

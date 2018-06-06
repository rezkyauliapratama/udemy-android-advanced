package android.rezkyaulia.com.udemy_advanced_android.base;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Rezky Aulia Pratama on 6/4/2018.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

}

package mx.com.chino.fragment.core;

import android.content.Context;
import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;


public class FragmentosApplication extends Application {
    private static FragmentosApplication instance;
    private static Context appContext;

    public static FragmentosApplication getInstance(){return instance;}
    public  static  Context getAppContext(){return appContext;}
    public  static  void setAppContext(Context context){appContext = context;}

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setAppContext(appContext.getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);


    }

}

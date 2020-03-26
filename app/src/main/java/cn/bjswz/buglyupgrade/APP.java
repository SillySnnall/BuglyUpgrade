package cn.bjswz.buglyupgrade;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Beta.initDelay = 0;
        Bugly.init(getApplicationContext(), "aa3cbf17cf", false);
    }
}

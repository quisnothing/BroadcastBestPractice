package com.example.ownClass;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 渠不与 on 2016/7/28 0028.
 */
public class BaseActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    protected void onDestroy(){
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}

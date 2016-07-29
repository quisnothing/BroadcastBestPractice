package com.example.ownClass;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 渠不与 on 2016/7/28 0028.
 */
public class ActivityCollector {
    public static List<Activity>activities=new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishall(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

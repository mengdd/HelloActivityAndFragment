package com.example.ddmeng.helloactivityandfragment.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class TaskUtils {

    private static final String LOG_TAG = "Stack";

    public static String getCurrentTopActivityName(Context context) {

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        //this method requires android.permission.GET_TASKS
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(2);
        //this method was deprecated in API level 21
        ComponentName topActivity = runningTasks.get(0).topActivity;
        Log.i(LOG_TAG, "top Activity: " + topActivity.getShortClassName());
        return topActivity.getShortClassName();

    }
}

package me.crazystone.study.pathanimator.utils;


import android.util.Log;

/**
 * Created by crazy_stone on 18-5-28.
 */

public class Logs {

    private static final String TAG = "wtf";

    public static void d(String message) {
        Log.d(TAG, message);
    }

    public static void d(Object object) {
        Log.d(TAG, object.toString());
    }

}

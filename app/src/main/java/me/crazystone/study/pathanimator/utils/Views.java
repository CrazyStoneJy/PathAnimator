package me.crazystone.study.pathanimator.utils;


import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;


/**
 * this is tool to operate the view
 * Created by crazy_stone on 18-4-16.
 */

public class Views {

    public static int dp2px(Context context, float dp) {
        float density = getDensity(context);
        return (int) (dp * density + 0.5F);
    }

    public static int px2dp(Context context, float px) {
        float density = getDensity(context);
        return (int) (px / density + 0.5F);
    }


    private static float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }


    public static Point getWindowSize(Context context) {
        Point point = new Point();
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        point.x = metrics.widthPixels;
        point.y = metrics.heightPixels;
        return point;
    }

    public static int getScreenWidth(Context context) {
        return getWindowSize(context).x;
    }

    public static int getScreenHeight(Context context) {
        return getWindowSize(context).y;
    }


}

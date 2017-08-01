package com.prachigautam.itunesapp;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

/**
 * Created by amar on 02/04/2016.
 */

public class ClientPlayer extends Activity {
    public static Handler UIHandler;

    static {
        UIHandler = new Handler(Looper.getMainLooper());
    }

    public static void runOnUI(Runnable runnable) {
        UIHandler.post(runnable);
    }
}

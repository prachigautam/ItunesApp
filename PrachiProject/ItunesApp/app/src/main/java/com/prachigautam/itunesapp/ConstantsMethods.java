package com.prachigautam.itunesapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by amar on 01-08-2017.
 */

public class ConstantsMethods {

    public static boolean isConnected(final Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }

        if ((haveConnectedMobile == false) && (haveConnectedWifi == false)) {
            ClientPlayer.runOnUI(new Runnable() {
                @Override
                public void run() {

                    try {
                        Constants.alNoInternet = new AlertDialog.Builder(context, android.R.style.Theme_Material_Light_Dialog_Alert)
                                .setTitle("No Internet")
                                .setCancelable(false)
                                .setMessage("Please check your internet connection...!")
                                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // continue with delete

                                        dialog.cancel();

                                    }
                                })
                                .setIcon(R.drawable.no_internet)
                                .show();

                        //   Toast.makeText(context,"NO inTENERT ",Toast.LENGTH_SHORT).show();
                        //Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
//                    dialog.setContentView(R.layout.internet_error_layout);
                        //dialog.show();
                    } catch (Exception e) {
                        Toast.makeText(context, "Please check your internet connection...!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}

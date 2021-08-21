package com.minda.erouteassignment;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utility {

    public static boolean isOnline(Context ctx) {
        boolean isConnected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            isConnected = cm.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception ex) {
            isConnected = false;
        }
        return isConnected;
    }

}

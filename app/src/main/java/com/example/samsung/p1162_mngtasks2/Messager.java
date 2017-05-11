package com.example.samsung.p1162_mngtasks2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by samsung on 11.05.2017.
 */

class Messager {

    private static final String LOG_TAG = "myLogs";

    public static final void sendTpAllRecipients(final Context context, final String message) {
        Log.d(LOG_TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static final void sendTpOnlyLog(final String message) {
        Log.d(LOG_TAG, message);
    }
}

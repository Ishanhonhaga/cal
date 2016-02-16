package com.nextstep.mcal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * This class is a special type of broadcast receiver that takes care of creating and managing a partial wake lock for your app.
 * Created by Ishan on 20/01/16.
 */
public class GcmBroadcastReciever extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ComponentName comp = new ComponentName(context.getPackageName(),GCMNotificationIntentService.class.getName());
        startWakefulService(context,(intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}

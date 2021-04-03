package com.zayarmyo.helloreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mainIntent=new Intent(context,HiddenActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mainIntent);
    }
}

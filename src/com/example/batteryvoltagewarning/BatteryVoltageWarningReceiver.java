package com.example.batteryvoltagewarning;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class BatteryVoltageWarningReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		String action = intent.getAction();
		// mContext = context;
		Intent newIntent = new Intent(context, TestService.class);
		if ("android.hardware.usb.action.USB_STATE".equals(intent.getAction())) {
			if (intent.getExtras().getBoolean("connected")) {
				context.startService(newIntent);
			}
		}

		if (Intent.ACTION_SHUTDOWN.equals(intent.getAction())) {
			context.stopService(newIntent);
		}

	}

}

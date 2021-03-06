package sk.jmmobilesoft.smartalarm.service;

import sk.jmmobilesoft.smartalarm.ClockRingActivity;
import sk.jmmobilesoft.smartalarm.helpers.Helper;
import sk.jmmobilesoft.smartalarm.log.Logger;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ClockBroadcastReciever extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Logger.serviceInfo("ClockBroadcastReciever: onRecieve");
		Helper.wakeLockOn(context);
		Intent clock = new Intent(context, ClockRingActivity.class);
		clock.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		clock.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		clock.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
		clock.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
		clock.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		clock.putExtras(intent);
		context.startActivity(clock);
	}

}

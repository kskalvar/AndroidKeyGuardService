package com.mycompany.androidkeyguard;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyScheduleReceiver extends BroadcastReceiver {

  // restart service every 15 seconds
  private static final long REPEAT_TIME = 1000 * 15;

  @Override
  public void onReceive(Context context, Intent intent) {
	  
	Log.i("MyScheduleReceiver", "onReceive");  
	  
    AlarmManager service = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent i = new Intent(context, MyStartServiceReceiver.class);
    PendingIntent pending = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_CANCEL_CURRENT);
    
	Calendar cal = Calendar.getInstance();
    
	// start 30 seconds after boot completed
    cal.add(Calendar.SECOND, 30);
    
    // fetch every 30 seconds
    // InexactRepeating allows Android to optimize the energy consumption
    service.setInexactRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), REPEAT_TIME, pending);

    // service.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), REPEAT_TIME, pending);

  }
}

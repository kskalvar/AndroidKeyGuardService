package com.mycompany.androidkeyguard;

import android.app.KeyguardManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class KeyGuardService extends Service {
	
	private final IBinder mBinder = new MyBinder();

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		if (getKeyGuardInstance()) {
			Log.i("KeyGuardService", "KeyGuard is Locked");

		} else {
			Log.i("KeyGuardService", "KeyGuard is Not Locked");
		}

		return Service.START_NOT_STICKY;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return mBinder;
	}

	public class MyBinder extends Binder {
		KeyGuardService getService() {
			return KeyGuardService.this;
		}
	}

	/**  
	 * Get an instance of the KeyGuard object. 
	 **/
	
	public boolean getKeyGuardInstance() {
		
		KeyguardManager mKeyGuardManager = (KeyguardManager) this.getApplicationContext().getSystemService(KEYGUARD_SERVICE);
		return mKeyGuardManager.isKeyguardLocked();
	}

}

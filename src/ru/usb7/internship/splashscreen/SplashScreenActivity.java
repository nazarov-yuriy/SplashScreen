package ru.usb7.internship.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {
	private static final int SPLASH_TIME_OUT = 2000;
	boolean showingMainActivityScheduled = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		Boolean t = (Boolean) getLastNonConfigurationInstance();
		if (t != null) {
			showingMainActivityScheduled = t.booleanValue();
		}

		if (!showingMainActivityScheduled) {
			showingMainActivityScheduled = true;
			new Handler().postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent intent = new Intent(SplashScreenActivity.this,
							MainActivity.class);
					startActivity(intent);
					finish();
				}
			}, SPLASH_TIME_OUT);
		}
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		return Boolean.valueOf(showingMainActivityScheduled);
	}
}

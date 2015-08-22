package com.copper.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.copper.app.GCMClientManager.RegistrationCompletedHandler;
import com.copper.prefs.MyPref;
import com.copper.utils.Config;
import com.copper.view.activity.LoginActivity;
import com.copper.view.activity.MainActivity;

public class AppStart extends Activity {

	private GCMClientManager pushClientManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_app_start);
		pushClientManager = new GCMClientManager(this, Config.GOOGLE_SENDER_ID);
		pushClientManager.registerIfNeeded(new RegistrationCompletedHandler() {
			@Override
			public void onSuccess(String registrationId,
					boolean isNewRegistration) {
				Toast.makeText(AppStart.this, registrationId,
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(String ex) {
				super.onFailure(ex);
			}
		});

		if (MyPref.getInstance(this).readPrefs(MyPref.USER_ID).length() <= 0
				|| MyPref.getInstance(this).readPrefs(MyPref.USER_ID)
						.equalsIgnoreCase("0"))
			launchNewActivity();
		else {
			startActivity(new Intent(AppStart.this, MainActivity.class));
			finish();
		}
	}

	/**
	 * Method is use for launch new activity.
	 */
	private void launchNewActivity() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				startActivity(new Intent(AppStart.this, LoginActivity.class));
				finish();
			}
		}).start();
	}
}

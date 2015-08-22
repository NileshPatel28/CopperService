package com.copper.communicator;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckNetworkStateClass {
	public static boolean isOnline(Context context) {

		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
 		if (activeNetwork != null) {
			return activeNetwork.isConnected();
		}
 		NetworkInfo wifiNetwork = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifiNetwork != null) {
			return wifiNetwork.isConnected();
		}
 		NetworkInfo mobileNetwork = cm
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mobileNetwork != null) {
			return mobileNetwork.isConnected();
		}
 		NetworkInfo otherNetwork = cm.getActiveNetworkInfo();
		if (otherNetwork != null) {
			return otherNetwork.isConnected();
		}

		return false;
	}

}

package com.copper.utils;

import android.support.v4.app.ListFragment;

import com.copper.app.R;
import com.copper.view.activity.MainActivity;
import com.copper.view.fragment.ClientListFragment;
 
public class FragmentManager {
	public static final int ADD_CLIENT_FRAGMENT = 01;
	private static ListFragment fragment;

	public static void doFragment(MainActivity actionBarActivity, int type) {
		switch (type) {
		case ADD_CLIENT_FRAGMENT:
			fragment = new ClientListFragment();
			break;

		default:
			break;
		}
		actionBarActivity.getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();

	}
}

package com.copper.view.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.prefs.MyPref;
import com.copper.view.activity.LoginActivity;
import com.copper.view.activity.MainActivity;

public class SampleListFragment extends ListFragment {
	int[] resourceID = { R.drawable.home, R.drawable.task, R.drawable.client,
			R.drawable.qute, R.drawable.job, R.drawable.map,
			R.drawable.expensa, R.drawable.inventery, R.drawable.property,
			R.drawable.inventery, R.drawable.inventery };

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list, null);
		view.findViewById(R.id.logutLayout).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						showDialog(getActivity(),
								getString(R.string.logoutMessage),
								getString(R.string.app_name));
					}
				});
		return view;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String title[] = getResources().getStringArray(R.array.sliderItemArray);
		MainActivity mainActivity = (MainActivity) getActivity();
		mainActivity.setTitle(title[position]);
		mainActivity.toggle();
		Fragment fragment = null;
		switch (position) {

		case 0:
			fragment = new DashBoardFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_DASHBOARD;
			break;
		case 1:
			fragment = new TaskFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_TASK;
			break;

		case 2:
			fragment = new ClientListFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_CLIENT;
			break;
		case 3:
			fragment = new QuoteListFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_QUOTE;
			break;
		case 4:
			fragment = new JobListFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_JOB;
			break;
		case 5:
			fragment = new DirectionMapChildFragment();
			mainActivity.CURRENT_TAB = MainActivity.TAB_ROUTE;
			break;
		case 7:
			mainActivity.CURRENT_TAB = MainActivity.TAB_INVENTORY;
			fragment = new InventoryListFragment();
			break;
		case 6:
			mainActivity.CURRENT_TAB = MainActivity.TAB_EXPANSES;
			fragment = new ExpansesListFragment();
			break;
		case 8:
			mainActivity.CURRENT_TAB = MainActivity.TAB_PROPERTY;
			fragment = new PropertyListFragment();
			break;
		case 9:
			mainActivity.CURRENT_TAB = MainActivity.TAB_INVOICE;
			fragment = new InvoiceListFragment();
			break;
		case 10:
			mainActivity.CURRENT_TAB = MainActivity.TAB_TIMESHEET;
			fragment = new TimeSheetFragment();

		default:
			break;
		}

		if (fragment != null)
			getActivity().getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, fragment).commit();
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setSliderItem();
	}

	private void setSliderItem() {
		SampleAdapter adapter = new SampleAdapter(getActivity());
		String[] array = getResources().getStringArray(R.array.sliderItemArray);

		for (int i = 0; i < array.length; i++) {
			adapter.add(new SampleItem(array[i], resourceID[i]));
		}
		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.side_row, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}

	public static void showDialog(final Context mContext,
			String response_message, String title) {

		AlertDialog.Builder builder = null;
		if (android.os.Build.VERSION.SDK_INT >= 11) {
			builder = new AlertDialog.Builder(mContext,
					AlertDialog.THEME_HOLO_LIGHT);
		} else {
			builder = new AlertDialog.Builder(mContext);
		}
		builder.setTitle(title);

		builder.setMessage("" + response_message)

		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				dialog.dismiss();
				Intent intent = new Intent(mContext, LoginActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				mContext.startActivity(intent);
				((Activity) mContext).finish();
				MyPref.getInstance(mContext).writePrefs(MyPref.USER_ID, "0");

			}
		}).setNegativeButton("Cancel", null);

		AlertDialog alert = builder.create();
		alert.setCanceledOnTouchOutside(true);
		alert.show();
		TextView messageText = (TextView) alert
				.findViewById(android.R.id.message);
		messageText.setGravity(Gravity.CENTER);
	}

}

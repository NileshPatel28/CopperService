package com.copper.view.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.TextView;

import com.copper.app.BaseActivity;
import com.copper.app.R;
import com.copper.bean.JobEntityBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.view.fragment.DashBoardFragment;

public class MainActivity extends BaseActivity implements CallBackListener {
	private View customActionView;
	private TextView titleTextView;
	public int CURRENT_TAB = 0;
	public static int TAB_DASHBOARD = 7;
	public static int TAB_TASK = 8;
	public static int TAB_CLIENT = 1;
	public static int TAB_QUOTE = 2;
	public static int TAB_JOB = 3;
	public static int TAB_EXPENSES = 4;
	public static int TAB_INVENTORY = 5;
	public static int TAB_EXPANSES = 6;
	public static int TAB_ROUTE = 9;
	public static int TAB_PROPERTY = 10;
	public static int TAB_INVOICE = 11;
	public static int TAB_TIMESHEET = 12;

	public MainActivity() {
		super(R.string.app_name);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addActionBar();
		String title[] = getResources().getStringArray(R.array.sliderItemArray);
		setTitle(title[0]);
		addFragment();
	}

	private void addFragment() {
		DashBoardFragment fragment = new DashBoardFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(MainActivity.this).inflate(
				R.layout.actionbar_layout, null);
		ColorDrawable colorDrawable = new ColorDrawable(getResources()
				.getColor(R.color.blue));
		getSupportActionBar().setBackgroundDrawable(colorDrawable);
		getSupportActionBar().setCustomView(customActionView);

		getSupportActionBar().getCustomView().findViewById(R.id.setting_btn)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// startActivity(new Intent(MainActivity.this,
						// CreateClientActivity.class));
						if (CURRENT_TAB == TAB_CLIENT) {
							startActivity(new Intent(MainActivity.this,
									CreateClientActivity.class));

						} else if (CURRENT_TAB == TAB_JOB) {
							startActivity(new Intent(MainActivity.this,
									CreateNewJobActivity.class));

						} else if (CURRENT_TAB == TAB_QUOTE) {
							startActivity(new Intent(MainActivity.this,
									CreateQouteActivity.class));

						} else if (CURRENT_TAB == TAB_INVENTORY) {
							startActivity(new Intent(MainActivity.this,
									CreateInventoryActivity.class));

						}

						else if (CURRENT_TAB == TAB_EXPANSES) {
							startActivity(new Intent(MainActivity.this,
									CreateNewExpensesActivity.class));

						} else if (CURRENT_TAB == TAB_TASK) {
							startActivity(new Intent(MainActivity.this,
									CreateTaskActivity.class));

						} else if (CURRENT_TAB == TAB_PROPERTY) {
							startActivity(new Intent(MainActivity.this,
									CreatePropertyActivity.class));

						} else if (CURRENT_TAB == TAB_INVOICE) {
							startActivity(new Intent(MainActivity.this,
									CreateInvoicesActivity.class));

						} else if (CURRENT_TAB == TAB_TIMESHEET) {
							startActivity(new Intent(MainActivity.this,
									CreateTimeSheetActivity.class));

						} else {
							showPopup(v);

						}
					}
				});
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().getCustomView().findViewById(R.id.menu_icon)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						toggle();
					}
				});

		titleTextView = (TextView) findViewById(R.id.title_text);

	}

	public void setTitle(String text) {
		titleTextView.setText(text);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		JobEntityBean jobEntityBean = (JobEntityBean) object;
		Log.v(ConstantLib.LOG, "JOB SIZE :: " + jobEntityBean.getJob().size());
	}

	public void showPopup(View v) {
		/** Instantiating PopupMenu class */
		PopupMenu popup = new PopupMenu(getBaseContext(), v);

		/** Adding menu items to the popumenu */
		popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

		/** Defining menu item click listener for the popup menu */
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				if (item.getTitle().equals(getString(R.string.action1))) {
					startActivity(new Intent(MainActivity.this,
							CreateClientActivity.class));
				} else if (item.getTitle().equals(getString(R.string.action2))) {
					startActivity(new Intent(MainActivity.this,
							CreateQouteActivity.class));

				}

				else if (item.getTitle().equals(getString(R.string.action3))) {
					startActivity(new Intent(MainActivity.this,
							CreateNewJobActivity.class));

				} else if (item.getTitle().equals(getString(R.string.action4))) {
					startActivity(new Intent(MainActivity.this,
							CreateInventoryActivity.class));

				} else if (item.getTitle().equals(getString(R.string.action5))) {
					startActivity(new Intent(MainActivity.this,
							CreateNewExpensesActivity.class));
				} else if (item.getTitle().equals(getString(R.string.action7))) {
					startActivity(new Intent(MainActivity.this,
							CreatePropertyActivity.class));

				} else if (item.getTitle().equals(getString(R.string.action8))) {
					startActivity(new Intent(MainActivity.this,
							CreateInvoicesActivity.class));

				} else if (item.getTitle().equals(getString(R.string.action9))) {
					startActivity(new Intent(MainActivity.this,
							CreateTimeSheetActivity.class));

				}

				return true;
			}
		});

		/** Showing the popup menu */
		popup.show();

	}
}

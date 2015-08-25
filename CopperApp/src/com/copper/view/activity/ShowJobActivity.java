package com.copper.view.activity;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.PropertyBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class ShowJobActivity extends ActionBarActivity implements
		CallBackListener {
	private View customActionView;
	private TextView nameTextView, addressTextView;
	private CheckBox checkBox;
	private ClientChildBean clientChildBean;
	private TextView startDateTextView, endDateTextView;
	private Context mContext;
	private CheckBox isChecked;
	public Calendar calendar;
	private DatePickerDialog dialog = null;
	private int type = 0;
	private TextView selectPRopertyTextView;
	private EditText DescriptionEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_job);
		calendar = Calendar.getInstance();

		mContext = this;
		addActionBar();

		clientChildBean = (ClientChildBean) getIntent().getExtras().get(
				ConstantLib.CLIENTS);
		init();
		findViewById(R.id.saveButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				RequestMethod.createJobs(mContext, ""
						+ DescriptionEditText.getText().toString().trim(), ""
						+ checkBox.isChecked(), startDateTextView.getText()
						.toString().trim(), endDateTextView.getText()
						.toString().trim(), "", "on off", "1", propertyID,
						MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID),
						ShowJobActivity.this, false);
			}
		});
	}

	private class PickDate implements DatePickerDialog.OnDateSetListener {

		public PickDate() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			view.updateDate(year, monthOfYear, dayOfMonth);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, monthOfYear);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			calendar = cal;
			if (type == 1)
				startDateTextView.setText("" + calendar.getTime());
			else if (type == 2)
				endDateTextView.setText("" + calendar.getTime());

			dialog.hide();
		}

	}

	void init() {
		dialog = new DatePickerDialog(this, new PickDate(),
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));
		DescriptionEditText = (EditText) findViewById(R.id.DescriptionEditText);

		startDateTextView = (TextView) findViewById(R.id.startDate);
		endDateTextView = (TextView) findViewById(R.id.endDate);
		selectPRopertyTextView = (TextView) findViewById(R.id.selectProperty);
		selectPRopertyTextView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Utils.ID = clientChildBean.getId();
				RequestMethod.getClientProperty(
						ShowJobActivity.this,
						MyPref.getInstance(ShowJobActivity.this).readPrefs(
								MyPref.USER_ID), ShowJobActivity.this);

			}
		});

		startDateTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.show();
				type = 1;
			}
		});
		endDateTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.show();
				type = 2;

			}
		});

		nameTextView = (TextView) findViewById(R.id.clientName);
		addressTextView = (TextView) findViewById(R.id.clientAddress);
		checkBox = (CheckBox) findViewById(R.id.isChecked);
		nameTextView.setText(clientChildBean.getFirst_name() + " "
				+ clientChildBean.getLast_name());
		checkBox.setText(clientChildBean.getFirst_name());
		addressTextView.setText(clientChildBean.getCompany_name() + " "
				+ clientChildBean.getCity() + " " + clientChildBean.getState()
				+ clientChildBean.getCountry());

	}

	String propertyID = "0";

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_CREATE_JOB) {
			RequestMethod.getJob(mContext, MyPref.getInstance(mContext)
					.readPrefs(MyPref.USER_ID), this);
		} else if (taskType == RequestResponseType.REQUEST_TYPE_GET_CLIENT_PROPERTY) {

			if (object != null) {
				final ArrayList<PropertyBean> list = (ArrayList<PropertyBean>) object;
				if (list.size() > 0) {
					final String[] items = new String[list.size()];
					for (int i = 0; i < items.length; i++) {
						items[i] = list.get(i).getStreet();
					}

					new AlertDialog.Builder(ShowJobActivity.this)
							.setTitle(getString(R.string.app_name))
							.setSingleChoiceItems(items, 0,
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											// TODO Auto-generated method stub
											propertyID = list.get(arg1).getId();
											arg0.dismiss();
											selectPRopertyTextView.setText(""
													+ items[arg1]);
										}
									}).create().show();
				} else {
					Toast.makeText(
							mContext,
							"Property not available Please create propery first.",
							1).show();

				}
			}

		} else {
			Toast.makeText(mContext, "Job create successfully", 1).show();
			finish();

		}

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(ShowJobActivity.this).inflate(
				R.layout.actionbar_layout, null);
		ColorDrawable colorDrawable = new ColorDrawable(getResources()
				.getColor(R.color.blue));

		getSupportActionBar().setBackgroundDrawable(colorDrawable);
		getSupportActionBar().setCustomView(customActionView);
		getSupportActionBar().getCustomView().findViewById(R.id.setting_btn)
				.setVisibility(View.GONE);
		getSupportActionBar().getCustomView().findViewById(R.id.menu_icon)
				.setVisibility(View.GONE);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		TextView titleTextView = (TextView) findViewById(R.id.title_text);
		titleTextView.setText("Create Job");
		Utils.backAction(this);

	}

}

package com.copper.view.activity;

import java.util.Calendar;

import com.copper.app.R;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.utils.Utils;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class CreateTimeSheetActivity extends ActionBarActivity implements
		CallBackListener {

	private View customActionView;
	private Context mContext;
	private EditText notes;
	private TextView startTime, endTime;
	private CheckBox isBillable, isAutostartTimer;
	protected int type;
	Calendar calendar, calendar2;

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		finish();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;
		calendar = Calendar.getInstance();
		calendar2 = Calendar.getInstance();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_time_sheet);
		notes = (EditText) findViewById(R.id.notes);
		startTime = (TextView) findViewById(R.id.startTime);
		endTime = (TextView) findViewById(R.id.endTime);
		isBillable = (CheckBox) findViewById(R.id.isBillable);
		isAutostartTimer = (CheckBox) findViewById(R.id.autostartTimer);

		addActionBar();

		findViewById(R.id.startTime).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(mContext,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker arg0, int hour,
									int minute) {
								// TODO Auto-generated method stub
								startTime.setText("" + hour + ":" + minute);
								calendar.set(Calendar.HOUR, hour);
								calendar.set(Calendar.MINUTE, minute);

							}
						}, hour, minute, false);

				mTimePicker.setTitle("Select Time");
				mTimePicker.show();

			}
		});

		findViewById(R.id.endTime).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Calendar mcurrentTime = Calendar.getInstance();
				int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
				int minute = mcurrentTime.get(Calendar.MINUTE);
				TimePickerDialog mTimePicker;
				mTimePicker = new TimePickerDialog(mContext,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker arg0, int hour,
									int minute) {
								// TODO Auto-generated method stub
								endTime.setText("" + hour + ":" + minute);
								calendar2.set(Calendar.HOUR, hour);
								calendar2.set(Calendar.MINUTE, minute);
							}
						}, hour, minute, false);

				mTimePicker.setTitle("Select Time");
				mTimePicker.show();

			}
		});

		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				saveRecord();
			}
		});
	}

	void saveRecord() {
		if (notes.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter note.", 1).show();
		}
		if (startTime.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select start time.", 1).show();

		} else if (endTime.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select end time.", 1).show();
		} else {
			long time = calendar2.getTimeInMillis()
					- calendar.getTimeInMillis();
			String times = "";
			if (time > 0) {
				times = Utils.getDuration(time);
			}
			RequestMethod.createTimesheet(mContext, notes.getText().toString()
					.trim(), startTime.getText().toString().trim(), endTime
					.getText().toString().trim(), "" + isBillable.isChecked(),
					"" + isAutostartTimer.isChecked(), times,
					CreateTimeSheetActivity.this, false);
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(CreateTimeSheetActivity.this)
				.inflate(R.layout.actionbar_layout, null);
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
		titleTextView.setText("TimeSheet");
	}
}

package com.copper.view.activity;

import java.util.Calendar;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.PropertyBean;
import com.copper.bean.QuoteChildBean;
import com.copper.bean.TaskChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.utils.Utils;

public class EditTaskActivity extends ActionBarActivity implements
		CallBackListener {
	private Context mContext;
	private View customActionView;
	private EditText title, description;
	private TextView startDate, endDate, startTime, endTime;
	private DatePickerDialog dialog = null;
	private Calendar calendar;
	protected int type;
	private TaskChildBean taskChildBean;

	void setData() {
		title.setText(taskChildBean.getTitle());
		description.setText(taskChildBean.getDescription());
		startDate.setText(taskChildBean.getStart_at_date());
		endDate.setText(taskChildBean.getEnd_at_date());
		startTime.setText(Utils.formatDateToTime(taskChildBean
				.getStart_at_time()));
		endTime.setText(Utils.formatDateToTime(taskChildBean.getEnd_at_time()));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;
		calendar = Calendar.getInstance();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_task);
		title = (EditText) findViewById(R.id.taskTitle);
		description = (EditText) findViewById(R.id.taskDescription);
		startDate = (TextView) findViewById(R.id.startDate);
		endDate = (TextView) findViewById(R.id.endDate);
		startTime = (TextView) findViewById(R.id.startTime);
		endTime = (TextView) findViewById(R.id.endTime);

		taskChildBean = (TaskChildBean) getIntent().getExtras().get(
				ConstantLib.BASIC_TASKS);
		setData();
		addActionBar();
		dialog = new DatePickerDialog(this, new PickDate(),
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		findViewById(R.id.startDate).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.show();
				type = 1;

			}
		});

		findViewById(R.id.endDate).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.show();
				type = 2;

			}
		});

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
		findViewById(R.id.delete).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Utils.deleteDialog(mContext,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								new DeleteCommunicator(mContext,
										ConstantLib.BASIC_TASKS, taskChildBean
												.getId(), new DeleteListener() {

											@Override
											public void onDelete() {
												// TODO Auto-generated method
												// stub
												finish();

											}
										});
							}
						});
			}
		});
	}

	void saveRecord() {
		if (title.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter title.", 1).show();
		} else if (description.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter description.", 1).show();
		} else if (startDate.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select start date.", 1).show();

		} else if (endDate.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select end date.", 1).show();

		} else if (startTime.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select start time.", 1).show();

		} else if (endTime.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please select end time.", 1).show();
		} else {
			Utils.ID = taskChildBean.getId();
			RequestMethod.updateBasicTask(mContext, title.getText().toString()
					.trim(), "1", startDate.getText().toString().trim(),
					startTime.getText().toString().trim(), endDate.getText()
							.toString().trim(), endTime.getText().toString()
							.trim(), description.getText().toString().trim(),
					this);
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditTaskActivity.this).inflate(
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
		titleTextView.setText("Update Task");
		Utils.backAction(this);

	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_UPDATE_TASK) {
			if (object != null) {
				TaskChildBean bean = (TaskChildBean) object;
				finish();
			}
		}
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
				startDate.setText(year + "-" + (monthOfYear + 1) + "-"
						+ dayOfMonth);
			else if (type == 2)
				endDate.setText(year + "-" + (monthOfYear + 1) + "-"
						+ dayOfMonth);

			dialog.hide();
		}

	}

}

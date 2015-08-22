package com.copper.view.activity;

import java.util.Calendar;
import android.app.ActionBar;
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
import com.copper.bean.JobChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class EditJobActivity extends ActionBarActivity implements
		CallBackListener {
	private View customActionView;
	private CheckBox checkBox;
	private JobChildBean jobChildBean;
	private TextView startDateTextView, endDateTextView;
	private Context mContext;
	private CheckBox isChecked;
	public Calendar calendar;
	private DatePickerDialog dialog = null;
	private int type = 0;
	private EditText DescriptionEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_job);
		calendar = Calendar.getInstance();
		mContext = this;
		addActionBar();
		jobChildBean = (JobChildBean) getIntent().getExtras().get(
				ConstantLib.JOBS);
		init();
		setRecord();
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Utils.ID = jobChildBean.getId();
				RequestMethod.createJobs(mContext, ""
						+ DescriptionEditText.getText().toString(), ""
						+ jobChildBean.getScheduled(), startDateTextView
						.getText().toString().trim(), endDateTextView.getText()
						.toString().trim(), "", "on off", "1", "1", MyPref
						.getInstance(mContext).readPrefs(MyPref.USER_ID),
						EditJobActivity.this, true);
			}
		});
		findViewById(R.id.delete).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Utils.deleteDialog(EditJobActivity.this,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								new DeleteCommunicator(EditJobActivity.this,
										ConstantLib.JOBS, jobChildBean.getId(),
										new DeleteListener() {

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

	private void setRecord() {
		startDateTextView.setText("" + jobChildBean.getStart_date());
		endDateTextView.setText("" + jobChildBean.getEnd_date());
		DescriptionEditText.setText("" + jobChildBean.getDescription());
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

		startDateTextView = (TextView) findViewById(R.id.startDate);
		endDateTextView = (TextView) findViewById(R.id.endDate);
		DescriptionEditText = (EditText) findViewById(R.id.DescriptionEditText);

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

		checkBox = (CheckBox) findViewById(R.id.isChecked);

	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_CREATE_JOB) {
			RequestMethod.getJob(mContext, MyPref.getInstance(mContext)
					.readPrefs(MyPref.USER_ID), this);
		} else {
			Toast.makeText(mContext, "Job updated successfully", 1).show();
			finish();

		}

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditJobActivity.this).inflate(
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
		titleTextView.setText("Update Job");
	}

}

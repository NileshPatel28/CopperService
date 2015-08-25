package com.copper.view.activity;

import java.util.ArrayList;
import java.util.Calendar;

import com.copper.app.R;
import com.copper.bean.JobChildBean;
import com.copper.bean.JobEntityBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

public class CreateNewExpensesActivity extends ActionBarActivity implements
		CallBackListener {
	private CheckBox isDistance;
	private EditText merchant, detail, total;
	private TextView job, category, dates;
	private RadioGroup radioGroup;
	private RadioButton radioButton1, radioButton2;
	private Context mContext;
	private DatePickerDialog dialog = null;
	private Calendar calendar;
	private int position;
	private String job_id = "1";
	private String category_id = "1";
	private String expense_type = "1";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_create_new_expenses);
		addActionBar();
		merchant = (EditText) findViewById(R.id.merchentEditText);
		detail = (EditText) findViewById(R.id.detailEditText);
		total = (EditText) findViewById(R.id.totalEditText);

		radioGroup = (RadioGroup) findViewById(R.id.rgb);
		radioButton1 = (RadioButton) findViewById(R.id.rd1);
		radioButton2 = (RadioButton) findViewById(R.id.rd2);

		category = (TextView) findViewById(R.id.selectCategary);
		job = (TextView) findViewById(R.id.selectJob);

		calendar = Calendar.getInstance();

		category.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String items[] = { "km", "mi" };
				AlertDialog.Builder builder = null;

				if (android.os.Build.VERSION.SDK_INT >= 11) {
					builder = new AlertDialog.Builder(mContext,
							AlertDialog.THEME_HOLO_LIGHT);
				} else {
					builder = new AlertDialog.Builder(mContext);
				}
				builder.setTitle(getString(R.string.app_name));

				builder.setSingleChoiceItems(items, position,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								arg0.dismiss();
								position = arg1;
							}
						});
				final AlertDialog alert = builder.create();

				alert.setCanceledOnTouchOutside(true);
				alert.show();
			}
		});

		dates = (TextView) findViewById(R.id.dates);
		findViewById(R.id.dates).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.show();
			}
		});
		findViewById(R.id.selectJob).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				RequestMethod.getJob(CreateNewExpensesActivity.this,
						MyPref.getInstance(CreateNewExpensesActivity.this)
								.readPrefs(MyPref.USER_ID),
						CreateNewExpensesActivity.this);

			}
		});
		dialog = new DatePickerDialog(this, new PickDate(),
				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub

			}
		});
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int selectedId = radioGroup.getCheckedRadioButtonId();
				boolean isBillable;

				if (selectedId == radioButton2.getId()) {
					isBillable = true;
				} else {
					isBillable = false;
				}
				if (dates.length() <= 0) {
					Toast.makeText(mContext, "Please select date first.", 1)
							.show();
				} else if (merchant.getText().toString().trim().length() <= 0) {
					Toast.makeText(mContext, "Please enter merchant name.", 1)
							.show();

				} else if (detail.getText().toString().trim().length() <= 0) {
					Toast.makeText(mContext, "Please enter merchant detail.", 1)
							.show();

				} else if (detail.getText().toString().trim().length() <= 0) {
					Toast.makeText(mContext, "Please enter merchant detail.", 1)
							.show();

				} else {
					RequestMethod.createExpanses(
							mContext,
							MyPref.getInstance(mContext).readPrefs(
									MyPref.USER_ID), "" + calendar.getTime(),
							merchant.getText().toString().trim(), detail
									.getText().toString().trim(), total
									.getText().toString().trim(), ""
									+ isBillable, job_id, category_id,
							expense_type, CreateNewExpensesActivity.this, false);
				}
			}
		});
	}

	private class PickDate implements DatePickerDialog.OnDateSetListener {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			view.updateDate(year, monthOfYear, dayOfMonth);
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, monthOfYear);
			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
			calendar = cal;
			dates.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
			dialog.hide();
		}

	}

	ArrayList<JobChildBean> arrayList = new ArrayList<JobChildBean>();
	private View customActionView;

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		switch (taskType) {
		case RequestResponseType.REQUEST_TYPE_CREATE_EXPANSES:
			finish();
			break;
		case RequestResponseType.REQUEST_TYPE_JOB:
			if (object != null) {
				JobEntityBean jobEntityBean = (JobEntityBean) object;
				arrayList = jobEntityBean.getJob();

			}
			if (arrayList.size() > 0) {
				String items[] = new String[arrayList.size()];
				for (int i = 0; i < arrayList.size(); i++) {
					items[i] = arrayList.get(i).getDescription();
				}
				AlertDialog.Builder builder = null;

				if (android.os.Build.VERSION.SDK_INT >= 11) {
					builder = new AlertDialog.Builder(mContext,
							AlertDialog.THEME_HOLO_LIGHT);
				} else {
					builder = new AlertDialog.Builder(mContext);
				}
				builder.setTitle(getString(R.string.app_name));

				builder.setSingleChoiceItems(items, position,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								arg0.dismiss();
								position = arg1;
								job.setText(arrayList.get(arg1)
										.getDescription());
								job_id = arrayList.get(arg1).getId();
							}
						});
				final AlertDialog alert = builder.create();

				alert.setCanceledOnTouchOutside(true);
				alert.show();
			} else {
				Toast.makeText(mContext, "No job available.", 1).show();
			}
			break;

		default:
			break;
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(CreateNewExpensesActivity.this)
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
		titleTextView.setText("Create Expanses");
		Utils.backAction(this);

	}

}

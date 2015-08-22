package com.copper.view.activity;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.JobEntityBean;
import com.copper.bean.PropertyBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class CreatePropertyActivity extends ActionBarActivity implements
		CallBackListener {
	private Context mContext;
	private String items[] = { "Mr.", "Ms.", "Mrs.", "Miss.", "Dr." };
	private int position = 0;
	private View customActionView;
	private EditText street, city, state, country, zipcode;
	private TextView clientDropdown;
	ArrayList<ClientChildBean> arrayList = new ArrayList<ClientChildBean>();
	protected String p_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_property);
		street = (EditText) findViewById(R.id.streetEditText);
		city = (EditText) findViewById(R.id.cityEditText);
		state = (EditText) findViewById(R.id.stateEditText);
		country = (EditText) findViewById(R.id.countryEditText);
		zipcode = (EditText) findViewById(R.id.zipcodeEditText);
		clientDropdown = (TextView) findViewById(R.id.selectClient);
		addActionBar();
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				saveRecord();
			}
		});
		findViewById(R.id.selectClient).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub

						RequestMethod.getClient(CreatePropertyActivity.this,
								MyPref.getInstance(CreatePropertyActivity.this)
										.readPrefs(MyPref.USER_ID),
								CreatePropertyActivity.this);

					}
				});

	}

	void saveRecord() {
		if (street.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter street name.", 1).show();

		} else if (city.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter city name.", 1).show();

		} else if (state.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter state name.", 1).show();

		} else if (country.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter country name.", 1).show();

		}

		else {
			RequestMethod.createProperty(mContext, "", street.getText()
					.toString().trim(), city.getText().toString().trim(), state
					.getText().toString().trim(), zipcode.getText().toString()
					.trim(), country.getText().toString().trim(), p_id, this,false);
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(CreatePropertyActivity.this)
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
		titleTextView.setText("Create Property");
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_CREATE_PROPERTY) {
			finish();
		} else if (taskType == RequestResponseType.REQUEST_TYPE_CLIENT) {
			if (object != null) {
				ClientEntityBean bean = (ClientEntityBean) object;
				arrayList = bean.getClientList();

			}
			if (arrayList.size() > 0) {
				String items[] = new String[arrayList.size()];
				for (int i = 0; i < arrayList.size(); i++) {
					items[i] = arrayList.get(i).getFirst_name()
							+ arrayList.get(i).getLast_name();
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
								clientDropdown.setText(arrayList.get(arg1)
										.getFirst_name()
										+ " "
										+ arrayList.get(arg1).getLast_name());
								p_id = arrayList.get(arg1).getId();
							}
						});
				final AlertDialog alert = builder.create();

				alert.setCanceledOnTouchOutside(true);
				alert.show();
			} else {
				Toast.makeText(mContext, "No job available.", 1).show();
			}
		}
	}

}

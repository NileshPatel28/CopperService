package com.copper.view.activity;

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
import com.copper.bean.PropertyBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;
import com.copper.view.fragment.ClientListFragment;

public class EditClientActivity extends ActionBarActivity implements
		CallBackListener {
	private Context mContext;
	private String items[] = { "Mr.", "Ms.", "Mrs.", "Miss.", "Dr." };
	private int position = 0;
	private View customActionView;
	private EditText firstName, lastName, company, email, mobileNo, street,
			city, state, country, zipcode;
	private TextView initial;
	private ClientChildBean clientChildBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_client);
		firstName = (EditText) findViewById(R.id.firstNameEditText);
		lastName = (EditText) findViewById(R.id.lastNameEditText);
		company = (EditText) findViewById(R.id.companyNameEditText);
		email = (EditText) findViewById(R.id.emailEditText);
		mobileNo = (EditText) findViewById(R.id.mobileEditText);
		// street = (EditText) findViewById(R.id.streetEditText);
		// city = (EditText) findViewById(R.id.cityEditText);
		// state = (EditText) findViewById(R.id.stateEditText);
		// country = (EditText) findViewById(R.id.countryEditText);
		// zipcode = (EditText) findViewById(R.id.zipcodeEditText);
		initial = (TextView) findViewById(R.id.intialDropDown);
		clientChildBean = (ClientChildBean) getIntent().getExtras().get(
				ConstantLib.CLIENTS);
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
										ConstantLib.CLIENTS, clientChildBean
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
		setData();
		addActionBar();
		findViewById(R.id.intialDropDown).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						DropDown();
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

	void setData() {
		firstName.setText(clientChildBean.getFirst_name());
		lastName.setText(clientChildBean.getLast_name());
		company.setText(clientChildBean.getCompany_name());
		email.setText(clientChildBean.getEmail());
		mobileNo.setText(clientChildBean.getMobile_number());
		// street.setText(clientChildBean.getStreet1());
		// city.setText(clientChildBean.getCity());
		// state.setText(clientChildBean.getState());
		// country.setText(clientChildBean.getCountry());
		// zipcode.setText(clientChildBean.getZip_code());
		initial.setText(clientChildBean.getInitial());

	}

	void saveRecord() {
		if (firstName.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter first name.", 1).show();
		} else if (firstName.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter first name.", 1).show();

		} else if (lastName.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter last name.", 1).show();

		} else if (email.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter email name.", 1).show();

		} else if (!Utils.validate(email.getText().toString().trim())) {
			Toast.makeText(mContext, "Please enter valid email .", 1).show();

		} else if (company.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter company name.", 1).show();

		} else if (mobileNo.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter mobile number name.", 1)
					.show();

		}
		// else if (street.getText().toString().trim().length() <= 0) {
		// Toast.makeText(mContext, "Please enter street name.", 1).show();
		//
		// } else if (city.getText().toString().trim().length() <= 0) {
		// Toast.makeText(mContext, "Please enter city name.", 1).show();
		//
		// } else if (state.getText().toString().trim().length() <= 0) {
		// Toast.makeText(mContext, "Please enter state name.", 1).show();
		//
		// } else if (country.getText().toString().trim().length() <= 0) {
		// Toast.makeText(mContext, "Please enter country name.", 1).show();
		//
		// }

		else {
			Utils.ID = clientChildBean.getId();
			RequestMethod.updateClient(mContext, items[position], firstName
					.getText().toString().trim(), lastName.getText().toString()
					.trim(), email.getText().toString().trim(), company
					.getText().toString().trim(), mobileNo.getText().toString()
					.trim(), this);
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditClientActivity.this)
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
		titleTextView.setText("Update Client");
	}

	void DropDown() {

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
						initial.setText(items[arg1]);
						position = arg1;
					}
				});
		final AlertDialog alert = builder.create();

		alert.setCanceledOnTouchOutside(true);
		alert.show();
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_UPDATE_CLIENT) {
			if (object != null) {
				ClientChildBean clientChildBean = (ClientChildBean) object;
				if (clientChildBean.getId().length() > 0) {
					finish();
				}
				// RequestMethod.createProperty(mContext, "", street.getText()
				// .toString().trim(), city.getText().toString().trim(),
				// state.getText().toString().trim(), zipcode.getText()
				// .toString().trim(), country.getText()
				// .toString().trim(), clientChildBean.getId(),
				// this);
			}
		} else {
			PropertyBean propertyBean = (PropertyBean) object;
			Log.v("N", "Property :: " + propertyBean);
		}
	}
}

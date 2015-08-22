package com.copper.view.activity;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.bean.PropertyBean;
import com.copper.bean.QuoteChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;

import com.copper.prefs.MyPref;

public class CreateQouteActivity extends ActionBarActivity implements
		CallBackListener {
	private View customActionView;
	private EditText quote_order, tax, discount, work_order_name,
			work_order_description, client_message, quantity, unitCost;
	private String propertyId = "0";
	private TextView selectProperty;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_quote);
		selectProperty = (TextView) findViewById(R.id.selectProperty);
		quote_order = (EditText) findViewById(R.id.quote_order);
		tax = (EditText) findViewById(R.id.tax);
		discount = (EditText) findViewById(R.id.discount);
		work_order_name = (EditText) findViewById(R.id.work_order_name);
		work_order_description = (EditText) findViewById(R.id.work_order_description);
		client_message = (EditText) findViewById(R.id.client_message);
		quantity = (EditText) findViewById(R.id.quantity);
		unitCost = (EditText) findViewById(R.id.untiCost);
 
		addActionBar();
		findViewById(R.id.selectProperty).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						RequestMethod.getProperty(CreateQouteActivity.this,
								MyPref.getInstance(CreateQouteActivity.this)
										.readPrefs(MyPref.USER_ID),
								CreateQouteActivity.this);
					}
				});
		findViewById(R.id.saveButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (work_order_name.getText().toString().trim().length() <= 0) {
					showToast("Please enter order name.");
				}
				if (work_order_description.getText().toString().trim().length() <= 0) {
					showToast("Please enter description.");

				} else {
					RequestMethod.createQuote(CreateQouteActivity.this,
							propertyId,
							quote_order.getText().toString().trim(), tax
									.getText().toString().trim(), discount
									.getText().toString().trim(),
							work_order_name.getText().toString().trim(),
							work_order_description.getText().toString().trim(),
							client_message.getText().toString().trim(),
							quantity.getText().toString().trim(),
							unitCost.getText().toString().trim(),
							CreateQouteActivity.this, false);
				}
			}
		});
	}

	private void showToast(String message) {
		Toast.makeText(this, message, 1).show();
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(CreateQouteActivity.this)
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
		titleTextView.setText("Create Quote");
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_CREATE_QUOTE) {
			if (object != null) {
				QuoteChildBean quoteChildBean = (QuoteChildBean) object;
				if (quoteChildBean != null) {
					if (quoteChildBean.getId() != null) {
						if (!quoteChildBean.getId().equalsIgnoreCase("null")
								&& quoteChildBean.getId().length() > 0) {
							showToast("Quote created successfully");
							finish();
						}
					}
				}
			}
		} else {
			if (object != null) {
				final ArrayList<PropertyBean> list = (ArrayList<PropertyBean>) object;
				if (list.size() > 0) {
					final String[] items = new String[list.size()];
					for (int i = 0; i < items.length; i++) {
						items[i] = list.get(i).getStreet();
					}

					new AlertDialog.Builder(CreateQouteActivity.this)
							.setTitle(getString(R.string.app_name))
							.setSingleChoiceItems(items, 0,
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											// TODO Auto-generated method stub
											arg0.dismiss();
											selectProperty.setText(""
													+ items[arg1]);
											propertyId = list.get(arg1).getId();
										}
									}).create().show();
				} else {
					showToast("Property not available Please create propery first.");
				}
			}
		}
	}
}

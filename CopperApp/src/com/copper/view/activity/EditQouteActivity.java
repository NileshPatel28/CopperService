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
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;

import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class EditQouteActivity extends ActionBarActivity implements
		CallBackListener {
	private View customActionView;
	private EditText quote_order, tax, discount, work_order_name,
			work_order_description, client_message;
	private QuoteChildBean quoteChildBean;
	private EditText quantity;
	private EditText unitCost;

	void setData() {
		quote_order.setText(quoteChildBean.getQuote_order());
		tax.setText(quoteChildBean.getTax());
		discount.setText(quoteChildBean.getDiscount());
		work_order_name.setText(quoteChildBean.getName());
		work_order_description.setText(quoteChildBean.getDescription());
		client_message.setText(quoteChildBean.getClient_message());
		quantity.setText(quoteChildBean.getQuantity());
		unitCost.setText(quoteChildBean.getUnit_cost());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_quote);
		quote_order = (EditText) findViewById(R.id.quote_order);
		tax = (EditText) findViewById(R.id.tax);
		discount = (EditText) findViewById(R.id.discount);
		quantity = (EditText) findViewById(R.id.quantity);
		unitCost = (EditText) findViewById(R.id.untiCost);

		work_order_name = (EditText) findViewById(R.id.work_order_name);
		work_order_description = (EditText) findViewById(R.id.work_order_description);
		client_message = (EditText) findViewById(R.id.client_message);
		quoteChildBean = (QuoteChildBean) getIntent().getExtras().get(
				ConstantLib.QUOTES);
		setData();
		addActionBar();
		findViewById(R.id.selectProperty).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						RequestMethod.getProperty(EditQouteActivity.this,
								MyPref.getInstance(EditQouteActivity.this)
										.readPrefs(MyPref.USER_ID),
								EditQouteActivity.this);
					}
				});
		findViewById(R.id.save).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				if (work_order_name.getText().toString().trim().length() <= 0) {
					showToast("Please enter order name.");
				}

				if (work_order_description.getText().toString().trim().length() <= 0) {
					showToast("Please enter description.");
				} else {

					Utils.ID = quoteChildBean.getId();
					RequestMethod.createQuote(EditQouteActivity.this, "1",
							quote_order.getText().toString().trim(), tax
									.getText().toString().trim(), discount
									.getText().toString().trim(),
							work_order_name.getText().toString().trim(),
							work_order_description.getText().toString().trim(),
							client_message.getText().toString().trim(),
							quantity.getText().toString().trim(), unitCost
									.getText().toString().trim(),
							EditQouteActivity.this, true);

				}
			}
		});
		findViewById(R.id.delete).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Utils.deleteDialog(EditQouteActivity.this,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								new DeleteCommunicator(EditQouteActivity.this,
										ConstantLib.QUOTES, quoteChildBean
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

	private void showToast(String message) {
		Toast.makeText(this, message, 1).show();
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditQouteActivity.this).inflate(
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
		titleTextView.setText("Update Quote");
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		if (taskType == RequestResponseType.REQUEST_TYPE_UPDATE_QUOTE) {
			showToast("Quote updated successfully");
			finish();
		} else {
			if (object != null) {
				ArrayList<PropertyBean> list = (ArrayList<PropertyBean>) object;
				if (list.size() > 0) {
					String[] items = new String[list.size()];
					for (int i = 0; i < items.length; i++) {
						items[i] = list.get(i).getStreet();
					}

					new AlertDialog.Builder(EditQouteActivity.this)
							.setTitle(getString(R.string.app_name))
							.setSingleChoiceItems(items, 0,
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											// TODO Auto-generated method stub
										}
									}).create().show();
				} else {
					showToast("Property not available Please create propery first.");
				}
			}
		}
	}
}

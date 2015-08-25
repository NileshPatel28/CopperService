package com.copper.view.activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
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
import com.copper.bean.ClientChildBean;
import com.copper.bean.InventoryChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.ParserConstant;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.RequestResponseType;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class EditInventoryActivity extends ActionBarActivity implements
		CallBackListener {
	private Context mContext;
	private String items[] = { "Arduino", "Raspberry Pi", "BeagleBone",
			"Prototyping", "Kits", "Board", "LCDS & Displays", "LEDS", "Power",
			"Cables", "Tools", "Robotics", "CNC", "Components & Parts",
			"Sensors", "3D Printing", "Wireless" };
	private int position = 0;
	private View customActionView;
	private EditText name, description, product_model_number,
			vendor_part_number, vendor_name, quantity, unit_value, value,
			vendor_url, location, l_name, l_description, l_product_model,
			l_vendor_part, l_vendor_name, l_quantity, l_unit, l_value,
			l_vendor_url, l_category, l_location, l_image

			;
	TextView category;
	private InventoryChildBean inventoryChildBean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		mContext = this;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_inventory);
		name = (EditText) findViewById(R.id.NameEditText);
		description = (EditText) findViewById(R.id.DescriptionEditText);
		product_model_number = (EditText) findViewById(R.id.ProductModelNumberEditText);
		vendor_part_number = (EditText) findViewById(R.id.VendorPartNumberEditText);
		vendor_name = (EditText) findViewById(R.id.VendorNameEditText);
		quantity = (EditText) findViewById(R.id.quantityEditText);
		unit_value = (EditText) findViewById(R.id.unitValueEditText);
		value = (EditText) findViewById(R.id.valueEditText);
		vendor_url = (EditText) findViewById(R.id.vendorUrlEditText);
		category = (TextView) findViewById(R.id.categryEditText);
		location = (EditText) findViewById(R.id.locationEditText);
		inventoryChildBean = (InventoryChildBean) getIntent().getExtras().get(
				ConstantLib.INVENTORIES);
		setData();
		addActionBar();
		findViewById(R.id.categryEditText).setOnClickListener(
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
										ConstantLib.INVENTORIES, inventoryChildBean
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

	void setData() {

		name.setText(inventoryChildBean.getName());
		description.setText(inventoryChildBean.getDescription());
		product_model_number.setText(inventoryChildBean
				.getProduct_model_number());
		vendor_part_number.setText(inventoryChildBean.getVendor_part_number());
		vendor_name.setText(inventoryChildBean.getVendor_name());
		quantity.setText(inventoryChildBean.getQuantity());
		unit_value.setText(inventoryChildBean.getUnit_value());
		value.setText(inventoryChildBean.getValue());
		vendor_url.setText(inventoryChildBean.getVendor_url());
		category.setText(inventoryChildBean.getCategory());
		location.setText(inventoryChildBean.getLocation());

	}

	void saveRecord() {
		if (name.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter inventory name.", 1).show();
		} else if (description.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter description name.", 1)
					.show();

		} else if (product_model_number.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter product model number.", 1)
					.show();

		} else if (vendor_part_number.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter vendor part number.", 1)
					.show();

		} else if (vendor_name.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter vendor name.", 1).show();

		} else if (quantity.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter quantity.", 1).show();

		} else if (unit_value.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter unit value.", 1).show();

		} else if (value.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter inventory value.", 1).show();

		} else if (vendor_url.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter vendor url.", 1).show();

		} else if (category.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Select enter category.", 1).show();

		} else if (location.getText().toString().trim().length() <= 0) {
			Toast.makeText(mContext, "Please enter location.", 1).show();

		}

		else {
			Utils.ID = inventoryChildBean.getId();
			RequestMethod.createInventory(mContext, MyPref
					.getInstance(mContext).readPrefs(MyPref.USER_ID), name
					.getText().toString().trim(), description.getText()
					.toString().trim(), product_model_number.getText()
					.toString().trim(), vendor_part_number.getText().toString()
					.trim(), vendor_name.getText().toString().trim(), quantity
					.getText().toString().trim(), unit_value.getText()
					.toString().trim(), value.getText().toString().trim(),
					vendor_url.getText().toString().trim(), category.getText()
							.toString().trim(), location.getText().toString()
							.trim(), "", "", "", "", "", "", "", "", "", "",
					"", "", true, this);
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(EditInventoryActivity.this)
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
		titleTextView.setText("Update Inventory");
		Utils.backAction(this);

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
						category.setText(items[arg1]);
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
		if (taskType == RequestResponseType.REQUEST_TYPE_UPDATE_INVENTORY) {
			if (object != null) {
				finish();
			}
		}
	}

}

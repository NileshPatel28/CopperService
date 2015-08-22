package com.copper.view.activity;

import android.app.ActionBar;
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
import com.copper.bean.ResponsBeans;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.utils.Utils;

public class ForgotActivity extends ActionBarActivity implements
		OnClickListener, CallBackListener {
	private View customActionView;
	private EditText usernameEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgot);
		addActionBar();
		init();
		findViewById(R.id.forgotButton).setOnClickListener(this);
	}

	void init() {
		usernameEditText = (EditText) findViewById(R.id.userNameEditText);

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(ForgotActivity.this).inflate(
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
		titleTextView.setText("Forgot Password");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.forgotButton:
			if (usernameEditText.getText().toString().trim().length() <= 0) {
				Utils.showToast(this, getString(R.string.userNameValidation));
			} else {
				RequestMethod.forgot(this, usernameEditText.getText()
						.toString().trim(), this);
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		ResponsBeans responseBean = (ResponsBeans) object;
		if (responseBean != null) {
			if (responseBean.getStatus().equalsIgnoreCase("Success")) {
				Toast.makeText(this,
						"Send Password on your email  Successfuly", 1).show();
				finish();
			} else {

				Utils.showToast(this, responseBean.getStatus());

			}
		}
	}
}

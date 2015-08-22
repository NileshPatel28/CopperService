package com.copper.view.activity;

import android.app.ActionBar;
import android.content.Intent;
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
import com.copper.bean.LoginResponseBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.RequestMethod;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class LoginActivity extends ActionBarActivity implements
		OnClickListener, CallBackListener {
	private View customActionView;
	private EditText usernameEditText, passwordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		addActionBar();
		init();
		findViewById(R.id.loginButton).setOnClickListener(this);
		findViewById(R.id.forgotButton).setOnClickListener(this);

	}

	void init() {
		usernameEditText = (EditText) findViewById(R.id.userNameEditText);
		passwordEditText = (EditText) findViewById(R.id.passwordEditText);

	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(LoginActivity.this).inflate(
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
		titleTextView.setText("Login");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.loginButton:
			if (usernameEditText.getText().toString().trim().length() <= 0) {
				Utils.showToast(this, getString(R.string.userNameValidation));
			} else if (passwordEditText.getText().toString().trim().length() <= 0)

			{
				Utils.showToast(this, getString(R.string.userNameValidation));

			} else {
				RequestMethod.login(this, usernameEditText.getText().toString()
						.trim(), passwordEditText.getText().toString().trim(),
						this);
			}
			break;
		case R.id.forgotButton:
			swithForgotActivity();
		default:
			break;
		}
	}

	private void swithAnotherActivity() {
		startActivity(new Intent(LoginActivity.this, MainActivity.class));
		finish();
	}

	private void swithForgotActivity() {
		startActivity(new Intent(LoginActivity.this, ForgotActivity.class));
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		LoginResponseBean loginResponseBean = (LoginResponseBean) object;
		if (loginResponseBean != null) {
			if (loginResponseBean.getStatus().equalsIgnoreCase("Success")) {
				Toast.makeText(this, "Login Successfuly,", 1).show();
				MyPref.getInstance(this).writePrefs(MyPref.USER_ID,
						loginResponseBean.getUser_id());
				swithAnotherActivity();
 			} else {
 				Utils.showToast(this, loginResponseBean.getStatus());

			}
		}
	}
}

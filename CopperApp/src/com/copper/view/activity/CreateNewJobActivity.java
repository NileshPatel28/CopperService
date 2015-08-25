package com.copper.view.activity;

import java.util.ArrayList;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.copper.adapter.ClientListAdapter;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.RequestMethod;
import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class CreateNewJobActivity extends ActionBarActivity implements
		CallBackListener {
	private View customActionView;
	private ListView listView;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_create_job);
		addActionBar();
		RequestMethod.getClient(this,
				MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID), this);
		listView = (ListView) findViewById(R.id.list);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View arg1,
					int position, long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, ShowJobActivity.class);
				ClientChildBean childBean = (ClientChildBean) adapterView
						.getItemAtPosition(position);
				intent.putExtra(ConstantLib.CLIENTS, childBean);

				startActivity(intent);
				finish();
			}
		});
		findViewById(R.id.createNewClient).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(mContext,
								CreateClientActivity.class));

					}
				});

	}

	private void setItem(ArrayList<ClientChildBean> arrayList) {
		ClientListAdapter clientListAdapter = new ClientListAdapter(this,
				arrayList);
		listView.setAdapter(clientListAdapter);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		ClientEntityBean clientEntityBean = (ClientEntityBean) object;

		if (clientEntityBean != null) {
			setItem(clientEntityBean.getClientList());
		}
	}

	private void addActionBar() {
		customActionView = LayoutInflater.from(CreateNewJobActivity.this)
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
		titleTextView.setText("Create Job");
		Utils.backAction(this);

	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);

	}
}

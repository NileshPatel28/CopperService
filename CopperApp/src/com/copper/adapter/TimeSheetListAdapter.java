package com.copper.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.TimesheetBean;

public class TimeSheetListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<TimesheetBean> clientList = new ArrayList<TimesheetBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return clientList.size();
	}

	public TimeSheetListAdapter(Context mContext,
			ArrayList<TimesheetBean> arrayList) {
		super();
		this.mContext = mContext;
		clientList = arrayList;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return clientList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.row,
					null);
		}
		ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
		icon.setVisibility(View.GONE);
		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(clientList.get(position).getNote());
		return convertView;
	}

}

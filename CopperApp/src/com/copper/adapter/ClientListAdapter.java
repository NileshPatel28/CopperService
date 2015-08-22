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

public class ClientListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<ClientChildBean> clientList = new ArrayList<ClientChildBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return clientList.size();
	}

	public ClientListAdapter(Context mContext,
			ArrayList<ClientChildBean> arrayList) {
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
		icon.setImageResource(R.drawable.client2);
		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(clientList.get(position).getFirst_name() + " "
				+ clientList.get(position).getLast_name());
		return convertView;
	}

}

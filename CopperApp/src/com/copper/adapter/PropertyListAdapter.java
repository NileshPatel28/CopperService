package com.copper.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.bean.InventoryChildBean;
import com.copper.bean.PropertyBean;

public class PropertyListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<PropertyBean> jobList = new ArrayList<PropertyBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jobList.size();
	}

	public PropertyListAdapter(Context mContext,
			ArrayList<PropertyBean> arrayList) {
		super();
		this.mContext = mContext;
		jobList = arrayList;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
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
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.list_item_inventory, null);
		}

		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(jobList.get(position).getStreet() + " , "
				+ jobList.get(position).getCity() + " , "
				+ jobList.get(position).getCountry());
		return convertView;
	}

}

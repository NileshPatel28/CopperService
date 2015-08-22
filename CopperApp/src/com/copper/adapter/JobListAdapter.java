package com.copper.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.bean.JobChildBean;

public class JobListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<JobChildBean> jobList = new ArrayList<JobChildBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return jobList.size();
	}

	public JobListAdapter(Context mContext, ArrayList<JobChildBean> arrayList) {
		super();
		this.mContext = mContext;
		jobList = arrayList;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return jobList.get(arg0);
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
					R.layout.list_items_job, null);
		}

		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		TextView dates = (TextView) convertView.findViewById(R.id.date);
		dates.setText(jobList.get(position).getStart_date());
		title.setText(jobList.get(position).getDescription());
		return convertView;
	}

}

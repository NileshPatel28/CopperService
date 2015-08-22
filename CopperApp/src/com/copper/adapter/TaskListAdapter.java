package com.copper.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.bean.ExpensesChildBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.TaskChildBean;

public class TaskListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<TaskChildBean> list = new ArrayList<TaskChildBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public TaskListAdapter(Context mContext, ArrayList<TaskChildBean> arrayList) {
		super();
		this.mContext = mContext;
		list = arrayList;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
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
					R.layout.list_item_task, null);
		}

		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		if (list.get(position).getIs_completed().equalsIgnoreCase("true"))
			title.setText("Completed");
		else
			title.setText(list.get(position).getTitle() + "\n" + "Pending");

		return convertView;
	}

}

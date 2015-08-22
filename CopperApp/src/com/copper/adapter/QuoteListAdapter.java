package com.copper.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.copper.app.R;
import com.copper.bean.QuoteChildBean;

public class QuoteListAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<QuoteChildBean> quoteList = new ArrayList<QuoteChildBean>();

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return quoteList.size();
	}

	public QuoteListAdapter(Context mContext,
			ArrayList<QuoteChildBean> arrayList) {
		super();
		this.mContext = mContext;
		quoteList = arrayList;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return quoteList.get(arg0);
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
					R.layout.list_items_quote, null);
		}
		TextView title = (TextView) convertView.findViewById(R.id.row_title);
		title.setText(quoteList.get(position).getClient_message());
		TextView title2 = (TextView) convertView.findViewById(R.id.date);
		title2.setText(quoteList.get(position).getTax());

		return convertView;
	}

}

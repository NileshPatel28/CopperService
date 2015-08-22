package com.copper.view.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.AdapterView.AdapterContextMenuInfo;

import com.copper.adapter.QuoteListAdapter;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.QuoteBean;
import com.copper.bean.QuoteChildBean;
import com.copper.bean.TaskChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditClientActivity;
import com.copper.view.activity.EditQouteActivity;
import com.copper.view.activity.EditTaskActivity;

public class QuoteListFragment extends ListFragment implements CallBackListener {
	private ArrayList<QuoteChildBean> arrayList = new ArrayList<QuoteChildBean>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RequestMethod.getQuote(getActivity(), MyPref.getInstance(getActivity())
				.readPrefs(MyPref.USER_ID), this);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_job, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	private void setItem(ArrayList<QuoteChildBean> arrayList) {
		QuoteListAdapter clientListAdapter = new QuoteListAdapter(
				getActivity(), arrayList);
		setListAdapter(clientListAdapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), EditQouteActivity.class);
		QuoteChildBean clientChildBean = (QuoteChildBean) l
				.getItemAtPosition(position);
		intent.putExtra(ConstantLib.QUOTES, clientChildBean);
		startActivity(intent);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		QuoteBean clientEntityBean = (QuoteBean) object;
		if (clientEntityBean != null)
			setItem(clientEntityBean.getQuoteList());
		arrayList = clientEntityBean.getQuoteList();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		registerForContextMenu(getListView());
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);

		menu.add(Menu.NONE, 1, Menu.NONE, "Remove");

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		new DeleteCommunicator(getActivity(), ConstantLib.QUOTES, arrayList
				.get(info.position).getId(), new DeleteListener() {

			@Override
			public void onDelete() {
				// TODO Auto-generated method stub
				RequestMethod.getQuote(
						getActivity(),
						MyPref.getInstance(getActivity()).readPrefs(
								MyPref.USER_ID), QuoteListFragment.this);

			}
		});
		return super.onContextItemSelected(item);

	}

}

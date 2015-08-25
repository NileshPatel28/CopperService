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
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;

import com.copper.adapter.ClientListAdapter;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.communicator.RequestMethod;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditClientActivity;
import com.copper.view.activity.EditInventoryActivity;

public class ClientListFragment extends ListFragment implements
		CallBackListener {
	ArrayList<ClientChildBean> arrayList = new ArrayList<ClientChildBean>();

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RequestMethod.getClient(getActivity(), MyPref
				.getInstance(getActivity()).readPrefs(MyPref.USER_ID), this);

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
		new DeleteCommunicator(getActivity(), ConstantLib.CLIENTS, arrayList
				.get(info.position).getId(), new DeleteListener() {

			@Override
			public void onDelete() {
				// TODO Auto-generated method stub
				RequestMethod.getClient(
						getActivity(),
						MyPref.getInstance(getActivity()).readPrefs(
								MyPref.USER_ID), ClientListFragment.this);

			}
		});
		return super.onContextItemSelected(item);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_job, null);

	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		registerForContextMenu(getListView());

	}

	private void setItem(ArrayList<ClientChildBean> arrayList) {
		ClientListAdapter clientListAdapter = new ClientListAdapter(
				getActivity(), arrayList);
		setListAdapter(clientListAdapter);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), EditClientActivity.class);
		ClientChildBean clientChildBean = (ClientChildBean) l
				.getItemAtPosition(position);
		intent.putExtra(ConstantLib.CLIENTS, clientChildBean);
		startActivity(intent);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		ClientEntityBean clientEntityBean = (ClientEntityBean) object;
		if (clientEntityBean != null) {
			setItem(clientEntityBean.getClientList());
			arrayList = clientEntityBean.getClientList();
		}
	}

}

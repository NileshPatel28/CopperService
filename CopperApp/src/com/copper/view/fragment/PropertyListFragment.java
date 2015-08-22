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

import com.copper.adapter.InventoryListAdapter;
import com.copper.adapter.PropertyListAdapter;
import com.copper.app.R;
import com.copper.bean.ExpensesChildBean;
import com.copper.bean.InventoryBean;
import com.copper.bean.InventoryChildBean;
import com.copper.bean.PropertyBean;
import com.copper.bean.PropertyParentBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditInventoryActivity;
import com.copper.view.activity.UpdatePropertyActivity;

public class PropertyListFragment extends ListFragment implements
		CallBackListener {
	View parentView;
	private ArrayList<PropertyBean> arrayList = new ArrayList<PropertyBean>();

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RequestMethod.getProperty(getActivity(),
				MyPref.getInstance(getActivity()).readPrefs(MyPref.USER_ID),
				this);

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), UpdatePropertyActivity.class);
		intent.putExtra(ConstantLib.PROPERTIES, arrayList.get(position));
		startActivity(intent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_job, null);

		// RequestMethod.getJob(getActivity(), MyPref.getInstance(getActivity())
		// .readPrefs(MyPref.USER_ID), this);

		return parentView;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	private void setSliderItem(ArrayList<PropertyBean> arrayList) {
		setListAdapter(new PropertyListAdapter(getActivity(), arrayList));
		this.arrayList = arrayList;
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		ArrayList<PropertyBean> arrayList = (ArrayList<PropertyBean>) object;
		if (arrayList != null) {
			setSliderItem(arrayList);

		}
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
		new DeleteCommunicator(getActivity(), ConstantLib.PROPERTIES, arrayList
				.get(info.position).getId(), new DeleteListener() {

			@Override
			public void onDelete() {
				// TODO Auto-generated method stub
				RequestMethod.getProperty(
						getActivity(),
						MyPref.getInstance(getActivity()).readPrefs(
								MyPref.USER_ID), PropertyListFragment.this);

			}
		});
		return super.onContextItemSelected(item);

	}

}

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

import com.copper.adapter.ExpansesListAdapter;
import com.copper.adapter.JobListAdapter;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ExpensesChildBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.JobEntityBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditClientActivity;
import com.copper.view.activity.EditExpensesActivity;

public class ExpansesListFragment extends ListFragment implements
		CallBackListener {
	View parentView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	private ArrayList<ExpensesChildBean> arrayList = new ArrayList<ExpensesChildBean>();

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
		new DeleteCommunicator(getActivity(), ConstantLib.EXPENSES, arrayList
				.get(info.position).getId(), new DeleteListener() {

			@Override
			public void onDelete() {
				// TODO Auto-generated method stub
				RequestMethod.getExpanses(
						getActivity(),
						MyPref.getInstance(getActivity()).readPrefs(
								MyPref.USER_ID), ExpansesListFragment.this);

			}
		});
		return super.onContextItemSelected(item);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentView = inflater.inflate(R.layout.fragment_job, null);

		return parentView;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RequestMethod.getExpanses(getActivity(),
				MyPref.getInstance(getActivity()).readPrefs(MyPref.USER_ID),
				this);

	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	private void setSliderItem(ArrayList<ExpensesChildBean> arrayList) {
		setListAdapter(new ExpansesListAdapter(getActivity(), arrayList));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), EditExpensesActivity.class);
		ExpensesChildBean clientChildBean = (ExpensesChildBean) l
				.getItemAtPosition(position);
		intent.putExtra(ConstantLib.EXPENSES, clientChildBean);
		startActivity(intent);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<ExpensesChildBean> list = (ArrayList<ExpensesChildBean>) object;
		if (list != null) {
			setSliderItem(list);

			this.arrayList = list;

		}
	}

}

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

import com.copper.adapter.ClientListAdapter;
import com.copper.adapter.TaskListAdapter;
import com.copper.app.R;
import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.bean.QuoteChildBean;
import com.copper.bean.TaskChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditClientActivity;
import com.copper.view.activity.EditTaskActivity;

public class TaskFragment extends ListFragment implements CallBackListener {
	private ArrayList<TaskChildBean> arrayList = new ArrayList<TaskChildBean>();

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		RequestMethod.getBasicTask(getActivity(),
				MyPref.getInstance(getActivity()).readPrefs(MyPref.USER_ID),
				this);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_task, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	private void setItem(ArrayList<TaskChildBean> arrayList) {
		TaskListAdapter clientListAdapter = new TaskListAdapter(getActivity(),
				arrayList);
		this.arrayList = arrayList;
		setListAdapter(clientListAdapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), EditTaskActivity.class);
		TaskChildBean clientChildBean = (TaskChildBean) l
				.getItemAtPosition(position);
		intent.putExtra(ConstantLib.BASIC_TASKS, clientChildBean);
		startActivity(intent);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<TaskChildBean> list = (ArrayList<TaskChildBean>) object;
		if (list != null)
			setItem(list);
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
		new DeleteCommunicator(getActivity(), ConstantLib.BASIC_TASKS,
				arrayList.get(info.position).getId(), new DeleteListener() {

					@Override
					public void onDelete() {
						// TODO Auto-generated method stub
						RequestMethod.getBasicTask(
								getActivity(),
								MyPref.getInstance(getActivity()).readPrefs(
										MyPref.USER_ID), TaskFragment.this);

					}
				});
		return super.onContextItemSelected(item);

	}

}

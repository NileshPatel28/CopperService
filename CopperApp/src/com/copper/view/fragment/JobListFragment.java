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

import com.copper.adapter.JobListAdapter;
import com.copper.app.R;
import com.copper.bean.InventoryChildBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.JobEntityBean;
import com.copper.bean.QuoteChildBean;
import com.copper.communicator.CallBackListener;
import com.copper.communicator.ConstantLib;
import com.copper.communicator.DeleteCommunicator;
import com.copper.communicator.RequestMethod;
import com.copper.communicator.DeleteCommunicator.DeleteListener;
import com.copper.prefs.MyPref;
import com.copper.view.activity.EditJobActivity;
import com.copper.view.activity.EditQouteActivity;
import com.google.android.gms.internal.jb;

public class JobListFragment extends ListFragment implements CallBackListener {
	View parentView;
	private ArrayList<JobChildBean> arrayList = new ArrayList<JobChildBean>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

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
		RequestMethod.getJob(getActivity(), MyPref.getInstance(getActivity())
				.readPrefs(MyPref.USER_ID), this);

	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	private void setSliderItem(ArrayList<JobChildBean> arrayList) {
		setListAdapter(new JobListAdapter(getActivity(), arrayList));
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(getActivity(), EditJobActivity.class);
		JobChildBean clientChildBean = (JobChildBean) l
				.getItemAtPosition(position);
		intent.putExtra(ConstantLib.JOBS, clientChildBean);
		startActivity(intent);
	}

	@Override
	public void onCallBack(int taskType, Object object) {
		// TODO Auto-generated method stub
		JobEntityBean jobEntityBean = (JobEntityBean) object;
		if (jobEntityBean != null) {
			if (jobEntityBean.getJob() != null) {
				setSliderItem(jobEntityBean.getJob());
				arrayList = jobEntityBean.getJob();

			}

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
		new DeleteCommunicator(getActivity(), ConstantLib.JOBS, arrayList.get(
				info.position).getId(), new DeleteListener() {

			@Override
			public void onDelete() {
				// TODO Auto-generated method stub
				RequestMethod.getJob(
						getActivity(),
						MyPref.getInstance(getActivity()).readPrefs(
								MyPref.USER_ID), JobListFragment.this);

			}
		});
		return super.onContextItemSelected(item);

	}

}

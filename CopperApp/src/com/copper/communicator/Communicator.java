package com.copper.communicator;

import java.util.ArrayList;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.utils.Utils;

public class Communicator extends CommunicatorHandler {

	private ProgressDialog progressDialog;
	private Context mContext;
	private CallBackListener mCallBackListener;
	private int mRequestType;
	private ArrayList<NameValuePair> mParameter;

	public void connect(Context context,
			ArrayList<NameValuePair> nameValuePairs, int requestType,
			CallBackListener callBackListener) {
		Utils.hideKetyboard((Activity) context);
		mContext = context;
		mCallBackListener = callBackListener;
		mRequestType = requestType;
		mParameter = nameValuePairs;
		if (CheckNetworkStateClass.isOnline(mContext))
			new BackgroundTask().execute();
		else
			Toast.makeText(mContext,
					mContext.getString(R.string.network_not_available), 1)
					.show();
	}

	class BackgroundTask extends AsyncTask<Void, Void, Object> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressDialog = new ProgressDialog(mContext);
			progressDialog.show();
			progressDialog.setMessage(mContext.getString(R.string.pleaseWait));
		}

		@Override
		protected Object doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			String response = getResponse(mRequestType, mParameter);
			Log.v(ConstantLib.LOG, "Response :: " + response);
			Object object = ParserHandler.doParse(mRequestType, response);

			return object;
		}

		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mCallBackListener.onCallBack(mRequestType, result);
			progressDialog.dismiss();
		}
	}
}

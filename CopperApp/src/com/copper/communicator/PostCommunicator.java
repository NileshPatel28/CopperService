package com.copper.communicator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.copper.app.R;
import com.copper.utils.Utils;

public class PostCommunicator extends PostCommunicatorHandler {

	private ProgressDialog progressDialog;
	private Context mContext;
	private CallBackListener mCallBackListener;
	private int mRequestType;
	private String mRequest;

	public void connect(Context context, String request, int requestType,
			CallBackListener callBackListener) {
		mContext = context;
		mCallBackListener = callBackListener;
		mRequestType = requestType;
		mRequest = request;
		Utils.hideKetyboard((Activity) context);
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
			progressDialog.setMessage(mContext.getString(R.string.pleaseWait));
			progressDialog.show();

		}

		@Override
		protected Object doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			String response = null;
			response = getResponse(mRequestType, mRequest, mContext);

			Object object = null;
			if (response != null) {
				if (response.length() > 0) {
					object = ParserHandler.doParse(mRequestType, response);
				}
				return object;
			}
			return null;
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

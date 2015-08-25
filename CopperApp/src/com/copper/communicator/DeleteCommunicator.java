package com.copper.communicator;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.copper.prefs.MyPref;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class DeleteCommunicator extends AsyncTask<String, String, String> {
	ProgressDialog progressDialog;
	Context context;
	private HttpResponse response;
	private String URL = ConstantLib.BASE_URL + "%s/%s?user_id=%s";
	private DeleteListener mDeleteListener;

	public interface DeleteListener {
		void onDelete();
	}

	public DeleteCommunicator(Context context, String method, String id,
			DeleteListener deleteListener) {
		// TODO Auto-generated constructor stub
		this.context = context;
		mDeleteListener = deleteListener;
		String url = String.format(URL, method, id, MyPref.getInstance(context)
				.readPrefs(MyPref.USER_ID));
		Log.v("N", "URL : " + url);
		execute(url);
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage("Please wait..");
		progressDialog.show();
	}

	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		HttpClient httpclient = new DefaultHttpClient();
		HttpDelete httpdelete = new HttpDelete(arg0[0]);
		httpdelete.setHeader(HTTP.CONTENT_TYPE, "text/xml");
		String respStr = "";
		try {
			response = httpclient.execute(httpdelete);
			respStr = EntityUtils.toString(response.getEntity());
			Log.v("N", "Response :: " + respStr);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respStr;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		progressDialog.dismiss();
		if (result != null)
			if (!result.equalsIgnoreCase("null") && result.length() > 0) {
				try {
					Toast.makeText(context,
							new JSONObject(result).getString("status"), 1)
							.show();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		mDeleteListener.onDelete();
	}
}

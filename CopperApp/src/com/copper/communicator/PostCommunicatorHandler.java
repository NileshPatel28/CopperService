package com.copper.communicator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.util.Log;

import com.copper.prefs.MyPref;
import com.copper.utils.Utils;

public class PostCommunicatorHandler implements RequestResponseType {

	public String getResponse(int requestType, String request, Context mContext) {
		String response = "";
		StringBuilder URL = new StringBuilder(ConstantLib.BASE_URL);
		switch (requestType) {
		case REQUEST_TYPE_LOGIN:
			URL.append(ConstantLib.LOGIN);
			break;
		case REQUEST_TYPE_FORGOT:
			URL.append(ConstantLib.FORGOT_PASSWORD);
			break;

		case REQUEST_TYPE_CREATE_INVENTORY:
			URL.append(ConstantLib.INVENTORIES + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));

			break;

		case REQUEST_TYPE_CREATE_CLIENT:
			URL.append(ConstantLib.CLIENTS + "?" + ParserConstant.USER_ID + "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_PROPERTY:
			URL.append(ConstantLib.PROPERTIES + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_JOB:
			URL.append(ConstantLib.JOBS + "?" + ParserConstant.USER_ID + "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_QUOTE:
			URL.append(ConstantLib.QUOTES + "?" + ParserConstant.USER_ID + "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_INVOICE:
			URL.append(ConstantLib.INVOICES + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;

		case REQUEST_TYPE_CREATE_EXPANSES:
			URL.append(ConstantLib.EXPENSES + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_TASK:
			URL.append(ConstantLib.BASIC_TASKS + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_CLIENT:
			URL.append(ConstantLib.CLIENTS + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_CLIENT + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_TASK:
			URL.append(ConstantLib.BASIC_TASKS + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_TASK + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;

		case REQUEST_TYPE_UPDATE_INVENTORY:
			URL.append(ConstantLib.INVENTORIES + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_ITEM + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_EXPANSES:
			URL.append(ConstantLib.EXPENSES + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_EXPENSE + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_QUOTE:
			URL.append(ConstantLib.QUOTES + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_QUOTE + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_JOB:
			URL.append(ConstantLib.JOBS + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_JOB + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_PROPERTY:
			URL.append(ConstantLib.PROPERTIES + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_PROPERTY + "?"
					+ ParserConstant.USER_ID + "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_UPDATE_INVOICE:
			URL.append(ConstantLib.INVOICES + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_INVOICE + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;
		case REQUEST_TYPE_CREATE_TIMESHEET:
			URL.append(ConstantLib.TIMESHEETS + "?" + ParserConstant.USER_ID
					+ "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));

			break;

		case REQUEST_TYPE_UPDATE_TIMESHEET:
			URL.append(ConstantLib.TIMESHEETS + "/" + Utils.ID + "/"
					+ ConstantLib.UPDATE_TIMESHEET + "?"
					+ ParserConstant.USER_ID + "="
					+ MyPref.getInstance(mContext).readPrefs(MyPref.USER_ID));
			break;

		default:
			break;
		}

		response = post(URL.toString(), request);

		return response;

	}

	private String post(String URL, String request) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(URL);
		post.setHeader("content-type", "application/json");
		String response = "";
		try {

			StringEntity entity = new StringEntity(request);
			post.setEntity(entity);
			Log.v(ConstantLib.LOG, "URL :: " + URL);

			Log.v(ConstantLib.LOG, "Request :: " + request);

			HttpResponse resp = httpClient.execute(post);
			String respStr = EntityUtils.toString(resp.getEntity());
			response = respStr;
			Log.v(ConstantLib.LOG, "Response :: " + response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response = "error";
		}

		return response;

	}

	public String getRequest(int request) {
		return null;

	}
}

package com.copper.communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.copper.utils.Utils;

public class CommunicatorHandler implements RequestResponseType {
	private String response;

	public String getResponse(int request,
			ArrayList<NameValuePair> nameValuePairs) {
		String response = "";
		StringBuilder Url = new StringBuilder(ConstantLib.BASE_URL);
		switch (request) {
		case REQUEST_TYPE_JOB:
			Url.append(ConstantLib.JOBS);
			break;
		case REQUEST_TYPE_INVENTORIES:
			Url.append(ConstantLib.INVENTORIES);
			break;
		case REQUEST_TYPE_CLIENT:
			Url.append(ConstantLib.CLIENTS);
			break;
		case REQUEST_TYPE_QUOTE:
			Url.append(ConstantLib.QUOTES);
			break;
		case REQUEST_TYPE_PROPERTY:
			Url.append(ConstantLib.PROPERTIES);
			break;
		case REQUEST_TYPE_EXPANSES:
			Url.append(ConstantLib.EXPENSES);
			break;
		case REQUEST_TYPE_TASK:
			Url.append(ConstantLib.BASIC_TASKS);
			break;
		case REQUEST_TYPE_TODAY_TASK:
			Url.append(ConstantLib.TODAY_TASK);
			break;
		case REQUEST_TYPE_GET_INVOICE:
			Url.append(ConstantLib.INVOICES);
			break;
		case REQUEST_TYPE_GET_CLIENT_PROPERTY:
			Url.append(ConstantLib.CLIENTS + "/" + Utils.ID + "/"
					+ ConstantLib.CLIENT_PROPERTY);
			break;
		case REQUEST_TYPE_TIMESHEET:
			Url.append(ConstantLib.TIMESHEETS);
			break;
		case REQUEST_TYPE_ROUTE:
			Url.append(ConstantLib.ROUTE);
			break;

		default:
			break;
		}

		response = get(Url.toString(), nameValuePairs);

		return response;

	}

	private String get(String url, ArrayList<NameValuePair> params) {
		// add parameters
		String combinedParams = "";
		if (!params.isEmpty()) {
			combinedParams += "?";
			for (NameValuePair p : params) {
				String paramString = "";
				try {
					paramString = p.getName() + "="
							+ URLEncoder.encode(p.getValue(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (combinedParams.length() > 1) {
					combinedParams += "&" + paramString;
				} else {
					combinedParams += paramString;
				}
			}
		}

		HttpGet request = new HttpGet(url + combinedParams);

		return executeRequest(request, url);

	}

	private String executeRequest(HttpUriRequest request, String url) {
		HttpClient client = new DefaultHttpClient();

		HttpResponse httpResponse;

		try {
			httpResponse = client.execute(request);
			int responseCode = httpResponse.getStatusLine().getStatusCode();
			String message = httpResponse.getStatusLine().getReasonPhrase();

			HttpEntity entity = httpResponse.getEntity();

			if (entity != null) {

				InputStream instream = entity.getContent();
				response = convertStreamToString(instream);

				// Closing the input stream will trigger connection release
				instream.close();
			}

		} catch (ClientProtocolException e) {
			client.getConnectionManager().shutdown();
			e.printStackTrace();
		} catch (IOException e) {
			client.getConnectionManager().shutdown();
			e.printStackTrace();
		}
		return response;
	}

	private static String convertStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

}

package com.copper.communicator;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class RequestMethod implements RequestResponseType {
	public static void login(Context context, String email, String password,
			CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ConstantLib.EMAIL, email);
			jsonObject.put(ConstantLib.PASSWORD, password);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_LOGIN,
				callBackListener);
	}

	public static void forgot(Context context, String email,
			CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ConstantLib.EMAIL, email);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_FORGOT,
				callBackListener);
	}

	public static void getJob(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_JOB,
				callBackListener);
	}

	public static void getInventory(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_INVENTORIES,
				callBackListener);
	}

	public static void createJob(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ConstantLib.EMAIL, "");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_CREATE_JOB,
				callBackListener);

	}

	public static void deleteJob(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_DELETE_JOB,
				callBackListener);
	}

	public static void createInventory(Context context, String userID,

	String name, String description, String product_model_number,
			String vendor_part_number, String vendor_name, String quantity,
			String unit_value, String value, String vendor_url,
			String category, String location, String l_name,
			String l_description, String l_product_model, String l_vendor_part,
			String l_vendor_name, String l_quantity, String l_unit,
			String l_value, String l_vendor_url, String l_category,
			String l_location, String l_image, boolean isupdate,
			CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.NAME, name);
			jsonObject.put(ParserConstant.DESCRIPTION, description);
			jsonObject.put(ParserConstant.PRODUCT_MODEL_NUMBER,
					product_model_number);
			jsonObject.put(ParserConstant.VENDOR_PART_NUMBER,
					vendor_part_number);
			jsonObject.put(ParserConstant.VENDOR_NAME, vendor_name);
			jsonObject.put(ParserConstant.QUANTITY, quantity);
			jsonObject.put(ParserConstant.UNIT_VALUE, unit_value);
			jsonObject.put(ParserConstant.VALUE, value);
			jsonObject.put(ParserConstant.VENDOR_URL, vendor_url);
			jsonObject.put(ParserConstant.CATEGORY, category);
			jsonObject.put(ParserConstant.LOCATION, location);
			// jsonObject.put(ParserConstant.L_NAME, l_name);
			// jsonObject.put(ParserConstant.L_DESCRIPTION, l_description);
			// jsonObject.put(ParserConstant.L_PRODUCT_MODEL, l_product_model);
			// jsonObject.put(ParserConstant.L_VENDOR_PART, l_vendor_part);
			// jsonObject.put(ParserConstant.L_VENDOR_NAME, l_vendor_name);
			// jsonObject.put(ParserConstant.L_QUANTITY, l_quantity);
			// jsonObject.put(ParserConstant.L_UNIT, l_unit);
			// jsonObject.put(ParserConstant.L_VALUE, l_value);
			// jsonObject.put(ParserConstant.L_VENDOR_URL, l_vendor_url);
			// jsonObject.put(ParserConstant.L_CATEGORY, l_category);
			// jsonObject.put(ParserConstant.L_LOCATION, l_location);
			// jsonObject.put(ParserConstant.L_IMAGE, l_image);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		if (isupdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_INVENTORY, callBackListener);
		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_INVENTORY, callBackListener);

	}

	public static void deleteInventory(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_DELETE_INVENTORY,
				callBackListener);
	}

	public static void getClient(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_CLIENT,
				callBackListener);
	}

	public static void createClient(Context context, String initial,
			String firstName, String lastName, String email, String company,
			String mobile, CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.INITIAL, initial);

			jsonObject.put(ParserConstant.FIRST_NAME, firstName);
			jsonObject.put(ParserConstant.LAST_NAME, lastName);
			jsonObject.put(ParserConstant.PERSONAL_EMAIL, email);
			jsonObject.put(ParserConstant.COMPANY_NAME, company);
			jsonObject.put(ParserConstant.MOBILE_NUMBER, mobile);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_CREATE_CLIENT,
				callBackListener);

	}

	public static void updateClient(Context context, String initial,
			String firstName, String lastName, String email, String company,
			String mobile, CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.INITIAL, initial);

			jsonObject.put(ParserConstant.FIRST_NAME, firstName);
			jsonObject.put(ParserConstant.LAST_NAME, lastName);
			jsonObject.put(ParserConstant.PERSONAL_EMAIL, email);
			jsonObject.put(ParserConstant.COMPANY_NAME, company);
			jsonObject.put(ParserConstant.MOBILE_NUMBER, mobile);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_UPDATE_CLIENT,
				callBackListener);

	}

	public static void createInvoice(Context context, String userID,
			String subject, String de, String di, String clientMessage,
			String add_note, String payment, String clientID, String tax,
			String du, String issueDate, CallBackListener callBackListener,
			boolean isUpdate) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.SUBJECT, subject);
			jsonObject.put(ParserConstant.DEPOSITE_AMOUNT, de);
			jsonObject.put(ParserConstant.DISCOUNT_AMOUNT, di);
			jsonObject.put(ParserConstant.PAYMENT, payment);
			jsonObject.put(ParserConstant.CLIENT_ID, clientID);
			jsonObject.put(ParserConstant.CLIENT_MESSAGE, clientMessage);
			jsonObject.put(ParserConstant.ADDITIONAL_NOTE, add_note);
			jsonObject.put(ParserConstant.TAX, tax);
			jsonObject.put(ParserConstant.DUE_DATE, du);
			jsonObject.put(ParserConstant.ISSUED_DATE, issueDate);
			jsonObject.put(ParserConstant.DISCOUNT_TYPE, "$");
			jsonObject.put(ParserConstant.ENTRY_DATE, "");
			jsonObject.put(ParserConstant.PAYMENT_METHOD, "");
			jsonObject.put(ParserConstant.PAYMENT_METHOD_TYPE, "");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// "jobs_id": null,
		// "mark_sent": false,
		// "invoice_paid": false,
		// "invoice_bad_debt": false,
		// "past_due": false,
		// "custom_field": null,
		// "is_mailed": false,
		// "invoice_order": 1,
		// "quote_id": null
		//
		String request = jsonObject.toString();

		PostCommunicator postCommunicator = new PostCommunicator();
		if (isUpdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_INVOICE, callBackListener);
		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_INVOICE, callBackListener);

	}

	public static void createProperty(Context context, String userID,
			String street, String city, String state, String zipcode,
			String country, String clientID, CallBackListener callBackListener,
			boolean isUpdate) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.STREET, street);
			jsonObject.put(ParserConstant.CITY, city);
			jsonObject.put(ParserConstant.STATE, state);
			jsonObject.put(ParserConstant.COUNTRY, country);
			jsonObject.put(ParserConstant.CLIENT_ID, clientID);
			jsonObject.put(ParserConstant.ZIP_CODE, zipcode);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		if (isUpdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_PROPERTY, callBackListener);
		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_PROPERTY, callBackListener);

	}

	public static void createQuote(Context context, String property_id,
			String quote_order, String tax, String discount,
			String work_order_name, String work_order_description,
			String client_message, String quantity, String unit_cost,
			CallBackListener callBackListener, boolean isUpdate) {
		// {"quote_work":{"name":"prateek","description":"this is test"
		// ,"quantity":"12","unit_cost":"3","total":"36"},
		// "quote":{"property_id":"1","quote_order":"10","tax":"5","discount":"10"
		// ,"client_message":"this is test ","raty_score":"3"}}
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONObject jsonObject3 = new JSONObject();
		int total = 0;
		try {
			total = Integer.parseInt(quantity) + Integer.parseInt(unit_cost);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			jsonObject2.put(ParserConstant.NAME, work_order_name);
			jsonObject2.put(ParserConstant.DESCRIPTION, work_order_description);
			jsonObject2.put(ParserConstant.QUANTITY, quantity);
			jsonObject2.put(ParserConstant.UNIT_COST, unit_cost);
			jsonObject2.put(ParserConstant.Total, total);
			jsonObject.put("quote_work", jsonObject2);
			jsonObject3.put(ParserConstant.PROPERTY_ID, property_id);
			jsonObject3.put(ParserConstant.QUOTE_ORDER, quote_order);
			jsonObject3.put(ParserConstant.TAX, tax);
			jsonObject3.put(ParserConstant.DISCOUNT, discount);
			jsonObject3.put(ParserConstant.CLIENT_MESSAGE, client_message);
			jsonObject.put("quote", jsonObject3);

		}

		catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();

		if (isUpdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_QUOTE, callBackListener);
		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_QUOTE, callBackListener);
	}

	public static void createJobs(Context context, String description,
			String scheduled, String start_date, String end_date,
			String visits, String job_type, String job_order,
			String property_id, String user_id,
			CallBackListener callBackListener, boolean isUpdate) {

		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put(ParserConstant.DESCRIPTION, description);
			jsonObject.put(ParserConstant.SCHEDULED, scheduled);
			jsonObject.put(ParserConstant.START_DATE, start_date);
			jsonObject.put(ParserConstant.END_DATE, end_date);
			jsonObject.put(ParserConstant.VISITS, visits);
			jsonObject.put(ParserConstant.JOB_TYPE, job_type);
			jsonObject.put(ParserConstant.JOB_ORDER, job_order);
			jsonObject.put(ParserConstant.PROPERTY_ID, property_id);
			jsonObject.put(ParserConstant.USER_ID, user_id);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		if (isUpdate)
			postCommunicator.connect(context, request, REQUEST_TYPE_UPDATE_JOB,
					callBackListener);
		else
			postCommunicator.connect(context, request, REQUEST_TYPE_CREATE_JOB,
					callBackListener);

	}

	public static void createJobs(Context context, String property_id,
			String quote_order, String tax, String discount,
			String work_order_name, String work_order_description,
			String client_message, CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.PROPERTY_ID, property_id);
			jsonObject.put(ParserConstant.QUOTE_ORDER, quote_order);
			jsonObject.put(ParserConstant.TAX, tax);
			jsonObject.put(ParserConstant.DISCOUNT, discount);
			jsonObject.put(ParserConstant.WORK_ORDER_NAME, work_order_name);
			jsonObject.put(ParserConstant.WORK_ORDER_DESCRIPTION,
					work_order_description);
			jsonObject.put(ParserConstant.CLIENT_MESSAGE, client_message);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_CREATE_QUOTE,
				callBackListener);

	}

	public static void getQuote(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_QUOTE,
				callBackListener);
	}

	public static void getProperty(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_PROPERTY,
				callBackListener);
	}

	{
		// String clean_date ,
		// String name ,
		// String note ,
		// String cost ,
		// String exp_billable ,
		// String job_id ,
		// String category_id ,
		// String expense_type ,
	}

	public static void getExpanses(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_EXPANSES,
				callBackListener);
	}

	public static void createExpanses(Context context, String userID,
			String clean_date, String name, String note, String cost,
			String exp_billable, String job_id, String category_id,
			String expense_type, CallBackListener callBackListener,
			boolean isupdate) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.CLEAN_DATE, clean_date);
			jsonObject.put(ParserConstant.NAME, name);
			jsonObject.put(ParserConstant.NOTE, note);
			jsonObject.put(ParserConstant.COST, cost);
			jsonObject.put(ParserConstant.EXP_BILLABLE, exp_billable);
			jsonObject.put(ParserConstant.JOB_ID, job_id);
			jsonObject.put(ParserConstant.CATEGORY_ID, category_id);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		if (isupdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_EXPANSES, callBackListener);
		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_EXPANSES, callBackListener);

	}

	public static void createBasicTask(Context context, String title,
			String all_day, String start_at_date, String start_at_time,
			String end_at_date, String end_at_time, String description

			, CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.TITLE, title);
			jsonObject.put(ParserConstant.ALL_DAY, "1");
			jsonObject.put(ParserConstant.START_AT_DATE, start_at_date);
			jsonObject.put(ParserConstant.END_AT_DATE, end_at_date);
			jsonObject.put(ParserConstant.START_AT_TIME, start_at_time);
			jsonObject.put(ParserConstant.END_AT_TIME, end_at_time);
			jsonObject.put(ParserConstant.DESCRIPTION, description);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_CREATE_TASK,
				callBackListener);
	}

	public static void updateBasicTask(Context context, String title,
			String all_day, String start_at_date, String start_at_time,
			String end_at_date, String end_at_time, String description

			, CallBackListener callBackListener) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.TITLE, title);
			jsonObject.put(ParserConstant.ALL_DAY, "1");
			jsonObject.put(ParserConstant.START_AT_DATE, start_at_date);
			jsonObject.put(ParserConstant.END_AT_DATE, end_at_date);
			jsonObject.put(ParserConstant.START_AT_TIME, start_at_time);
			jsonObject.put(ParserConstant.END_AT_TIME, end_at_time);
			jsonObject.put(ParserConstant.DESCRIPTION, description);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		postCommunicator.connect(context, request, REQUEST_TYPE_UPDATE_TASK,
				callBackListener);
	}

	public static void getBasicTask(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_TASK,
				callBackListener);

	}

	public static void getTodaysBasicTask(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_TODAY_TASK,
				callBackListener);

	}

	public static void getInvoice(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_GET_INVOICE,
				callBackListener);

	}

	public static void getClientProperty(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList,
				REQUEST_TYPE_GET_CLIENT_PROPERTY, callBackListener);

	}

	public static void createTimesheet(Context context, String note,
			String start_at_time, String end_at_time, String isBillable

			, String auto, String duration, CallBackListener callBackListener,
			boolean isupdate) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put(ParserConstant.NOTE, note);
			jsonObject.put(ParserConstant.START_TIME, start_at_time);
			jsonObject.put(ParserConstant.END_TIME, end_at_time);
			jsonObject.put(ParserConstant.BILLABLE, isBillable);
			jsonObject.put(ParserConstant.END_AT_TIME, end_at_time);
			jsonObject.put(ParserConstant.AUTO_START_TIMER, auto);
			jsonObject.put(ParserConstant.DURATION, duration);

		} catch (JSONException e) {
			// TODO Auto-generated catch bUSER_ID
			e.printStackTrace();
		}
		String request = jsonObject.toString();
		PostCommunicator postCommunicator = new PostCommunicator();
		if (!isupdate)
			postCommunicator.connect(context, request,
					REQUEST_TYPE_CREATE_TIMESHEET, callBackListener);

		else
			postCommunicator.connect(context, request,
					REQUEST_TYPE_UPDATE_TIMESHEET, callBackListener);

	}

	public static void getTimeSheet(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_TIMESHEET,
				callBackListener);
	}

	public static void getRoute(Context context, String userID,
			CallBackListener callBackListener) {
		ArrayList<NameValuePair> arrayList = new ArrayList<NameValuePair>();
		arrayList.add(new BasicNameValuePair("user_id", userID));
		Communicator communicator = new Communicator();
		communicator.connect(context, arrayList, REQUEST_TYPE_ROUTE,
				callBackListener);
	}

}
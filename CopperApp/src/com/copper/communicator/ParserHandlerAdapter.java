package com.copper.communicator;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.copper.bean.ClientChildBean;
import com.copper.bean.ClientEntityBean;
import com.copper.bean.ExpensesChildBean;
import com.copper.bean.InventoryBean;
import com.copper.bean.InventoryChildBean;
import com.copper.bean.InvoiceBean;
import com.copper.bean.JobChildBean;
import com.copper.bean.JobEntityBean;
import com.copper.bean.MapBean;
import com.copper.bean.PropertyBean;
import com.copper.bean.PropertyParentBean;
import com.copper.bean.QuoteBean;
import com.copper.bean.QuoteChildBean;
import com.copper.bean.TaskChildBean;
import com.copper.bean.TimesheetBean;
import com.google.android.gms.maps.model.LatLng;

public class ParserHandlerAdapter {
	public static Object parseJob(String response) {
		if (response != null) {
			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray(ConstantLib.JOBS);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			ArrayList<JobChildBean> job = new ArrayList<JobChildBean>();
			JobEntityBean jobEntityBean = new JobEntityBean();

			for (int i = 0; i < jsonArray.length(); i++) {
				JobChildBean jobChildBean = new JobChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.COMPLETE_ON))
						jobChildBean.setComplete_on(jsonObject
								.getString(ParserConstant.COMPLETE_ON));

					if (!jsonObject.isNull(ParserConstant.CREATED_AT))
						jobChildBean.setCreated_at(jsonObject
								.getString(ParserConstant.CREATED_AT));

					if (!jsonObject.isNull(ParserConstant.CREW))
						jobChildBean.setCrew(jsonObject
								.getString(ParserConstant.CREW));
					if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
						jobChildBean.setCustom_field(jsonObject
								.getString(ParserConstant.CUSTOM_FIELD));
					if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
						jobChildBean.setDescription(jsonObject
								.getString(ParserConstant.DESCRIPTION));
					if (!jsonObject.isNull(ParserConstant.END_DATE))
						jobChildBean.setEnd_date(jsonObject
								.getString(ParserConstant.END_DATE));
					if (!jsonObject.isNull(ParserConstant.END_TIME))
						jobChildBean.setEnd_date(jsonObject
								.getString(ParserConstant.END_TIME));
					if (!jsonObject.isNull(ParserConstant.FIRST_INVOICE_ON))
						jobChildBean.setFirst_invoice_on(jsonObject
								.getString(ParserConstant.FIRST_INVOICE_ON));
					if (!jsonObject.isNull(ParserConstant.ID))
						jobChildBean.setId(jsonObject
								.getString(ParserConstant.ID));
					if (!jsonObject.isNull(ParserConstant.INVOICE_PERIOD))
						jobChildBean.setInvoice_period(jsonObject
								.getString(ParserConstant.INVOICE_PERIOD));
					if (!jsonObject.isNull(ParserConstant.INVOICE_TYPE))
						jobChildBean.setInvoice_type(jsonObject
								.getString(ParserConstant.INVOICE_TYPE));
					if (!jsonObject.isNull(ParserConstant.INVOICING))
						jobChildBean.setInvoicing(jsonObject
								.getString(ParserConstant.INVOICING));
					if (!jsonObject.isNull(ParserConstant.JOB_COMPLETE))
						jobChildBean.setJob_complete(jsonObject
								.getString(ParserConstant.JOB_COMPLETE));
					if (!jsonObject.isNull(ParserConstant.JOB_ORDER))
						jobChildBean.setJob_order(jsonObject
								.getString(ParserConstant.JOB_ORDER));

					if (!jsonObject.isNull(ParserConstant.JOB_REQUIRED))
						jobChildBean.setJob_required(jsonObject
								.getString(ParserConstant.JOB_REQUIRED));

					if (!jsonObject.isNull(ParserConstant.JOB_STATUS))
						jobChildBean.setJob_status(jsonObject
								.getString(ParserConstant.JOB_STATUS));

					if (!jsonObject.isNull(ParserConstant.PROPERTY_ID))
						jobChildBean.setProperty_id(jsonObject
								.getString(ParserConstant.PROPERTY_ID));

					if (!jsonObject.isNull(ParserConstant.QUOTE_ID))
						jobChildBean.setQuote_id(jsonObject
								.getString(ParserConstant.QUOTE_ID));

					if (!jsonObject.isNull(ParserConstant.SCHEDULED))
						jobChildBean.setScheduled(jsonObject
								.getString(ParserConstant.SCHEDULED));

					if (!jsonObject.isNull(ParserConstant.START_DATE))
						jobChildBean.setStart_date(jsonObject
								.getString(ParserConstant.START_DATE));

					if (!jsonObject.isNull(ParserConstant.START_TIME))
						jobChildBean.setStart_time(jsonObject
								.getString(ParserConstant.START_TIME));
					if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
						jobChildBean.setUpdated_at(jsonObject
								.getString(ParserConstant.UPDATED_AT));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				job.add(jobChildBean);
				jobEntityBean.setJob(job);
			}

			return jobEntityBean;
		} else {
			return null;
		}
	}

	public static Object parseInventories(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain
						.getJSONArray(ConstantLib.INVENTORIES);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ArrayList<InventoryChildBean> job = new ArrayList<InventoryChildBean>();
			InventoryBean jobEntityBean = new InventoryBean();

			for (int i = 0; i < jsonArray.length(); i++) {
				InventoryChildBean jobChildBean = new InventoryChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.CATEGORY))
						jobChildBean.setCategory(jsonObject
								.getString(ParserConstant.CATEGORY));

					if (!jsonObject.isNull(ParserConstant.ID))
						jobChildBean.setId(jsonObject
								.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
						jobChildBean.setDescription(jsonObject
								.getString(ParserConstant.DESCRIPTION));

					if (!jsonObject.isNull(ParserConstant.L_CATEGORY))
						jobChildBean.setL_category(jsonObject
								.getString(ParserConstant.L_CATEGORY));
					if (!jsonObject.isNull(ParserConstant.L_DESCRIPTION))
						jobChildBean.setL_description(jsonObject
								.getString(ParserConstant.L_DESCRIPTION));
					if (!jsonObject.isNull(ParserConstant.L_IMAGE))
						jobChildBean.setL_image(jsonObject
								.getString(ParserConstant.L_IMAGE));
					if (!jsonObject.isNull(ParserConstant.LOCATION))
						jobChildBean.setLocation(jsonObject
								.getString(ParserConstant.LOCATION));
					if (!jsonObject.isNull(ParserConstant.NAME))
						jobChildBean.setName(jsonObject
								.getString(ParserConstant.NAME));
					if (!jsonObject.isNull(ParserConstant.PRODUCT_MODEL_NUMBER))
						jobChildBean
								.setProduct_model_number(jsonObject
										.getString(ParserConstant.PRODUCT_MODEL_NUMBER));
					if (!jsonObject.isNull(ParserConstant.L_QUANTITY))
						jobChildBean.setL_quantity(jsonObject
								.getString(ParserConstant.L_QUANTITY));
					if (!jsonObject.isNull(ParserConstant.L_UNIT))
						jobChildBean.setL_unit(jsonObject
								.getString(ParserConstant.L_UNIT));
					if (!jsonObject.isNull(ParserConstant.L_VALUE))
						jobChildBean.setL_value(jsonObject
								.getString(ParserConstant.L_VALUE));
					if (!jsonObject.isNull(ParserConstant.VENDOR_NAME))
						jobChildBean.setVendor_name(jsonObject
								.getString(ParserConstant.VENDOR_NAME));
					if (!jsonObject.isNull(ParserConstant.L_VENDOR_PART))
						jobChildBean.setL_vendor_part(jsonObject
								.getString(ParserConstant.L_VENDOR_PART));

					if (!jsonObject.isNull(ParserConstant.L_VENDOR_URL))
						jobChildBean.setL_vendor_url(jsonObject
								.getString(ParserConstant.L_VENDOR_URL));

					if (!jsonObject.isNull(ParserConstant.NAME))
						jobChildBean.setName(jsonObject
								.getString(ParserConstant.NAME));

					if (!jsonObject.isNull(ParserConstant.QUANTITY))
						jobChildBean.setQuantity(jsonObject
								.getString(ParserConstant.QUANTITY));

					if (!jsonObject.isNull(ParserConstant.VENDOR_URL))
						jobChildBean.setVendor_url(jsonObject
								.getString(ParserConstant.VENDOR_URL));

					if (!jsonObject.isNull(ParserConstant.VENDOR_PART_NUMBER))
						jobChildBean.setVendor_part_number(jsonObject
								.getString(ParserConstant.VENDOR_PART_NUMBER));

					if (!jsonObject.isNull(ParserConstant.VALUE))
						jobChildBean.setValue(jsonObject
								.getString(ParserConstant.VALUE));
					if (!jsonObject.isNull(ParserConstant.UNIT_VALUE))
						jobChildBean.setUnit_value(jsonObject
								.getString(ParserConstant.UNIT_VALUE));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				job.add(jobChildBean);
			}
			jobEntityBean.setInventoryList(job);

			return jobEntityBean;
		} else {
			return null;
		}
	}

	public static Object parseCreateInventories(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			InventoryChildBean jobChildBean = new InventoryChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.CATEGORY))
					jobChildBean.setCategory(jsonObject
							.getString(ParserConstant.CATEGORY));

				if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
					jobChildBean.setDescription(jsonObject
							.getString(ParserConstant.DESCRIPTION));

				if (!jsonObject.isNull(ParserConstant.L_CATEGORY))
					jobChildBean.setL_category(jsonObject
							.getString(ParserConstant.L_CATEGORY));
				if (!jsonObject.isNull(ParserConstant.L_DESCRIPTION))
					jobChildBean.setL_description(jsonObject
							.getString(ParserConstant.L_DESCRIPTION));
				if (!jsonObject.isNull(ParserConstant.L_IMAGE))
					jobChildBean.setL_image(jsonObject
							.getString(ParserConstant.L_IMAGE));
				if (!jsonObject.isNull(ParserConstant.L_LOCATION))
					jobChildBean.setL_location(jsonObject
							.getString(ParserConstant.L_LOCATION));
				if (!jsonObject.isNull(ParserConstant.L_NAME))
					jobChildBean.setL_name(jsonObject
							.getString(ParserConstant.L_NAME));
				if (!jsonObject.isNull(ParserConstant.L_PRODUCT_MODEL))
					jobChildBean.setL_product_model(jsonObject
							.getString(ParserConstant.L_PRODUCT_MODEL));
				if (!jsonObject.isNull(ParserConstant.L_QUANTITY))
					jobChildBean.setL_quantity(jsonObject
							.getString(ParserConstant.L_QUANTITY));
				if (!jsonObject.isNull(ParserConstant.L_UNIT))
					jobChildBean.setL_unit(jsonObject
							.getString(ParserConstant.L_UNIT));
				if (!jsonObject.isNull(ParserConstant.L_VALUE))
					jobChildBean.setL_value(jsonObject
							.getString(ParserConstant.L_VALUE));
				if (!jsonObject.isNull(ParserConstant.VENDOR_NAME))
					jobChildBean.setL_vendor_name(jsonObject
							.getString(ParserConstant.VENDOR_NAME));
				if (!jsonObject.isNull(ParserConstant.L_VENDOR_PART))
					jobChildBean.setL_vendor_part(jsonObject
							.getString(ParserConstant.L_VENDOR_PART));

				if (!jsonObject.isNull(ParserConstant.L_VENDOR_URL))
					jobChildBean.setL_vendor_url(jsonObject
							.getString(ParserConstant.L_VENDOR_URL));

				if (!jsonObject.isNull(ParserConstant.NAME))
					jobChildBean.setName(jsonObject
							.getString(ParserConstant.NAME));

				if (!jsonObject.isNull(ParserConstant.QUANTITY))
					jobChildBean.setQuantity(jsonObject
							.getString(ParserConstant.QUANTITY));

				if (!jsonObject.isNull(ParserConstant.VENDOR_URL))
					jobChildBean.setVendor_url(jsonObject
							.getString(ParserConstant.VENDOR_URL));

				if (!jsonObject.isNull(ParserConstant.SHIPPING_WEIGHT))
					jobChildBean.setVendor_part_number(jsonObject
							.getString(ParserConstant.VENDOR_PART_NUMBER));

				if (!jsonObject.isNull(ParserConstant.VALUE))
					jobChildBean.setValue(jsonObject
							.getString(ParserConstant.VALUE));
				if (!jsonObject.isNull(ParserConstant.UNIT_VALUE))
					jobChildBean.setUnit_value(jsonObject
							.getString(ParserConstant.UNIT_VALUE));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return jobChildBean;
		} else {
			return null;
		}
	}

	public static Object parseClient(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray("clients");

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			ArrayList<ClientChildBean> list = new ArrayList<ClientChildBean>();
			ClientEntityBean jobEntityBean = new ClientEntityBean();

			for (int i = 0; i < jsonArray.length(); i++) {
				ClientChildBean jobChildBean = new ClientChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);

					if (!jsonObject.isNull(ParserConstant.INITIAL))
						jobChildBean.setInitial(jsonObject
								.getString(ParserConstant.INITIAL));

					if (!jsonObject.isNull(ParserConstant.FIRST_NAME))
						jobChildBean.setFirst_name(jsonObject
								.getString(ParserConstant.FIRST_NAME));

					if (!jsonObject.isNull(ParserConstant.LAST_NAME))
						jobChildBean.setLast_name(jsonObject
								.getString(ParserConstant.LAST_NAME));

					if (!jsonObject.isNull(ParserConstant.COMPANY_NAME))
						jobChildBean.setCompany_name(jsonObject
								.getString(ParserConstant.COMPANY_NAME));
					if (!jsonObject.isNull(ParserConstant.CITY))
						jobChildBean.setCity(jsonObject
								.getString(ParserConstant.CITY));
					if (!jsonObject.isNull(ParserConstant.STATE))
						jobChildBean.setState(jsonObject
								.getString(ParserConstant.STATE));
					if (!jsonObject.isNull(ParserConstant.PERSONAL_EMAIL))
						jobChildBean.setEmail(jsonObject
								.getString(ParserConstant.PERSONAL_EMAIL));
					if (!jsonObject.isNull(ParserConstant.MOBILE_NUMBER))
						jobChildBean.setMobile_number(jsonObject
								.getString(ParserConstant.MOBILE_NUMBER));

					if (!jsonObject.isNull(ParserConstant.ID))
						jobChildBean.setId(jsonObject
								.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
						jobChildBean.setUpdated_at(jsonObject
								.getString(ParserConstant.UPDATED_AT));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(jobChildBean);
			}
			jobEntityBean.setClientList(list);

			return jobEntityBean;

		} else
			return null;
	}

	// 06-25 18:39:18.454: V/CopperApp(1408): Response ::
	// {"id":6,"initial":"Mr.","first_name":"NIlesh","last_name":"patel","company_name":"cdn software solution","primary_company":null,"street1":null,"street2":null,"city":null,"state":null,"zip_code":null,"country":null,"phone_initial":null,"phone_number":null,"email_initial":null,"email":null,"created_at":"2015-06-11T18:20:37.887Z","updated_at":"2015-06-25T18:39:18.355Z","user_id":2,"client_tag":[],"custom_field":null,"mobile_number":"ddsfsdf","personal_email":"np@gmail.co","preference_notification":null}

	public static Object parseCreateClient(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ClientChildBean jobChildBean = new ClientChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.FIRST_NAME))
					jobChildBean.setFirst_name(jsonObject
							.getString(ParserConstant.FIRST_NAME));

				if (!jsonObject.isNull(ParserConstant.LAST_NAME))
					jobChildBean.setLast_name(jsonObject
							.getString(ParserConstant.LAST_NAME));

				if (!jsonObject.isNull(ParserConstant.COMPANY_NAME))
					jobChildBean.setCompany_name(jsonObject
							.getString(ParserConstant.COMPANY_NAME));
				if (!jsonObject.isNull(ParserConstant.CITY))
					jobChildBean.setCity(jsonObject
							.getString(ParserConstant.CITY));
				if (!jsonObject.isNull(ParserConstant.STATE))
					jobChildBean.setState(jsonObject
							.getString(ParserConstant.STATE));
				if (!jsonObject.isNull(ParserConstant.EMAIL))
					jobChildBean.setEmail(jsonObject
							.getString(ParserConstant.EMAIL));
				if (!jsonObject.isNull(ParserConstant.ID))
					jobChildBean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
					jobChildBean.setUpdated_at(jsonObject
							.getString(ParserConstant.UPDATED_AT));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jobChildBean;

		} else
			return null;
	}

	public static Object parseCreateProperty(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PropertyBean jobChildBean = new PropertyBean();
			try {
				if (!jsonObject.isNull(ParserConstant.STREET1))
					jobChildBean.setStreet(jsonObject
							.getString(ParserConstant.STREET1));

				if (!jsonObject.isNull(ParserConstant.STATE))
					jobChildBean.setState(jsonObject
							.getString(ParserConstant.STATE));
				if (!jsonObject.isNull(ParserConstant.COUNTRY))
					jobChildBean.setCountry(jsonObject
							.getString(ParserConstant.COUNTRY));

				if (!jsonObject.isNull(ParserConstant.ZIP_CODE))
					jobChildBean.setZipcode(jsonObject
							.getString(ParserConstant.ZIP_CODE));
				if (!jsonObject.isNull(ParserConstant.CITY))
					jobChildBean.setCity(jsonObject
							.getString(ParserConstant.CITY));
				if (!jsonObject.isNull(ParserConstant.CLIENT_ID))
					jobChildBean.setClient_id(jsonObject
							.getString(ParserConstant.CLIENT_ID));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jobChildBean;

		} else
			return null;
	}

	public static Object parseProperty(String response) {
		if (response != null) {
			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray(ConstantLib.PROPERTIES);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ArrayList<PropertyBean> list = new ArrayList<PropertyBean>();
			for (int i = 0; i < jsonArray.length(); i++) {
				try {
					jsonObject = jsonArray.getJSONObject(i);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PropertyBean jobChildBean = new PropertyBean();
				try {
					if (!jsonObject.isNull(ParserConstant.STREET))
						jobChildBean.setStreet(jsonObject
								.getString(ParserConstant.STREET));
					if (!jsonObject.isNull(ParserConstant.ID))
						jobChildBean.setId(jsonObject
								.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.STATE))
						jobChildBean.setState(jsonObject
								.getString(ParserConstant.STATE));
					if (!jsonObject.isNull(ParserConstant.COUNTRY))
						jobChildBean.setCountry(jsonObject
								.getString(ParserConstant.COUNTRY));

					if (!jsonObject.isNull(ParserConstant.ZIP_CODE))
						jobChildBean.setZipcode(jsonObject
								.getString(ParserConstant.ZIP_CODE));
					if (!jsonObject.isNull(ParserConstant.CITY))
						jobChildBean.setCity(jsonObject
								.getString(ParserConstant.CITY));
					if (!jsonObject.isNull(ParserConstant.CLIENT_ID))
						jobChildBean.setClient_id(jsonObject
								.getString(ParserConstant.CLIENT_ID));

					list.add(jobChildBean);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// PropertyParentBean propertyParentBean=new PropertyParentBean();
			// propertyParentBean.setPropertyList(list);
			return list;
		}
		return null;

	}

	public static Object parseCreateJob(String response) {

		if (response != null) {
			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JobChildBean jobChildBean = new JobChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.COMPLETE_ON))
					jobChildBean.setComplete_on(jsonObject
							.getString(ParserConstant.COMPLETE_ON));

				if (!jsonObject.isNull(ParserConstant.CREATED_AT))
					jobChildBean.setCreated_at(jsonObject
							.getString(ParserConstant.CREATED_AT));

				if (!jsonObject.isNull(ParserConstant.CREW))
					jobChildBean.setCrew(jsonObject
							.getString(ParserConstant.CREW));
				if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
					jobChildBean.setCustom_field(jsonObject
							.getString(ParserConstant.CUSTOM_FIELD));
				if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
					jobChildBean.setDescription(jsonObject
							.getString(ParserConstant.DESCRIPTION));
				if (!jsonObject.isNull(ParserConstant.END_DATE))
					jobChildBean.setEnd_date(jsonObject
							.getString(ParserConstant.END_DATE));
				if (!jsonObject.isNull(ParserConstant.END_TIME))
					jobChildBean.setEnd_date(jsonObject
							.getString(ParserConstant.END_TIME));
				if (!jsonObject.isNull(ParserConstant.FIRST_INVOICE_ON))
					jobChildBean.setFirst_invoice_on(jsonObject
							.getString(ParserConstant.FIRST_INVOICE_ON));
				if (!jsonObject.isNull(ParserConstant.ID))
					jobChildBean.setId(jsonObject.getString(ParserConstant.ID));
				if (!jsonObject.isNull(ParserConstant.INVOICE_PERIOD))
					jobChildBean.setInvoice_period(jsonObject
							.getString(ParserConstant.INVOICE_PERIOD));
				if (!jsonObject.isNull(ParserConstant.INVOICE_TYPE))
					jobChildBean.setInvoice_type(jsonObject
							.getString(ParserConstant.INVOICE_TYPE));
				if (!jsonObject.isNull(ParserConstant.INVOICING))
					jobChildBean.setInvoicing(jsonObject
							.getString(ParserConstant.INVOICING));
				if (!jsonObject.isNull(ParserConstant.JOB_COMPLETE))
					jobChildBean.setJob_complete(jsonObject
							.getString(ParserConstant.JOB_COMPLETE));
				if (!jsonObject.isNull(ParserConstant.JOB_ORDER))
					jobChildBean.setJob_order(jsonObject
							.getString(ParserConstant.JOB_ORDER));

				if (!jsonObject.isNull(ParserConstant.JOB_REQUIRED))
					jobChildBean.setJob_required(jsonObject
							.getString(ParserConstant.JOB_REQUIRED));

				if (!jsonObject.isNull(ParserConstant.JOB_STATUS))
					jobChildBean.setJob_status(jsonObject
							.getString(ParserConstant.JOB_STATUS));

				if (!jsonObject.isNull(ParserConstant.PROPERTY_ID))
					jobChildBean.setProperty_id(jsonObject
							.getString(ParserConstant.PROPERTY_ID));

				if (!jsonObject.isNull(ParserConstant.QUOTE_ID))
					jobChildBean.setQuote_id(jsonObject
							.getString(ParserConstant.QUOTE_ID));

				if (!jsonObject.isNull(ParserConstant.SCHEDULED))
					jobChildBean.setScheduled(jsonObject
							.getString(ParserConstant.SCHEDULED));

				if (!jsonObject.isNull(ParserConstant.START_DATE))
					jobChildBean.setStart_date(jsonObject
							.getString(ParserConstant.START_DATE));

				if (!jsonObject.isNull(ParserConstant.START_TIME))
					jobChildBean.setStart_time(jsonObject
							.getString(ParserConstant.START_TIME));
				if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
					jobChildBean.setUpdated_at(jsonObject
							.getString(ParserConstant.UPDATED_AT));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return jobChildBean;
		} else {
			return null;
		}
	}

	public static Object parseQuote(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONArray jsonArray2 = null;

			JSONObject jsonObject = null;
			JSONObject jsonObject2 = null;

			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray(ConstantLib.QUOTES);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			ArrayList<QuoteChildBean> list = new ArrayList<QuoteChildBean>();
			QuoteBean childBean = new QuoteBean();

			for (int i = 0; i < jsonArray.length(); i++) {
				QuoteChildBean jobChildBean = new QuoteChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);

					if (!jsonObject.isNull(ParserConstant.ID))
						jobChildBean.setId(jsonObject
								.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.QUOTE_ORDER))
						jobChildBean.setQuote_order(jsonObject
								.getString(ParserConstant.QUOTE_ORDER));

					if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
						jobChildBean.setCustom_field(jsonObject
								.getString(ParserConstant.CUSTOM_FIELD));
					if (!jsonObject.isNull(ParserConstant.SENT))
						jobChildBean.setSent(jsonObject
								.getString(ParserConstant.SENT));
					if (!jsonObject.isNull(ParserConstant.ARCHIVE))
						jobChildBean.setArchive(jsonObject
								.getString(ParserConstant.ARCHIVE));
					if (!jsonObject.isNull(ParserConstant.CLIENT_MESSAGE))
						jobChildBean.setClient_message(jsonObject
								.getString(ParserConstant.CLIENT_MESSAGE));
					if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
						jobChildBean.setCustom_field(jsonObject
								.getString(ParserConstant.CUSTOM_FIELD));

					if (!jsonObject.isNull(ParserConstant.DISCOUNT))
						jobChildBean.setDiscount(jsonObject
								.getString(ParserConstant.DISCOUNT));
					if (!jsonObject.isNull(ParserConstant.DISCOUNT))
						jobChildBean.setDiscount(jsonObject
								.getString(ParserConstant.DISCOUNT));
					if (!jsonObject.isNull(ParserConstant.DISCOUNT_TYPE))
						jobChildBean.setDiscount_type(jsonObject
								.getString(ParserConstant.DISCOUNT_TYPE));

					if (!jsonObject.isNull(ParserConstant.IS_MAILED))
						jobChildBean.setIs_mailed(jsonObject
								.getString(ParserConstant.IS_MAILED));

					if (!jsonObject.isNull(ParserConstant.PROPERTY_ID))
						jobChildBean.setProperty_id(jsonObject
								.getString(ParserConstant.PROPERTY_ID));
					if (!jsonObject.isNull(ParserConstant.RATY_SCORE))
						jobChildBean.setRaty_score(jsonObject
								.getString(ParserConstant.RATY_SCORE));
					if (!jsonObject.isNull(ParserConstant.TAX))
						jobChildBean.setTax(jsonObject
								.getString(ParserConstant.TAX));

					if (!jsonObject.isNull(ParserConstant.REQUIRE_DEPOSIT))
						jobChildBean.setRequire_deposit(jsonObject
								.getString(ParserConstant.REQUIRE_DEPOSIT));
					if (!jsonObject.isNull(ParserConstant.REQUIRE_DEPOSIT_TYPE))
						jobChildBean
								.setRequire_deposit_type(jsonObject
										.getString(ParserConstant.REQUIRE_DEPOSIT_TYPE));

					jsonArray2 = jsonObject
							.getJSONArray(ConstantLib.QUOTE_WORKS);
					jsonObject2 = jsonArray2.getJSONObject(0);

					if (!jsonObject2.isNull(ParserConstant.NAME))
						jobChildBean.setName(jsonObject2
								.getString(ParserConstant.NAME));
					if (!jsonObject2.isNull(ParserConstant.DESCRIPTION))
						jobChildBean.setDescription(jsonObject2
								.getString(ParserConstant.DESCRIPTION));
					if (!jsonObject2.isNull(ParserConstant.QUANTITY))
						jobChildBean.setQuantity(jsonObject2
								.getString(ParserConstant.QUANTITY));
					if (!jsonObject2.isNull(ParserConstant.UNIT_COST))
						jobChildBean.setUnit_cost(jsonObject2
								.getString(ParserConstant.UNIT_COST));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(jobChildBean);
			}
			childBean.setQuoteList(list);

			return childBean;

		} else
			return null;
	}

	public static Object parseCreateQuote(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			QuoteChildBean jobChildBean = new QuoteChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.ID))
					jobChildBean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.QUOTE_ORDER))
					jobChildBean.setQuote_order(jsonObject
							.getString(ParserConstant.QUOTE_ORDER));

				if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
					jobChildBean.setCustom_field(jsonObject
							.getString(ParserConstant.CUSTOM_FIELD));
				if (!jsonObject.isNull(ParserConstant.SENT))
					jobChildBean.setSent(jsonObject
							.getString(ParserConstant.SENT));
				if (!jsonObject.isNull(ParserConstant.ARCHIVE))
					jobChildBean.setArchive(jsonObject
							.getString(ParserConstant.ARCHIVE));
				if (!jsonObject.isNull(ParserConstant.EMAIL))
					jobChildBean.setClient_message(jsonObject
							.getString(ParserConstant.CLIENT_MESSAGE));
				if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
					jobChildBean.setCustom_field(jsonObject
							.getString(ParserConstant.CUSTOM_FIELD));

				if (!jsonObject.isNull(ParserConstant.DISCOUNT))
					jobChildBean.setDiscount(jsonObject
							.getString(ParserConstant.DISCOUNT));
				if (!jsonObject.isNull(ParserConstant.DISCOUNT))
					jobChildBean.setDiscount(jsonObject
							.getString(ParserConstant.DISCOUNT));
				if (!jsonObject.isNull(ParserConstant.DISCOUNT_TYPE))
					jobChildBean.setDiscount_type(jsonObject
							.getString(ParserConstant.DISCOUNT_TYPE));

				if (!jsonObject.isNull(ParserConstant.IS_MAILED))
					jobChildBean.setIs_mailed(jsonObject
							.getString(ParserConstant.IS_MAILED));

				if (!jsonObject.isNull(ParserConstant.PROPERTY_ID))
					jobChildBean.setProperty_id(jsonObject
							.getString(ParserConstant.PROPERTY_ID));
				if (!jsonObject.isNull(ParserConstant.RATY_SCORE))
					jobChildBean.setRaty_score(jsonObject
							.getString(ParserConstant.RATY_SCORE));

				if (!jsonObject.isNull(ParserConstant.REQUIRE_DEPOSIT))
					jobChildBean.setRequire_deposit(jsonObject
							.getString(ParserConstant.REQUIRE_DEPOSIT));
				if (!jsonObject.isNull(ParserConstant.REQUIRE_DEPOSIT_TYPE))
					jobChildBean.setRequire_deposit_type(jsonObject
							.getString(ParserConstant.REQUIRE_DEPOSIT_TYPE));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return jobChildBean;

		} else
			return null;
	}

	public static Object parseTask(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObjectMain = null;
			JSONObject jsonObject = null;
			try {
				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray("basic_tasks");
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ArrayList<TaskChildBean> list = new ArrayList<TaskChildBean>();

			for (int i = 0; i < jsonArray.length(); i++) {
				TaskChildBean bean = new TaskChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.ID))
						bean.setId(jsonObject.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.ALL_DAY))
						bean.setAll_day(jsonObject
								.getString(ParserConstant.ALL_DAY));

					if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
						bean.setDescription(jsonObject
								.getString(ParserConstant.DESCRIPTION));
					if (!jsonObject.isNull(ParserConstant.END_AT_DATE))
						bean.setEnd_at_date(jsonObject
								.getString(ParserConstant.END_AT_DATE));
					if (!jsonObject.isNull(ParserConstant.END_AT_TIME))
						bean.setEnd_at_time(jsonObject
								.getString(ParserConstant.END_AT_TIME));
					if (!jsonObject.isNull(ParserConstant.IS_COMPLETED))
						bean.setIs_completed(jsonObject
								.getString(ParserConstant.IS_COMPLETED));
					if (!jsonObject.isNull(ParserConstant.START_AT_DATE))
						bean.setStart_at_date(jsonObject
								.getString(ParserConstant.START_AT_DATE));

					if (!jsonObject.isNull(ParserConstant.START_AT_TIME))
						bean.setStart_at_time(jsonObject
								.getString(ParserConstant.START_AT_TIME));
					if (!jsonObject.isNull(ParserConstant.TITLE))
						bean.setTitle(jsonObject
								.getString(ParserConstant.TITLE));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(bean);
			}

			return list;

		} else
			return null;
	}

	public static Object parseCreateTask(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ArrayList<TaskChildBean> list = new ArrayList<TaskChildBean>();
			TaskChildBean bean = new TaskChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.ID))
					bean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.ALL_DAY))
					bean.setAll_day(jsonObject
							.getString(ParserConstant.ALL_DAY));

				if (!jsonObject.isNull(ParserConstant.DESCRIPTION))
					bean.setDescription(jsonObject
							.getString(ParserConstant.DESCRIPTION));
				if (!jsonObject.isNull(ParserConstant.END_AT_DATE))
					bean.setEnd_at_date(jsonObject
							.getString(ParserConstant.END_AT_DATE));
				if (!jsonObject.isNull(ParserConstant.END_AT_TIME))
					bean.setEnd_at_time(jsonObject
							.getString(ParserConstant.END_AT_TIME));
				if (!jsonObject.isNull(ParserConstant.IS_COMPLETED))
					bean.setIs_completed(jsonObject
							.getString(ParserConstant.IS_COMPLETED));
				if (!jsonObject.isNull(ParserConstant.START_AT_DATE))
					bean.setStart_at_date(jsonObject
							.getString(ParserConstant.START_AT_DATE));

				if (!jsonObject.isNull(ParserConstant.START_AT_TIME))
					bean.setStart_at_time(jsonObject
							.getString(ParserConstant.START_AT_TIME));
				if (!jsonObject.isNull(ParserConstant.TITLE))
					bean.setTitle(jsonObject.getString(ParserConstant.TITLE));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return bean;

		} else
			return null;
	}

	public static Object parseCreateExpanses(String response) {
		if (response != null) {

			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ExpensesChildBean bean = new ExpensesChildBean();
			try {
				if (!jsonObject.isNull(ParserConstant.ID))
					bean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.CLEAN_DATE))
					bean.setClean_date(jsonObject
							.getString(ParserConstant.CLEAN_DATE));

				if (!jsonObject.isNull(ParserConstant.COST))
					bean.setCost(jsonObject.getString(ParserConstant.COST));
				if (!jsonObject.isNull(ParserConstant.EXP_BILLABLE))
					bean.setExp_billable(jsonObject
							.getString(ParserConstant.EXP_BILLABLE));
				if (!jsonObject.isNull(ParserConstant.EXP_CATEGORY))
					bean.setExp_category(jsonObject
							.getString(ParserConstant.EXP_CATEGORY));
				if (!jsonObject.isNull(ParserConstant.EXP_REIMBURSABLE))
					bean.setExp_reimbursable(jsonObject
							.getString(ParserConstant.EXP_REIMBURSABLE));
				if (!jsonObject.isNull(ParserConstant.EXPENSE_TYPE))
					bean.setExpense_type(jsonObject
							.getString(ParserConstant.EXPENSE_TYPE));

				if (!jsonObject.isNull(ParserConstant.IMAGE_CONTENT_TYPE))
					bean.setImage_content_type(jsonObject
							.getString(ParserConstant.IMAGE_CONTENT_TYPE));
				if (!jsonObject.isNull(ParserConstant.IMAGE_FILE_NAME))
					bean.setImage_file_name(jsonObject
							.getString(ParserConstant.IMAGE_FILE_NAME));
				if (!jsonObject.isNull(ParserConstant.IMAGE_FILE_SIZE))
					bean.setImage_file_size(jsonObject
							.getString(ParserConstant.IMAGE_FILE_SIZE));

				if (!jsonObject.isNull(ParserConstant.JOB_ID))
					bean.setJob_id(jsonObject.getString(ParserConstant.JOB_ID));

				if (!jsonObject.isNull(ParserConstant.MILES))
					bean.setMiles(jsonObject.getString(ParserConstant.MILES));
				if (!jsonObject.isNull(ParserConstant.NAME))
					bean.setName(jsonObject.getString(ParserConstant.NAME));

				if (!jsonObject.isNull(ParserConstant.NOTE))
					bean.setNote(jsonObject.getString(ParserConstant.NOTE));
				if (!jsonObject.isNull(ParserConstant.PENDING_PAYMENT))
					bean.setPending_payment(jsonObject
							.getString(ParserConstant.PENDING_PAYMENT));
				if (!jsonObject.isNull(ParserConstant.REIMBURSABLE_TO_ID))
					bean.setReimbursable_to_id(jsonObject
							.getString(ParserConstant.REIMBURSABLE_TO_ID));
				if (!jsonObject.isNull(ParserConstant.UNIT))
					bean.setUnit(jsonObject.getString(ParserConstant.UNIT));

				if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
					bean.setUpdated_at(jsonObject
							.getString(ParserConstant.UPDATED_AT));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return bean;

		} else
			return null;
	}

	public static Object parseExpanses(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray(ConstantLib.EXPENSES);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			ArrayList<ExpensesChildBean> list = new ArrayList<ExpensesChildBean>();

			for (int i = 0; i < jsonArray.length(); i++) {
				ExpensesChildBean bean = new ExpensesChildBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.ID))
						bean.setId(jsonObject.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.CLEAN_DATE))
						bean.setClean_date(jsonObject
								.getString(ParserConstant.CLEAN_DATE));

					if (!jsonObject.isNull(ParserConstant.COST))
						bean.setCost(jsonObject.getString(ParserConstant.COST));
					if (!jsonObject.isNull(ParserConstant.EXP_BILLABLE))
						bean.setExp_billable(jsonObject
								.getString(ParserConstant.EXP_BILLABLE));
					if (!jsonObject.isNull(ParserConstant.EXP_CATEGORY))
						bean.setExp_category(jsonObject
								.getString(ParserConstant.EXP_CATEGORY));
					if (!jsonObject.isNull(ParserConstant.EXP_REIMBURSABLE))
						bean.setExp_reimbursable(jsonObject
								.getString(ParserConstant.EXP_REIMBURSABLE));
					if (!jsonObject.isNull(ParserConstant.EXPENSE_TYPE))
						bean.setExpense_type(jsonObject
								.getString(ParserConstant.EXPENSE_TYPE));

					if (!jsonObject.isNull(ParserConstant.IMAGE_CONTENT_TYPE))
						bean.setImage_content_type(jsonObject
								.getString(ParserConstant.IMAGE_CONTENT_TYPE));
					if (!jsonObject.isNull(ParserConstant.IMAGE_FILE_NAME))
						bean.setImage_file_name(jsonObject
								.getString(ParserConstant.IMAGE_FILE_NAME));
					if (!jsonObject.isNull(ParserConstant.IMAGE_FILE_SIZE))
						bean.setImage_file_size(jsonObject
								.getString(ParserConstant.IMAGE_FILE_SIZE));

					if (!jsonObject.isNull(ParserConstant.JOB_ID))
						bean.setJob_id(jsonObject
								.getString(ParserConstant.JOB_ID));

					if (!jsonObject.isNull(ParserConstant.MILES))
						bean.setMiles(jsonObject
								.getString(ParserConstant.MILES));
					if (!jsonObject.isNull(ParserConstant.NAME))
						bean.setName(jsonObject.getString(ParserConstant.NAME));

					if (!jsonObject.isNull(ParserConstant.NOTE))
						bean.setNote(jsonObject.getString(ParserConstant.NOTE));
					if (!jsonObject.isNull(ParserConstant.PENDING_PAYMENT))
						bean.setPending_payment(jsonObject
								.getString(ParserConstant.PENDING_PAYMENT));
					if (!jsonObject.isNull(ParserConstant.REIMBURSABLE_TO_ID))
						bean.setReimbursable_to_id(jsonObject
								.getString(ParserConstant.REIMBURSABLE_TO_ID));
					if (!jsonObject.isNull(ParserConstant.UNIT))
						bean.setUnit(jsonObject.getString(ParserConstant.UNIT));

					if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
						bean.setUpdated_at(jsonObject
								.getString(ParserConstant.UPDATED_AT));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(bean);
			}

			return list;

		} else
			return null;
	}

	public static Object parseInvoices(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			JSONObject jsonObjectMain = null;

			try {

				jsonObjectMain = new JSONObject(response);
				jsonArray = jsonObjectMain.getJSONArray(ConstantLib.INVOICES);

			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			ArrayList<InvoiceBean> list = new ArrayList<InvoiceBean>();

			for (int i = 0; i < jsonArray.length(); i++) {
				InvoiceBean bean = new InvoiceBean();
				try {
					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.ID))
						bean.setId(jsonObject.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.ADDITIONAL_NOTE))
						bean.setAdditional_note(jsonObject
								.getString(ParserConstant.ADDITIONAL_NOTE));

					if (!jsonObject.isNull(ParserConstant.CLIENT_ID))
						bean.setClient_id(jsonObject
								.getString(ParserConstant.CLIENT_ID));
					if (!jsonObject.isNull(ParserConstant.CLIENT_MESSAGE))
						bean.setClient_message(jsonObject
								.getString(ParserConstant.CLIENT_MESSAGE));
					if (!jsonObject.isNull(ParserConstant.CREATED_AT))
						bean.setCreated_at(jsonObject
								.getString(ParserConstant.CREATED_AT));
					if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
						bean.setCustom_field(jsonObject
								.getString(ParserConstant.CUSTOM_FIELD));
					if (!jsonObject.isNull(ParserConstant.DEPOSITE_AMOUNT))
						bean.setDeposite_amount(jsonObject
								.getString(ParserConstant.DEPOSITE_AMOUNT));

					if (!jsonObject.isNull(ParserConstant.DISCOUNT_AMOUNT))
						bean.setDiscount_amount(jsonObject
								.getString(ParserConstant.DISCOUNT_AMOUNT));
					if (!jsonObject.isNull(ParserConstant.DISCOUNT_TYPE))
						bean.setDiscount_type(jsonObject
								.getString(ParserConstant.DISCOUNT_TYPE));
					if (!jsonObject.isNull(ParserConstant.DUE_DATE))
						bean.setDue_date(jsonObject
								.getString(ParserConstant.DUE_DATE));

					if (!jsonObject.isNull(ParserConstant.ENTRY_DATE))
						bean.setEntry_date(jsonObject
								.getString(ParserConstant.ENTRY_DATE));

					if (!jsonObject.isNull(ParserConstant.INVOICE_BAD_DEBT))
						bean.setInvoice_bad_debt(jsonObject
								.getString(ParserConstant.INVOICE_BAD_DEBT));
					if (!jsonObject.isNull(ParserConstant.INVOICE_ORDER))
						bean.setInvoice_order(jsonObject
								.getString(ParserConstant.INVOICE_ORDER));

					if (!jsonObject.isNull(ParserConstant.INVOICE_PAID))
						bean.setInvoice_paid(jsonObject
								.getString(ParserConstant.INVOICE_PAID));
					if (!jsonObject.isNull(ParserConstant.IS_MAILED))
						bean.setIs_mailed(jsonObject
								.getString(ParserConstant.IS_MAILED));
					if (!jsonObject.isNull(ParserConstant.ISSUED_DATE))
						bean.setIssued_date(jsonObject
								.getString(ParserConstant.ISSUED_DATE));
					if (!jsonObject.isNull(ParserConstant.JOB_ID))
						bean.setJobs_id(jsonObject
								.getString(ParserConstant.JOB_ID));

					if (!jsonObject.isNull(ParserConstant.MARK_SENT))
						bean.setMark_sent(jsonObject
								.getString(ParserConstant.MARK_SENT));
					if (!jsonObject.isNull(ParserConstant.PAST_DUE))
						bean.setPast_due(jsonObject
								.getString(ParserConstant.PAST_DUE));
					if (!jsonObject.isNull(ParserConstant.PAYMENT))
						bean.setPayment(jsonObject
								.getString(ParserConstant.PAYMENT));
					if (!jsonObject.isNull(ParserConstant.PAYMENT_METHOD))
						bean.setPayment_method(jsonObject
								.getString(ParserConstant.PAYMENT_METHOD));
					if (!jsonObject.isNull(ParserConstant.PAYMENT_METHOD_TYPE))
						bean.setPayment_method_type(jsonObject
								.getString(ParserConstant.PAYMENT_METHOD_TYPE));
					if (!jsonObject.isNull(ParserConstant.QUOTE_ID))
						bean.setQuote_id(jsonObject
								.getString(ParserConstant.QUOTE_ID));
					if (!jsonObject.isNull(ParserConstant.SUBJECT))
						bean.setSubject(jsonObject
								.getString(ParserConstant.SUBJECT));

					if (!jsonObject.isNull(ParserConstant.TAX))
						bean.setTax(jsonObject.getString(ParserConstant.TAX));
					if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
						bean.setUpdated_at(jsonObject
								.getString(ParserConstant.UPDATED_AT));

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.add(bean);
			}

			return list;

		} else
			return null;
	}

	public static Object parseCreateInvoices(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			InvoiceBean bean = new InvoiceBean();
			try {
				if (!jsonObject.isNull(ParserConstant.ID))
					bean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.ADDITIONAL_NOTE))
					bean.setAdditional_note(jsonObject
							.getString(ParserConstant.ADDITIONAL_NOTE));

				if (!jsonObject.isNull(ParserConstant.CLIENT_ID))
					bean.setClient_id(jsonObject
							.getString(ParserConstant.CLIENT_ID));
				if (!jsonObject.isNull(ParserConstant.CLIENT_MESSAGE))
					bean.setClient_message(jsonObject
							.getString(ParserConstant.CLIENT_MESSAGE));
				if (!jsonObject.isNull(ParserConstant.CREATED_AT))
					bean.setCreated_at(jsonObject
							.getString(ParserConstant.CREATED_AT));
				if (!jsonObject.isNull(ParserConstant.CUSTOM_FIELD))
					bean.setCustom_field(jsonObject
							.getString(ParserConstant.CUSTOM_FIELD));
				if (!jsonObject.isNull(ParserConstant.DEPOSITE_AMOUNT))
					bean.setDeposite_amount(jsonObject
							.getString(ParserConstant.DEPOSITE_AMOUNT));

				if (!jsonObject.isNull(ParserConstant.DISCOUNT_AMOUNT))
					bean.setDiscount_amount(jsonObject
							.getString(ParserConstant.DISCOUNT_AMOUNT));
				if (!jsonObject.isNull(ParserConstant.DISCOUNT_TYPE))
					bean.setDiscount_type(jsonObject
							.getString(ParserConstant.DISCOUNT_TYPE));
				if (!jsonObject.isNull(ParserConstant.DUE_DATE))
					bean.setDue_date(jsonObject
							.getString(ParserConstant.DUE_DATE));

				if (!jsonObject.isNull(ParserConstant.ENTRY_DATE))
					bean.setEntry_date(jsonObject
							.getString(ParserConstant.ENTRY_DATE));

				if (!jsonObject.isNull(ParserConstant.INVOICE_BAD_DEBT))
					bean.setInvoice_bad_debt(jsonObject
							.getString(ParserConstant.INVOICE_BAD_DEBT));
				if (!jsonObject.isNull(ParserConstant.INVOICE_ORDER))
					bean.setInvoice_order(jsonObject
							.getString(ParserConstant.INVOICE_ORDER));

				if (!jsonObject.isNull(ParserConstant.INVOICE_PAID))
					bean.setInvoice_paid(jsonObject
							.getString(ParserConstant.INVOICE_PAID));
				if (!jsonObject.isNull(ParserConstant.IS_MAILED))
					bean.setIs_mailed(jsonObject
							.getString(ParserConstant.IS_MAILED));
				if (!jsonObject.isNull(ParserConstant.ISSUED_DATE))
					bean.setIssued_date(jsonObject
							.getString(ParserConstant.ISSUED_DATE));
				if (!jsonObject.isNull(ParserConstant.JOB_ID))
					bean.setJobs_id(jsonObject.getString(ParserConstant.JOB_ID));

				if (!jsonObject.isNull(ParserConstant.MARK_SENT))
					bean.setMark_sent(jsonObject
							.getString(ParserConstant.MARK_SENT));
				if (!jsonObject.isNull(ParserConstant.PAST_DUE))
					bean.setPast_due(jsonObject
							.getString(ParserConstant.PAST_DUE));
				if (!jsonObject.isNull(ParserConstant.PAYMENT))
					bean.setPayment(jsonObject
							.getString(ParserConstant.PAYMENT));
				if (!jsonObject.isNull(ParserConstant.PAYMENT_METHOD))
					bean.setPayment_method(jsonObject
							.getString(ParserConstant.PAYMENT_METHOD));
				if (!jsonObject.isNull(ParserConstant.PAYMENT_METHOD_TYPE))
					bean.setPayment_method_type(jsonObject
							.getString(ParserConstant.PAYMENT_METHOD_TYPE));
				if (!jsonObject.isNull(ParserConstant.QUOTE_ID))
					bean.setQuote_id(jsonObject
							.getString(ParserConstant.QUOTE_ID));
				if (!jsonObject.isNull(ParserConstant.SUBJECT))
					bean.setSubject(jsonObject
							.getString(ParserConstant.SUBJECT));

				if (!jsonObject.isNull(ParserConstant.TAX))
					bean.setTax(jsonObject.getString(ParserConstant.TAX));
				if (!jsonObject.isNull(ParserConstant.UPDATED_AT))
					bean.setUpdated_at(jsonObject
							.getString(ParserConstant.UPDATED_AT));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return bean;

		} else
			return null;
	}

	public static Object parseTimeSheet(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;

			JSONObject jsonObject2 = null;
			try {
				jsonObject2 = new JSONObject(response);
				if (jsonObject2.has("timesheets")) {
					jsonArray = jsonObject2.getJSONArray("timesheets");
				}
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
			// 07-21 18:49:51.769: V/CopperApp(1434): Response ::
			// {"timesheets":[{"id":46,"user_id":5,"start_date":"2015-07-21","auto_start_timer":false,"job_id":null,"label":null,"note":"sdfsdf","start_time":"2000-01-01T18:21:00.000Z","end_time":"2000-01-01T18:21:00.000Z","duration":null,"created_at":"2015-07-21T18:21:15.350Z","updated_at":"2015-07-21T18:21:15.350Z","day":"2015-07-21","custom_category_id":null,"billable":false,"sync_type":false}]}

			ArrayList<TimesheetBean> arrayList = new ArrayList<TimesheetBean>();
			try {
				for (int i = 0; i < jsonArray.length(); i++) {
					TimesheetBean bean = new TimesheetBean();

					jsonObject = jsonArray.getJSONObject(i);
					if (!jsonObject.isNull(ParserConstant.ID))
						bean.setId(jsonObject.getString(ParserConstant.ID));

					if (!jsonObject.isNull(ParserConstant.START_TIME))
						bean.setStart_time(jsonObject
								.getString(ParserConstant.START_TIME));

					if (!jsonObject.isNull(ParserConstant.AUTO_START_TIMER))
						bean.setAuto_start_timer(jsonObject
								.getString(ParserConstant.AUTO_START_TIMER));
					if (!jsonObject.isNull(ParserConstant.END_TIME))
						bean.setEnd_time(jsonObject
								.getString(ParserConstant.END_TIME));
					if (!jsonObject.isNull(ParserConstant.BILLABLE))
						bean.setBillable(jsonObject
								.getString(ParserConstant.BILLABLE));
					if (!jsonObject.isNull(ParserConstant.DURATION))
						bean.setDuration(jsonObject
								.getString(ParserConstant.DURATION));
					if (!jsonObject.isNull(ParserConstant.NOTE))
						bean.setNote(jsonObject.getString(ParserConstant.NOTE));

					arrayList.add(bean);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return arrayList;

		} else
			return null;
	}

	public static Object parseTimeCreateSheet(String response) {
		if (response != null) {

			JSONArray jsonArray = null;
			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject(response);
			} catch (JSONException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}

			TimesheetBean bean = new TimesheetBean();
			try {
				if (!jsonObject.isNull(ParserConstant.ID))
					bean.setId(jsonObject.getString(ParserConstant.ID));

				if (!jsonObject.isNull(ParserConstant.START_TIME))
					bean.setStart_time(jsonObject
							.getString(ParserConstant.START_TIME));

				if (!jsonObject.isNull(ParserConstant.AUTO_START_TIMER))
					bean.setAuto_start_timer(jsonObject
							.getString(ParserConstant.AUTO_START_TIMER));
				if (!jsonObject.isNull(ParserConstant.END_TIME))
					bean.setEnd_time(jsonObject
							.getString(ParserConstant.END_TIME));
				if (!jsonObject.isNull(ParserConstant.BILLABLE))
					bean.setBillable(jsonObject
							.getString(ParserConstant.BILLABLE));
				if (!jsonObject.isNull(ParserConstant.DURATION))
					bean.setDuration(jsonObject
							.getString(ParserConstant.DURATION));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return bean;

		} else
			return null;
	}

	public static Object getPoint(String response) {
		MapBean mapBean = new MapBean();
		JSONArray jsonArray = null;
		JSONArray jsonArray2 = null;

		JSONObject jsonObject = null;
		ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
		try {
			jsonObject = new JSONObject(response);
			if (jsonObject.has("today_schedule")) {
				jsonArray = jsonObject.getJSONArray("today_schedule");
				for (int i = 0; i < jsonArray.length(); i++) {
					jsonArray2 = jsonArray.getJSONArray(i);
					if (jsonArray2.length() > 0) {
						Log.v("N", "LAT :: " + jsonArray2.getDouble(0));
						Log.v("N", "LAT :: " + jsonArray2.getDouble(1));
						arrayList.add(new LatLng(jsonArray2.getDouble(0),
								jsonArray2.getDouble(1)));
					}
				}
				mapBean.setLatLngs(arrayList);
			} else if (jsonObject.has("home_address")) {
				JSONArray jsonArray3 = jsonObject.getJSONArray("home_address");

				mapBean.setHome(new LatLng(jsonArray3.getDouble(0), jsonArray3
						.getDouble(1)));
			} else if (jsonObject.has("company_address")) {
				JSONArray jsonArray3 = jsonObject
						.getJSONArray("company_address");
				mapBean.setOffice(new LatLng(jsonArray3.getDouble(0),
						jsonArray3.getDouble(1)));
			}
		} catch (JSONException e1) {

			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		return mapBean;

	}
}

package com.copper.communicator;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.copper.bean.LoginResponseBean;
import com.copper.bean.ResponsBeans;

public class ParserHandler extends ParserHandlerAdapter {
	public static Object doParse(int request, String response) {
		ObjectMapper mapper = new ObjectMapper();
		Object object = null;
		try {

			switch (request) {
			case RequestResponseType.REQUEST_TYPE_LOGIN:
				object = mapper.readValue(response, LoginResponseBean.class);
				break;

			case RequestResponseType.REQUEST_TYPE_FORGOT:
				object = mapper.readValue(response, ResponsBeans.class);
				break;
			case RequestResponseType.REQUEST_TYPE_JOB:
				object = parseJob(response);
				break;
			case RequestResponseType.REQUEST_TYPE_INVENTORIES:
				object = parseInventories(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_INVENTORY:
				object = parseCreateInventories(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CLIENT:
				object = parseClient(response);
				break;

			case RequestResponseType.REQUEST_TYPE_CREATE_CLIENT:
				object = parseCreateClient(response);
				break;

			case RequestResponseType.REQUEST_TYPE_CREATE_PROPERTY:
				object = parseCreateProperty(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_JOB:
				object = parseCreateProperty(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_QUOTE:
				object = parseCreateQuote(response);
				break;
			case RequestResponseType.REQUEST_TYPE_QUOTE:
				object = parseQuote(response);
				break;
			case RequestResponseType.REQUEST_TYPE_PROPERTY:
				object = parseProperty(response);
				break;
			case RequestResponseType.REQUEST_TYPE_EXPANSES:
				object = parseExpanses(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_EXPANSES:

				object = parseCreateExpanses(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_TASK:

				object = parseCreateTask(response);
				break;
			case RequestResponseType.REQUEST_TYPE_TASK:
				object = parseTask(response);
				break;
			case RequestResponseType.REQUEST_TYPE_UPDATE_CLIENT:
				object = parseCreateClient(response);
				break;
			case RequestResponseType.REQUEST_TYPE_UPDATE_TASK:
				object = parseCreateTask(response);
				break;
			case RequestResponseType.REQUEST_TYPE_UPDATE_INVENTORY:
				object = parseCreateInventories(response);
				break;
			case RequestResponseType.REQUEST_TYPE_UPDATE_QUOTE:
				object = parseCreateQuote(response);
				break;
			case RequestResponseType.REQUEST_TYPE_TODAY_TASK:
				object = parseTask(response);
				break;
			case RequestResponseType.REQUEST_TYPE_GET_CLIENT_PROPERTY:
				object = parseProperty(response);
				break;
			case RequestResponseType.REQUEST_TYPE_GET_INVOICE:
				object = parseInvoices(response);
				break;
			case RequestResponseType.REQUEST_TYPE_CREATE_TIMESHEET:
				object = parseTimeCreateSheet(response);
				break;
			case RequestResponseType.REQUEST_TYPE_UPDATE_TIMESHEET:
				object = parseTimeCreateSheet(response);
				break;
			case RequestResponseType.REQUEST_TYPE_TIMESHEET:
				object = parseTimeSheet(response);
				break;

			case RequestResponseType.REQUEST_TYPE_ROUTE:
				object = getPoint(response);
				break;
			default:
				break;
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;

	}
}

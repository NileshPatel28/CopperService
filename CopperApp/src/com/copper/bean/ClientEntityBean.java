package com.copper.bean;

import java.util.ArrayList;

public class ClientEntityBean {
ArrayList<ClientChildBean> clientList=new ArrayList<ClientChildBean>();

public synchronized ArrayList<ClientChildBean> getClientList() {
	return clientList;
}

public synchronized void setClientList(ArrayList<ClientChildBean> clientList) {
	this.clientList = clientList;
}

}

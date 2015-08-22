package com.copper.bean;

import java.util.ArrayList;

public class PropertyParentBean {
	ArrayList<PropertyBean> propertyList = new ArrayList<PropertyBean>();

	public synchronized ArrayList<PropertyBean> getPropertyList() {
		return propertyList;
	}

	public synchronized void setPropertyList(
			ArrayList<PropertyBean> propertyList) {
		this.propertyList = propertyList;
	}

}

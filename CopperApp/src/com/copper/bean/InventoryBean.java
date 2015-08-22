package com.copper.bean;

import java.util.ArrayList;

public class InventoryBean {
	ArrayList<InventoryChildBean> inventoryList = new ArrayList<InventoryChildBean>();

	public synchronized ArrayList<InventoryChildBean> getInventoryList() {
		return inventoryList;
	}

	public synchronized void setInventoryList(
			ArrayList<InventoryChildBean> inventoryList) {
		this.inventoryList = inventoryList;
	}
}

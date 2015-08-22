package com.copper.bean;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

public class MapBean {
	ArrayList<LatLng> latLngs = new ArrayList<LatLng>();
	LatLng home;
	LatLng office;

	public synchronized ArrayList<LatLng> getLatLngs() {
		return latLngs;
	}

	public synchronized void setLatLngs(ArrayList<LatLng> latLngs) {
		this.latLngs = latLngs;
	}

	public synchronized LatLng getHome() {
		return home;
	}

	public synchronized void setHome(LatLng home) {
		this.home = home;
	}

	public synchronized LatLng getOffice() {
		return office;
	}

	public synchronized void setOffice(LatLng office) {
		this.office = office;
	}

}

package com.copper.bean;

import java.io.Serializable;

public class PropertyBean implements Serializable {
	@Override
	public String toString() {
		return "PropertyBean [street=" + street + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", country=" + country
				+ ", client_id=" + client_id + "]";
	}

	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String client_id;
	private String id;

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getStreet() {
		return street;
	}

	public synchronized void setStreet(String street) {
		this.street = street;
	}

	public synchronized String getCity() {
		return city;
	}

	public synchronized void setCity(String city) {
		this.city = city;
	}

	public synchronized String getState() {
		return state;
	}

	public synchronized void setState(String state) {
		this.state = state;
	}

	public synchronized String getZipcode() {
		return zipcode;
	}

	public synchronized void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public synchronized String getCountry() {
		return country;
	}

	public synchronized void setCountry(String country) {
		this.country = country;
	}

	public synchronized String getClient_id() {
		return client_id;
	}

	public synchronized void setClient_id(String client_id) {
		this.client_id = client_id;
	}

}

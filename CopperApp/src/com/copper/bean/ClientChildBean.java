package com.copper.bean;

import java.io.Serializable;

public class ClientChildBean implements Serializable {

	String id = "";
	String initial = "";
	String first_name = "";
	String last_name = "";
	String company_name = "";
	String primary_company = "";
	String street1 = "";
	String street2 = "";
	String city = "";

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getInitial() {
		return initial;
	}

	public synchronized void setInitial(String initial) {
		this.initial = initial;
	}

	public synchronized String getFirst_name() {
		return first_name;
	}

	public synchronized void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public synchronized String getLast_name() {
		return last_name;
	}

	public synchronized void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public synchronized String getCompany_name() {
		return company_name;
	}

	public synchronized void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public synchronized String getPrimary_company() {
		return primary_company;
	}

	public synchronized void setPrimary_company(String primary_company) {
		this.primary_company = primary_company;
	}

	public synchronized String getStreet1() {
		return street1;
	}

	public synchronized void setStreet1(String street1) {
		this.street1 = street1;
	}

	public synchronized String getStreet2() {
		return street2;
	}

	public synchronized void setStreet2(String street2) {
		this.street2 = street2;
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

	public synchronized String getZip_code() {
		return zip_code;
	}

	public synchronized void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public synchronized String getCountry() {
		return country;
	}

	public synchronized void setCountry(String country) {
		this.country = country;
	}

	public synchronized String getPhone_initial() {
		return phone_initial;
	}

	public synchronized void setPhone_initial(String phone_initial) {
		this.phone_initial = phone_initial;
	}

	public synchronized String getPhone_number() {
		return phone_number;
	}

	public synchronized void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public synchronized String getEmail_initial() {
		return email_initial;
	}

	public synchronized void setEmail_initial(String email_initial) {
		this.email_initial = email_initial;
	}

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public synchronized String getCreated_at() {
		return created_at;
	}

	public synchronized void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public synchronized String getUpdated_at() {
		return updated_at;
	}

	public synchronized void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public synchronized String getUser_id() {
		return user_id;
	}

	public synchronized void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public synchronized String getClient_tag() {
		return client_tag;
	}

	public synchronized void setClient_tag(String client_tag) {
		this.client_tag = client_tag;
	}

	public synchronized String getCustom_field() {
		return custom_field;
	}

	public synchronized void setCustom_field(String custom_field) {
		this.custom_field = custom_field;
	}

	public synchronized String getMobile_number() {
		return mobile_number;
	}

	public synchronized void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public synchronized String getPersonal_email() {
		return personal_email;
	}

	public synchronized void setPersonal_email(String personal_email) {
		this.personal_email = personal_email;
	}

	public synchronized String getPreference_notification() {
		return preference_notification;
	}

	public synchronized void setPreference_notification(
			String preference_notification) {
		this.preference_notification = preference_notification;
	}

	String state = "";
	String zip_code = "";
	String country = "";
	String phone_initial = "";
	String phone_number = "";
	String email_initial = "";
	String email = "";
	String created_at = "";
	String updated_at = "";
	String user_id = "";
	String client_tag = "";
	String custom_field = "";
	String mobile_number = "";
	String personal_email = "";
	String preference_notification = "";
}

package com.copper.bean;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobChildBean implements Serializable {
	String id = "";
	String description = "";
	String scheduled = "";
	String start_date = "";
	String end_date = "";
	String visits = "";
	String start_time = "";
	String end_time = "";
	String crew = "";
	String invoicing = "";
	String invoice_period = "";
	String first_invoice_on = "";
	String created_at = "";
	String updated_at = "";
	String property_id = "";
	String job_type = "";
	String number_of_invoice = "";
	String invoice_type = "";
	String user_id = "";
	String job_status = "";
	String job_required = "";
	String job_complete = "";
	String complete_on = "";
	String quote_id = "";
	String custom_field = "";
	String email = "";

	public synchronized String getEmail() {
		return email;
	}

	public synchronized void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getVisits() {
		return visits;
	}

	public void setVisits(String visits) {
		this.visits = visits;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getInvoicing() {
		return invoicing;
	}

	public void setInvoicing(String invoicing) {
		this.invoicing = invoicing;
	}

	public String getInvoice_period() {
		return invoice_period;
	}

	public void setInvoice_period(String invoice_period) {
		this.invoice_period = invoice_period;
	}

	public String getFirst_invoice_on() {
		return first_invoice_on;
	}

	public void setFirst_invoice_on(String first_invoice_on) {
		this.first_invoice_on = first_invoice_on;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getProperty_id() {
		return property_id;
	}

	public void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	public String getJob_type() {
		return job_type;
	}

	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}

	public String getNumber_of_invoice() {
		return number_of_invoice;
	}

	public void setNumber_of_invoice(String number_of_invoice) {
		this.number_of_invoice = number_of_invoice;
	}

	public String getInvoice_type() {
		return invoice_type;
	}

	public void setInvoice_type(String invoice_type) {
		this.invoice_type = invoice_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getJob_status() {
		return job_status;
	}

	public void setJob_status(String job_status) {
		this.job_status = job_status;
	}

	public String getJob_required() {
		return job_required;
	}

	public void setJob_required(String job_required) {
		this.job_required = job_required;
	}

	public String getJob_complete() {
		return job_complete;
	}

	public void setJob_complete(String job_complete) {
		this.job_complete = job_complete;
	}

	public String getComplete_on() {
		return complete_on;
	}

	public void setComplete_on(String complete_on) {
		this.complete_on = complete_on;
	}

	public String getQuote_id() {
		return quote_id;
	}

	public void setQuote_id(String quote_id) {
		this.quote_id = quote_id;
	}

	public String getCustom_field() {
		return custom_field;
	}

	public void setCustom_field(String custom_field) {
		this.custom_field = custom_field;
	}

	public String getJob_order() {
		return job_order;
	}

	public void setJob_order(String job_order) {
		this.job_order = job_order;
	}

	String job_order = "";

}

package com.copper.bean;

import java.io.Serializable;

public class InvoiceBean implements Serializable {
	private String id;
	private String payment;
	private String subject;
	private String issued_date;
	private String tax;
	private String discount_amount;
	private String discount_type;
	private String deposite_amount;
	private String entry_date;
	private String payment_method_type;
	private String payment_method;
	private String additional_note;
	private String client_message;
	private String created_at;
	private String updated_at;
	private String client_id;
	private String due_date;
	private String user_id;
	private String jobs_id;
	private String mark_sent;
	private String invoice_paid;
	private String invoice_bad_debt;
	private String past_due;
	private String custom_field;
	private String is_mailed;
	private String invoice_order;
	private String quote_id;

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getPayment() {
		return payment;
	}

	public synchronized void setPayment(String payment) {
		this.payment = payment;
	}

	public synchronized String getSubject() {
		return subject;
	}

	public synchronized void setSubject(String subject) {
		this.subject = subject;
	}

	public synchronized String getIssued_date() {
		return issued_date;
	}

	public synchronized void setIssued_date(String issued_date) {
		this.issued_date = issued_date;
	}

	public synchronized String getTax() {
		return tax;
	}

	public synchronized void setTax(String tax) {
		this.tax = tax;
	}

	public synchronized String getDiscount_amount() {
		return discount_amount;
	}

	public synchronized void setDiscount_amount(String discount_amount) {
		this.discount_amount = discount_amount;
	}

	public synchronized String getDiscount_type() {
		return discount_type;
	}

	public synchronized void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public synchronized String getDeposite_amount() {
		return deposite_amount;
	}

	public synchronized void setDeposite_amount(String deposite_amount) {
		this.deposite_amount = deposite_amount;
	}

	public synchronized String getEntry_date() {
		return entry_date;
	}

	public synchronized void setEntry_date(String entry_date) {
		this.entry_date = entry_date;
	}

	public synchronized String getPayment_method_type() {
		return payment_method_type;
	}

	public synchronized void setPayment_method_type(String payment_method_type) {
		this.payment_method_type = payment_method_type;
	}

	public synchronized String getPayment_method() {
		return payment_method;
	}

	public synchronized void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public synchronized String getAdditional_note() {
		return additional_note;
	}

	public synchronized void setAdditional_note(String additional_note) {
		this.additional_note = additional_note;
	}

	public synchronized String getClient_message() {
		return client_message;
	}

	public synchronized void setClient_message(String client_message) {
		this.client_message = client_message;
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

	public synchronized String getClient_id() {
		return client_id;
	}

	public synchronized void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public synchronized String getDue_date() {
		return due_date;
	}

	public synchronized void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public synchronized String getUser_id() {
		return user_id;
	}

	public synchronized void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public synchronized String getJobs_id() {
		return jobs_id;
	}

	public synchronized void setJobs_id(String jobs_id) {
		this.jobs_id = jobs_id;
	}

	public synchronized String getMark_sent() {
		return mark_sent;
	}

	public synchronized void setMark_sent(String mark_sent) {
		this.mark_sent = mark_sent;
	}

	public synchronized String getInvoice_paid() {
		return invoice_paid;
	}

	public synchronized void setInvoice_paid(String invoice_paid) {
		this.invoice_paid = invoice_paid;
	}

	public synchronized String getInvoice_bad_debt() {
		return invoice_bad_debt;
	}

	public synchronized void setInvoice_bad_debt(String invoice_bad_debt) {
		this.invoice_bad_debt = invoice_bad_debt;
	}

	public synchronized String getPast_due() {
		return past_due;
	}

	public synchronized void setPast_due(String past_due) {
		this.past_due = past_due;
	}

	public synchronized String getCustom_field() {
		return custom_field;
	}

	public synchronized void setCustom_field(String custom_field) {
		this.custom_field = custom_field;
	}

	public synchronized String getIs_mailed() {
		return is_mailed;
	}

	public synchronized void setIs_mailed(String is_mailed) {
		this.is_mailed = is_mailed;
	}

	public synchronized String getInvoice_order() {
		return invoice_order;
	}

	public synchronized void setInvoice_order(String invoice_order) {
		this.invoice_order = invoice_order;
	}

	public synchronized String getQuote_id() {
		return quote_id;
	}

	public synchronized void setQuote_id(String quote_id) {
		this.quote_id = quote_id;
	}
}

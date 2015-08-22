package com.copper.bean;

import java.io.Serializable;

public class QuoteChildBean implements Serializable {
	private String id;

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getTax() {
		return tax;
	}

	public synchronized void setTax(String tax) {
		this.tax = tax;
	}

	public synchronized String getDiscount() {
		return discount;
	}

	public synchronized void setDiscount(String discount) {
		this.discount = discount;
	}

	public synchronized String getDiscount_type() {
		return discount_type;
	}

	public synchronized void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public synchronized String getRequire_deposit() {
		return require_deposit;
	}

	public synchronized void setRequire_deposit(String require_deposit) {
		this.require_deposit = require_deposit;
	}

	public synchronized String getRequire_deposit_type() {
		return require_deposit_type;
	}

	public synchronized void setRequire_deposit_type(String require_deposit_type) {
		this.require_deposit_type = require_deposit_type;
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

	public synchronized String getProperty_id() {
		return property_id;
	}

	public synchronized void setProperty_id(String property_id) {
		this.property_id = property_id;
	}

	public synchronized String getRaty_score() {
		return raty_score;
	}

	public synchronized void setRaty_score(String raty_score) {
		this.raty_score = raty_score;
	}

	public synchronized String getUser_id() {
		return user_id;
	}

	public synchronized void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public synchronized String getArchive() {
		return archive;
	}

	public synchronized void setArchive(String archive) {
		this.archive = archive;
	}

	public synchronized String getSent() {
		return sent;
	}

	public synchronized void setSent(String sent) {
		this.sent = sent;
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

	public synchronized String getQuote_order() {
		return quote_order;
	}

	public synchronized void setQuote_order(String quote_order) {
		this.quote_order = quote_order;
	}

	private String quantity = "";
	private String unit_cost = "";

	public synchronized String getQuantity() {
		return quantity;
	}

	public synchronized void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public synchronized String getUnit_cost() {
		return unit_cost;
	}

	public synchronized void setUnit_cost(String unit_cost) {
		this.unit_cost = unit_cost;
	}

	private String tax;
	private String discount;
	private String discount_type;
	private String require_deposit;
	private String require_deposit_type;
	private String client_message;
	private String created_at;
	private String updated_at;
	private String property_id;
	private String raty_score;
	private String user_id;
	private String archive;
	private String sent;
	private String custom_field;
	private String is_mailed;
	private String quote_order;
	private String name = "";
	private String description = "";

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}

}

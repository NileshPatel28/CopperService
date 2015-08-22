package com.copper.bean;

import java.io.Serializable;

public class ExpensesChildBean implements Serializable {
	private String id = "";
	private String clean_date = "";
	private String name = "";
	private String note = "";
	private String cost = "";
	private String reimbursable_to_id = "";
	private String job_id = "";
	private String user_id = "";
	private String created_at = "";
	private String updated_at = "";
	private String image_file_name = "";
	private String image_content_type = "";
	private String image_file_size = "";
	private String image_updated_at = "";
	private String pending_payment = "";
	private String exp_category = "";
	private String miles = "";
	private String unit = "";
	private String exp_reimbursable = "";
	private String exp_billable = "";
	private String expense_type = "";

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getClean_date() {
		return clean_date;
	}

	public synchronized void setClean_date(String clean_date) {
		this.clean_date = clean_date;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getNote() {
		return note;
	}

	public synchronized void setNote(String note) {
		this.note = note;
	}

	public synchronized String getCost() {
		return cost;
	}

	public synchronized void setCost(String cost) {
		this.cost = cost;
	}

	public synchronized String getReimbursable_to_id() {
		return reimbursable_to_id;
	}

	public synchronized void setReimbursable_to_id(String reimbursable_to_id) {
		this.reimbursable_to_id = reimbursable_to_id;
	}

	public synchronized String getJob_id() {
		return job_id;
	}

	public synchronized void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public synchronized String getUser_id() {
		return user_id;
	}

	public synchronized void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public synchronized String getImage_file_name() {
		return image_file_name;
	}

	public synchronized void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}

	public synchronized String getImage_content_type() {
		return image_content_type;
	}

	public synchronized void setImage_content_type(String image_content_type) {
		this.image_content_type = image_content_type;
	}

	public synchronized String getImage_file_size() {
		return image_file_size;
	}

	public synchronized void setImage_file_size(String image_file_size) {
		this.image_file_size = image_file_size;
	}

	public synchronized String getImage_updated_at() {
		return image_updated_at;
	}

	public synchronized void setImage_updated_at(String image_updated_at) {
		this.image_updated_at = image_updated_at;
	}

	public synchronized String getPending_payment() {
		return pending_payment;
	}

	public synchronized void setPending_payment(String pending_payment) {
		this.pending_payment = pending_payment;
	}

	public synchronized String getExp_category() {
		return exp_category;
	}

	public synchronized void setExp_category(String exp_category) {
		this.exp_category = exp_category;
	}

	public synchronized String getMiles() {
		return miles;
	}

	public synchronized void setMiles(String miles) {
		this.miles = miles;
	}

	public synchronized String getUnit() {
		return unit;
	}

	public synchronized void setUnit(String unit) {
		this.unit = unit;
	}

	public synchronized String getExp_reimbursable() {
		return exp_reimbursable;
	}

	public synchronized void setExp_reimbursable(String exp_reimbursable) {
		this.exp_reimbursable = exp_reimbursable;
	}

	public synchronized String getExp_billable() {
		return exp_billable;
	}

	public synchronized void setExp_billable(String exp_billable) {
		this.exp_billable = exp_billable;
	}

	public synchronized String getExpense_type() {
		return expense_type;
	}

	public synchronized void setExpense_type(String expense_type) {
		this.expense_type = expense_type;
	}

}

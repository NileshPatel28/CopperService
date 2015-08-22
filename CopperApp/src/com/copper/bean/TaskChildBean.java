package com.copper.bean;

import java.io.Serializable;

public class TaskChildBean implements Serializable {

	String title = "";
	String all_day = "";
	String start_at_date = "";
	String start_at_time = "";
	String end_at_date = "";
	String end_at_time = "";
	String description = "";
	String id = "";
	String is_completed = "";

	public synchronized String getIs_completed() {
		return is_completed;
	}

	public synchronized void setIs_completed(String is_completed) {
		this.is_completed = is_completed;
	}

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getTitle() {
		return title;
	}

	public synchronized void setTitle(String title) {
		this.title = title;
	}

	public synchronized String getAll_day() {
		return all_day;
	}

	public synchronized void setAll_day(String all_day) {
		this.all_day = all_day;
	}

	public synchronized String getStart_at_date() {
		return start_at_date;
	}

	public synchronized void setStart_at_date(String start_at_date) {
		this.start_at_date = start_at_date;
	}

	public synchronized String getStart_at_time() {
		return start_at_time;
	}

	public synchronized void setStart_at_time(String start_at_time) {
		this.start_at_time = start_at_time;
	}

	public synchronized String getEnd_at_date() {
		return end_at_date;
	}

	public synchronized void setEnd_at_date(String end_at_date) {
		this.end_at_date = end_at_date;
	}

	public synchronized String getEnd_at_time() {
		return end_at_time;
	}

	public synchronized void setEnd_at_time(String end_at_time) {
		this.end_at_time = end_at_time;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}
}

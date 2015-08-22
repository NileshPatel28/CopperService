package com.copper.bean;

import java.io.Serializable;

public class TimesheetBean implements Serializable {
	private String auto_start_timer;
	private String note;
	private String start_time;
	private String end_time;
	private String duration;
	private String billable;
	private String id;

	public synchronized String getId() {
		return id;
	}

	public synchronized void setId(String id) {
		this.id = id;
	}

	public synchronized String getAuto_start_timer() {
		return auto_start_timer;
	}

	public synchronized void setAuto_start_timer(String auto_start_timer) {
		this.auto_start_timer = auto_start_timer;
	}

	public synchronized String getNote() {
		return note;
	}

	public synchronized void setNote(String note) {
		this.note = note;
	}

	public synchronized String getStart_time() {
		return start_time;
	}

	public synchronized void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public synchronized String getEnd_time() {
		return end_time;
	}

	public synchronized void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public synchronized String getDuration() {
		return duration;
	}

	public synchronized void setDuration(String duration) {
		this.duration = duration;
	}

	public synchronized String getBillable() {
		return billable;
	}

	public synchronized void setBillable(String billable) {
		this.billable = billable;
	}
}

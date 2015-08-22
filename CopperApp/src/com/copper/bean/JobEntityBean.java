package com.copper.bean;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobEntityBean extends ResponsBeans {
	@JsonProperty("job")
	ArrayList<JobChildBean> job = new ArrayList<JobChildBean>();

	public ArrayList<JobChildBean> getJob() {
		return job;
	}

	public void setJob(ArrayList<JobChildBean> job) {
		this.job = job;
	}

}

package com.copper.bean;

import java.util.ArrayList;

public class QuoteBean {
	ArrayList<QuoteChildBean> quoteList = new ArrayList<QuoteChildBean>();

	public synchronized ArrayList<QuoteChildBean> getQuoteList() {
		return quoteList;
	}

	public synchronized void setQuoteList(ArrayList<QuoteChildBean> quoteList) {
		this.quoteList = quoteList;
	}
}

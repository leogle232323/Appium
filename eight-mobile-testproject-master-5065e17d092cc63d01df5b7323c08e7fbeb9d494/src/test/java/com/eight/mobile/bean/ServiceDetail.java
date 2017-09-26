package com.eight.mobile.bean;

import java.io.Serializable;

public class ServiceDetail implements Serializable{
	public int errCode;
	public String errMsg;
	public Data data;
	public class Data implements Serializable{
		String title;
		int showAmount;
		int amount;
		String unit;
		String sales;
		String storeNum;
		String comprehensiveScore;
	}
}

package com.eight.mobile.bean;

import java.io.Serializable;
import java.util.List;

public class ServiceList implements Serializable {
	public String errCode;
	public String errMsg;
	public Data data;
	public class Data implements Serializable {
		public List<ServiceItem> listService;
		public List<LocalServiceItem> localListService;
		public String listShop;
	}
}

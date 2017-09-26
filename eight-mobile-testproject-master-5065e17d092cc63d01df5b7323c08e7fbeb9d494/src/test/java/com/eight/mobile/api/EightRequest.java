package com.eight.mobile.api;

import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;

import com.eight.mobile.bean.BueryLogin;
import com.eight.mobile.bean.LocalServiceItem;
import com.eight.mobile.bean.ServiceItem;
import com.eight.mobile.bean.ServiceList;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class EightRequest {
	public static int loginErrCode;
	public static String url;
	public static BueryLogin login;
	public static OkHttpClient okHttpClient;
	public static String fullUrl;

	public static ServiceList serviceList;
	public static List<ServiceItem> listServiceItem;
	public static List<LocalServiceItem> listLocalServiceItem;
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static boolean getLoginStatus() throws InterruptedException {
		getLoginStatus(loginCallback);
		verfiyBack(loginErrCode);
		if(loginErrCode==0){
			return true;
		}
		return false;
	}

	public static List<ServiceItem> getServiceItem() throws InterruptedException {
		getServiceList(searchServiceListCallBack);
		verfiyBack(listServiceItem);
		return listServiceItem;
	}
	public static List<LocalServiceItem> getLocalServiceItem() throws InterruptedException {
		getServiceList(searchServiceListCallBack);
		verfiyBack(listLocalServiceItem);
		return listLocalServiceItem;
	}
	public static void getLoginStatus(Callback callback) {
		okHttpClient = OkHttp.getInstance();
		url = creatServiceListUrl(Config.T4HOST, Config.LOGINAPI);
		JSONObject para = new JSONObject();
		para.put("jpcode", Config.jpcode);
		para.put("dk", Config.dk);
		RequestBody body = RequestBody.create(JSON, para.toJSONString());
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(callback);
	}

	public static void getServiceList(Callback callback) {
		okHttpClient = OkHttp.getInstance();
		url = creatServiceListUrl(Config.T4HOST, Config.SERVICELISTAPI);
		JSONObject para = new JSONObject();
		para.put("aptitudeType", 0);
		para.put("cityId", 0);
		para.put("cityfilter", "");
		para.put("dk",Config.dk);
		para.put("keyword", "Logo设计");
		para.put("page", 0);
		para.put("provincefilter", "");
		para.put("sType", 2);
		para.put("size", 10);
		para.put("sortType", 1);
		para.put("token",Config.token);
		RequestBody body = RequestBody.create(JSON, para.toJSONString());
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(callback);
	}
	
	private static String creatServiceListUrl(String host, String api) {
		url = host + api;
		return url;
	}

	public static Callback loginCallback = new Callback() {

		@Override
		public void onFailure(Request request, IOException e) {
			loginErrCode = login.errCode;
		}

		@Override
		public void onResponse(Response response) throws IOException {
			if (response.isSuccessful()) {
				System.out.println("返回成功");
			} else {
				System.out.println("返回失败");
			}
			Gson gson = new Gson();
			login = gson.fromJson(response.body().string(), BueryLogin.class);
			loginErrCode = login.errCode;
		}
	};
	public static Callback searchServiceListCallBack = new Callback() {

		@Override
		public void onFailure(Request request, IOException e) {

		}

		@Override
		public void onResponse(Response response) throws IOException {
			Gson gson = new Gson();
			serviceList = gson.fromJson(response.body().string(), ServiceList.class);
			System.out.println("------------------------"+response.body().string());
			if (response.isSuccessful()) {
				System.out.println("返回成功");
			} else {
				System.out.println("返回失败");
			}
			ServiceList.Data data = serviceList.data;
			listServiceItem = data.listService;
			listLocalServiceItem = data.localListService;
			if(listLocalServiceItem.size()==0){
				Config.serviceId = listServiceItem.get(0).serviceId;
			}else{
				Config.serviceId = listLocalServiceItem.get(0).serviceId;
			}
		}
	};
	public static void verfiyBack(Object obj) throws InterruptedException{
		for (int i = 0; i < 10; i++) {
			if(obj == null){
				Thread.sleep(1000);
			}else{
				break;
			}
		}
	}
}

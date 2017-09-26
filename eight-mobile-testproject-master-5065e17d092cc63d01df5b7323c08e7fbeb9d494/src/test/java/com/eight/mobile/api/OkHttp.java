package com.eight.mobile.api;

import com.squareup.okhttp.OkHttpClient;

public class OkHttp {
	static OkHttpClient okHttpClient = null;
	static OkHttpClient getInstance(){
		if(okHttpClient == null){
			okHttpClient = new OkHttpClient();
		}
		return okHttpClient;
	}
}

package com.eight.mobile.api;

import java.io.IOException;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Contents {
	public static Contents contents = null;
	private Contents(){	
	};
	public Contents getInstance(){
		if(contents == null){
			contents = new Contents();
		}
		return contents;
	}
}

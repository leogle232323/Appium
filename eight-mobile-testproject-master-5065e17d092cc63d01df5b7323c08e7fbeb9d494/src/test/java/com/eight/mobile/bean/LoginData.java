package com.eight.mobile.bean;

import java.io.Serializable;

public class LoginData implements Serializable {
	public String token;
	public int userId;
	public String userKey;
	public String mobile;
	public String secureLoginSessionId;
	public boolean onSecurity;
}

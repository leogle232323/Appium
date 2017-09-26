package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;

public interface LoginPage extends Page {
		
		public boolean inputName(String name);

		public boolean inputPassword(String password);

		public boolean clickLogin(PageContext context);
}

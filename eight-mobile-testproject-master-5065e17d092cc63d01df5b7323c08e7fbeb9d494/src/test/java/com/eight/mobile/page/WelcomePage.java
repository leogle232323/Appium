package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;

public interface WelcomePage extends Page {

	/**
	 * 跳过欢迎页面
	 * @param context
	 */
	boolean skipWelcomePage(PageContext context);
}

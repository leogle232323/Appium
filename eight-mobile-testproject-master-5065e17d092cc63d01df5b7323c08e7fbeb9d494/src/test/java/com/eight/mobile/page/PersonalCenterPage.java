package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;

public interface PersonalCenterPage extends Page {
	/**
	 * 进入登陆界面
	 * @param context
	 * @return
	 */
	boolean enterLoginPage(PageContext context);
	/**
	 * 进入我的订单页
	 * @param context
	 * @return
	 */
	boolean enterMyOrderPage(PageContext context);
	boolean isLogin(PageContext context);
	boolean personalCenterGoback(PageContext context);
	/**
	 * 进入设置界面
	 * @param context
	 * @return
	 */
	boolean enterSettingPage(PageContext context);
	/**
	 * 进入关于界面
	 * @param context
	 * @return
	 */
	boolean enterAboutPage(PageContext context);
	/**
	 * 进入环境切换界面
	 * @param context
	 * @return
	 */
	boolean enterEnvironmentSwitch(PageContext context);
	/**
	 * 切换环境
	 * @param context
	 * @param environment 
	 * @return
	 */
	boolean switchEnvironment(PageContext context, int environment);
	
}

package com.eight.mobile.test;

import java.io.IOException;

import com.eight.mobile.setting.Configurator;
import org.testng.annotations.Test;

import com.eight.mobile.api.Config;
import com.eight.mobile.api.EightRequest;
import com.eight.mobile.base.PageContext;
import com.eight.mobile.utils.UiObject;

import junit.framework.Assert;
/**
 * 登录
 * @author houshuo
 *
 */
public class TestLogin extends TestCaseBase {
	@Test
	public void testLogin() throws IOException, InterruptedException{	
		
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterPersonalCenter(context);
		context.enterLoginPage(context);
		context.inputName("13622550003");
		context.inputPassword("123456");
		context.clickLogin(context);
		boolean isLogined = context.isLogin(context);	
		boolean remoteLogined = EightRequest.getLoginStatus();
		Assert.assertEquals("登录失败", isLogined, remoteLogined);
		context.personalCenterGoback(context);

	}
}

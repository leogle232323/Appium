package com.eight.mobile.test;

import org.testng.annotations.Test;

import com.eight.mobile.base.PageContext;

/**
 * 联系服务商
 * 
 * @author houshuo
 *
 */
public class TestContactServiceProvider extends TestCaseBase {
	@Test
	public void testContactServiceProvider() {
		PageContext context = new PageContext();
		context.enterSearchPage(context);
		context.inputSearchContext(context, "lxy");
		context.enterServiceDetail(context);
		context.enterShop(context);
		context.goHomePage(context);
	}
}

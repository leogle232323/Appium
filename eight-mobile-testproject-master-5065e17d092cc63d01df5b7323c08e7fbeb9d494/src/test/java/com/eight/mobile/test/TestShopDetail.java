package com.eight.mobile.test;

import org.testng.annotations.Test;

import com.eight.mobile.base.PageContext;
/**
 * 搜索店铺详情
 * @author houshuo
 *
 */
public class TestShopDetail extends TestCaseBase {
	@Test
	public void testShopDetail(){
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterSearchPage(context);
		context.inputSearchContext(context,"lxy");
		context.goHomePage(context);
	}
}

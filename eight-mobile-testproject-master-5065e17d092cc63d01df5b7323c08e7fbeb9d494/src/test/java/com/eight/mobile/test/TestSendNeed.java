package com.eight.mobile.test;

import org.testng.annotations.Test;

import com.eight.mobile.base.PageContext;
/**
 * 发送需求
 * @author houshuo
 *
 */
public class TestSendNeed extends TestCaseBase {
	@Test
	public void testSendNeed(){
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterNeedPage(context);
		context.inputNeedContent(context,"我需要网站建设");
		context.selectNeedItem("网站开发");
		context.inputBudget("2000");
		context.sendNeed(context);
		context.goHomePage(context);
		context.goNeedPageBack(context);
	}
}

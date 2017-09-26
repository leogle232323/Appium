package com.eight.mobile.test;

import org.testng.annotations.Test;

import com.eight.mobile.base.PageContext;

import junit.framework.Assert;

public class TestDynamicDetail extends TestCaseBase {
	@Test
	public void testDynamicDetail(){
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterCommunity(context);
		context.switchCircle(context);
		context.enterTopic(context);
		context.sendTopic(context, "我是一匹来自北方的狼","我是网店主");
		context.goHomePage(context);
		context.enterIMShopkeeper(context);
		String topicContent = context.getTopicText(context);
		Assert.assertEquals("#我是网店主#我是一匹来自北方的狼", topicContent);
	}
}

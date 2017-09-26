package com.eight.mobile.test;

import org.testng.annotations.Test;

import com.eight.mobile.base.PageContext;
/**
 * 搜索服务详情
 * @author houshuo
 *
 */
public class TestSearchServiceDetail extends TestCaseBase {
	@Test
	public void testSearchServiceDetail(){
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterSearchPage(context);
		context.inputSearchContext(context,"Logo设计");
		context.enterServiceDetail(context);
		String serviceDetailTitle = context.getServiceDetailTitle(context);
		String serviceDetailPrice = context.getServiceDetailPrice(context);
		String serviceDetailSales = context.getServiceDetailSales(context);
		String serviceDetailScore = context.getServiceDetailScore(context);
		String serviceDetailSave = context.getServiceDetailSave(context);
		String serviceDetailEvaluate = context.getServiceDetailEvaluate(context);
		String serviceDetailShopName = context.getServiceDetailShopName(context);
		String serviceDetailServiceRange = context.getServiceDetailRange(context);
		String serviceDetailCollection = context.getServiceDetailCollection(context);
		context.switchDetail(context);
		context.switchEvaluate(context);
		context.goHomePage(context);
	}
}

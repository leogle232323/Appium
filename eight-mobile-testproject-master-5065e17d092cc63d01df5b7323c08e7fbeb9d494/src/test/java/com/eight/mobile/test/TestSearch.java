package com.eight.mobile.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eight.mobile.api.EightRequest;
import com.eight.mobile.base.PageContext;
import com.eight.mobile.bean.LocalServiceItem;
import com.eight.mobile.bean.ServiceItem;
import com.eight.mobile.utils.UiObject;
import com.eight.mobile.utils.Utils;

/**
 * 搜索服务列表及商家列表
 * 
 * @author houshuo
 *
 */
public class TestSearch extends TestCaseBase {
	@Test
	public void testSearch() throws InterruptedException {
		PageContext context = new PageContext();
		context.goHomePage(context);
		context.enterSearchPage(context);
		context.inputSearchContext(context, "Logo设计");
		Thread.sleep(5000);
		List<WebElement> listTitle = context.getServiceListTitle();
		List<WebElement> listPrice = context.getServiceListPrice();
		List<WebElement> listCity = context.getServiceListCity();
		List<WebElement> listSales = context.getServiceListSales();
		List<WebElement> listSave = context.getServiceListSave();
		verify(listTitle,listPrice,listCity,listSales,listSave);
		context.enterShopList(context);
		context.goHomePage(context);
	}
	
	private void verify(List<WebElement> listTitle,List<WebElement> listPrice,List<WebElement> listCity,List<WebElement> listSales,List<WebElement> listSave) throws InterruptedException {
		List<LocalServiceItem> listLocalServiceItem = EightRequest.getLocalServiceItem();
		List<ServiceItem> listServiceItem = EightRequest.getServiceItem();
		if (listLocalServiceItem.size() == 0) {
			for (int i = 0; i < listPrice.size(); i++) {
				if (listServiceItem.get(i).platform == 0 ||listServiceItem.get(i).platform == 1) {
					Assert.assertEquals(listTitle.get(i).getText(), listServiceItem.get(i).subject, "第" + i + "个title不一致");
				} else {
					Assert.assertEquals(listTitle.get(i).getText(), "[天蓬网] " + listServiceItem.get(i).subject,
							"第" + i + "个title不一致");
				}
				if(listServiceItem.get(i).appAmount==0.0) {
					Assert.assertEquals(listPrice.get(i).getText(), "¥" + listServiceItem.get(i).amount + "/" + listServiceItem.get(i).unit, "第" + i + "价格不一致");
				}else {
					Assert.assertEquals(listPrice.get(i).getText(), "¥" + listServiceItem.get(i).appAmount + "/" + listServiceItem.get(i).unit, "第" + i + "价格不一致");
				}
					Assert.assertEquals(listCity.get(i).getText(), listServiceItem.get(i).cityName,"第"+i+"条，城市不一致");
				Assert.assertEquals(listSales.get(i).getText(), "成交"+listServiceItem.get(i).sales+"笔","第"+i+"条，成交不一致");
				float a=listServiceItem.get(i).amount;
				float b=listServiceItem.get(i).appAmount;
				float c= a-b;
				String newc = Utils.formate(c);
// 				Assert.assertEquals(listSave.get(i).getText(),"省"+newc,"第"+i+"条节省不一致");
				System.out.println(listPrice.get(i).getText());
				System.out.println("¥"+listServiceItem.get(i).appAmount+"/"+listServiceItem.get(i).unit);
				System.out.println(listCity.get(i).getText());
				System.out.println(listServiceItem.get(i).cityName);
				System.out.println(listSales.get(i).getText());
				System.out.println("成交"+listServiceItem.get(i).sales+"笔");

			}
		} else {
			if (listLocalServiceItem.size() >= listPrice.size()) {
				for (int i = 0; i < listPrice.size(); i++) {
					Assert.assertEquals(listTitle.get(i).getText(), listLocalServiceItem.get(i).subject,
							"第" + i + "个title不一致");
					Assert.assertEquals(listPrice.get(i).getText(), "¥"+listServiceItem.get(i).appAmount+"/"+listServiceItem.get(i).unit);
					Assert.assertEquals(listCity.get(i).getText(), listServiceItem.get(i).cityName);
					Assert.assertEquals(listSales.get(i).getText(), "成交"+listServiceItem.get(i).sales+"笔");
					float a=listServiceItem.get(i).amount;
					float b=listServiceItem.get(i).appAmount;
					float c= a-b;
					String newc = Utils.formate(c);
					Assert.assertEquals(listSave.get(i).getText(),"省"+newc,"第"+i+"条节省不一致");
					System.out.println(listCity.get(i).getText());
					System.out.println(listServiceItem.get(i).cityName);
					System.out.println(listSales.get(i).getText());
					System.out.println("成交"+listServiceItem.get(i).sales+"笔");
				}
			} else {
				System.out.println("listLocalServiceItem.size() < list.size()");
				for (int i = 0; i < listPrice.size(); i++) {
					if (i <= listLocalServiceItem.size() - 1) {
						Assert.assertEquals(listTitle.get(i).getText(), listLocalServiceItem.get(i).subject,
								"第" + (i + 1) + "个title不一致");
						Assert.assertEquals(listPrice.get(i).getText(), "¥"+listLocalServiceItem.get(i).appAmount+"/"+listServiceItem.get(i).unit);
						Assert.assertEquals(listCity.get(i).getText(), listLocalServiceItem.get(i).cityName);
						Assert.assertEquals(listSales.get(i).getText(), "成交"+listLocalServiceItem.get(i).sales+"笔");
						float a=listLocalServiceItem.get(i).amount;
						float b=listLocalServiceItem.get(i).appAmount;
						float c= a-b;
						String newc = Utils.formate(c);
						Assert.assertEquals(listSave.get(i).getText(),"省"+newc,"第"+i+"条节省不一致");
					} else {
						int j = listLocalServiceItem.size();
						Assert.assertEquals(listTitle.get(i).getText(), listServiceItem.get(i - j).subject,
								"第" + i + "个title不一致");
						Assert.assertEquals(listPrice.get(i).getText(), "¥"+listServiceItem.get(i-j).appAmount+"/"+listServiceItem.get(i-j).unit);
						Assert.assertEquals(listCity.get(i).getText(), listServiceItem.get(i-j).cityName);
						Assert.assertEquals(listSales.get(i).getText(), "成交"+listServiceItem.get(i-j).sales+"笔");
						
					}
				}
			}
		}
	}
}

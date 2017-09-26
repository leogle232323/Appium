package com.eight.mobile.page.ad;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.SearchServiceListPage;
import com.eight.mobile.utils.UiObject;

public class AdSearchServiceListPage implements SearchServiceListPage {
	
	private static By SHOP = By.id("com.zhubajie.client:id/shop_title_text_view");
	private static By BACK = By.id("com.zhubajie.client:id/back");
	private static By TEXT = By.id("com.zhubajie.client:id/server_title");
	private static By DETAIL = By.id("com.zhubajie.client:id/tv_tab_title");
	private static By EVALUATION = By.id("com.zhubajie.client:id/tv_tab_title");
	private static By SWITCH = By.id("com.zhubajie.client:id/shop_choose_spinner");
	private static By GOSHOP = By.id("com.zhubajie.client:id/service_goshop");
	//服务详情页title
	private static By SERVICETITLE = By.id("com.zhubajie.client:id/service_title");
	//服务详情页价格
	private static By SERVICEPRICE = By.id("com.zhubajie.client:id/service_price");
	//服务详情页销量
	private static By SERVICESALES = By.id("com.zhubajie.client:id/service_sales_volume");
	//服务详情页收藏
	private static By SERVICECOLLECTION = By.id("com.zhubajie.client:id/service_marked_nums");
	//服务详情页综合评分
	private static By SERVICESCORCE = By.id("com.zhubajie.client:id/service_score");
	//服务详情页节省价格
	private static By SERVICESAVE = By.id("com.zhubajie.client:id/service_price_save");
	//服务详情页评价
	private static By SERVICEEVALUE = By.id("com.zhubajie.client:id/service_evaluated_num");
	//店名
	private static By SERVICESHOPNAME = By.id("com.zhubajie.client:id/shop_name");
	//服务范围
	private static By SERVICESERVICERANGE = By.id("com.zhubajie.client:id/service_aoe");
	public List<WebElement> list ;
	public String str;
	@Override
	public boolean enterShopList(PageContext context) {
		UiObject.waitFor(SHOP).click();
		return true;
	}

	@Override
	public boolean goHomePage(PageContext context) {
		UiObject.waitFor(BACK).click();
		return true;
	}

	@Override
	public boolean enterServiceDetail(PageContext context) {
		UiObject.waitFor(TEXT).click();
		return true;
	}

	@Override
	public boolean switchDetail(PageContext context) {
		UiObject.getAppiumDriver().findElementByName("详情").click();;
		return true;
	}

	@Override
	public boolean switchEvaluate(PageContext context) {
		UiObject.getAppiumDriver().findElementByName("评价").click();;
		return true;
	}

	@Override
	public boolean switchSearchItem(PageContext context, String string) {
		if(string.equals("店铺")){
			UiObject.waitFor(SWITCH).click();
			UiObject.getAppiumDriver().findElementByName(string).click();
		}
		return false;
	}

	@Override
	public boolean enterShop(PageContext context) {
		UiObject.waitFor(GOSHOP).click();
		return true;
	}

	@Override
	public List<WebElement> getServiceListTitle() {
		list = UiObject.getAppiumDriver().findElements(By.id("com.zhubajie.client:id/server_title"));		
		return list;
	}

	@Override
	public List<WebElement> getServiceListPrice() {
		list = UiObject.getAppiumDriver().findElements(By.id("com.zhubajie.client:id/server_price"));
		return list;
	}

	@Override
	public List<WebElement> getServiceListCity() {
		list = UiObject.getAppiumDriver().findElements(By.id("com.zhubajie.client:id/shop_city_name"));
		return list;
	}

	@Override
	public List<WebElement> getServiceListSales() {
		list = UiObject.getAppiumDriver().findElements(By.id("com.zhubajie.client:id/shop_all_service_order_number_text_view"));
		return list;
	}

	@Override
	public List<WebElement> getServiceListSave() {
		list = UiObject.getAppiumDriver().findElements(By.id("com.zhubajie.client:id/server_special_price_for_phone"));
		return list;
	}

	@Override
	public String getServiceDetailTitle(PageContext context) {
		str = UiObject.waitFor(SERVICETITLE).getText();
		return str;
	}

	@Override
	public String getServiceDetailPrice(PageContext context) {
		str = UiObject.waitFor(SERVICEPRICE).getText();
		return str;
	}

	@Override
	public String getServiceDetailSales(PageContext context) {
		str = UiObject.waitFor(SERVICESALES).getText();
		return str;
	}

	@Override
	public String getServiceDetailCollection(PageContext context) {
		str = UiObject.waitFor(SERVICECOLLECTION).getText();
		return str;
	}

	@Override
	public String getServiceDetailScore(PageContext context) {
		str = UiObject.waitFor(SERVICESCORCE).getText();
		return str;
	}

	@Override
	public String getServiceDetailSave(PageContext context) {
		str = UiObject.waitFor(SERVICESAVE).getText();
		return str;
	}

	@Override
	public String getServiceDetailEvaluate(PageContext context) {
		str = UiObject.waitFor(SERVICEEVALUE).getText();
		return str;
	}

	@Override
	public String getServiceDetailShopName(PageContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServiceDetailRange(PageContext context) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

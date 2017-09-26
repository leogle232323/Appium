package com.eight.mobile.base;

import java.util.List;

import com.eight.mobile.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.eight.mobile.bean.ServiceItem;
import com.eight.mobile.factory.AbstractFactory;
import com.eight.mobile.page.CirclePage;
import com.eight.mobile.page.HomePage;
import com.eight.mobile.page.LoginPage;
import com.eight.mobile.page.NeedPage;
import com.eight.mobile.page.PersonalCenterPage;
import com.eight.mobile.page.SearchServiceListPage;
import com.eight.mobile.page.UnknowPage;
import com.eight.mobile.page.WelcomePage;
import com.eight.mobile.setting.Configurator;
import com.eight.mobile.utils.UiObject;

public class PageContext implements HomePage, WelcomePage, UnknowPage {
	private static By BACK = By.id("com.zhubajie.client:id/back");
	private static By FIRSTPAGE = By.id("com.zhubajie.client:id/menu_layout_1");
	public static Page currentPage;
	public AbstractFactory factory;

	public PageContext() {
		factory = Configurator.instance().getFactory();
		currentPage = factory.createPage(WelcomePage.class);
	}

	public boolean skipWelcomePage(PageContext context) {
		currentPage = factory.createPage(WelcomePage.class);
		((WelcomePage) currentPage).skipWelcomePage(context);
		return true;
	}

	public void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean goBack(PageContext context) {

		return true;
	}

	public boolean goHomePage(PageContext context) {
		for (int i = 0; i < 5; i++) {
			if(!UiObject.searchFor(FIRSTPAGE)){
				Utils.goBack();
			}
		}
		UiObject.waitFor(FIRSTPAGE).click();
		return true;
	}

	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean enterCommunity(PageContext context) {
		currentPage = factory.createPage(HomePage.class);
		((HomePage) currentPage).enterCommunity(context);
		return true;
	}

	public boolean enterMessage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean enterPersonalCenter(PageContext context) {
		currentPage = factory.createPage(HomePage.class);
		((HomePage) currentPage).enterPersonalCenter(context);
		return true;
	}

	public boolean inputPassword(String password) {
		currentPage = factory.createPage(LoginPage.class);
		((LoginPage) currentPage).inputPassword(password);
		return true;
	}

	public boolean inputName(String name) {
		currentPage = factory.createPage(LoginPage.class);
		((LoginPage) currentPage).inputName(name);
		return true;
	}

	public boolean enterLoginPage(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).enterLoginPage(context);
		return true;
	}

	public boolean enterMyOrderPage(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).enterMyOrderPage(context);
		return true;
	}

	public boolean clickLogin(PageContext context) {
		currentPage = factory.createPage(LoginPage.class);
		((LoginPage) currentPage).clickLogin(context);
		return true;
	}

	public boolean isLogin(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).isLogin(context);
		return true;
	}

	public boolean personalCenterGoback(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).personalCenterGoback(context);
		return true;
	}

	public boolean enterSearchPage(PageContext context) {
		currentPage = factory.createPage(HomePage.class);
		((HomePage) currentPage).enterSearchPage(context);
		return true;
	}

	public boolean inputSearchContext(PageContext context, String str) {
		currentPage = factory.createPage(HomePage.class);
		((HomePage) currentPage).inputSearchContext(context, str);
		return true;
	}

	@Override
	public boolean inputSearchContext(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean enterShopList(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).enterShopList(context);
		return true;
	}

	public boolean enterServiceDetail(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).enterServiceDetail(context);
		return true;
	}

	public boolean switchDetail(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).switchDetail(context);
		return true;
	}

	public boolean switchEvaluate(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).switchEvaluate(context);
		return true;
	}

	public boolean enterNeedPage(PageContext context) {
		currentPage = factory.createPage(HomePage.class);
		((HomePage) currentPage).enterNeedPage(context);
		return true;
	}

	public boolean inputNeedContent(PageContext context, String str) {
		currentPage = factory.createPage(NeedPage.class);
		((NeedPage) currentPage).inputNeedContent(context, str);
		return true;
	}

	public boolean selectNeedItem(String string) {
		currentPage = factory.createPage(NeedPage.class);
		((NeedPage) currentPage).selectNeedItem(string);
		return true;
	}

	public boolean inputBudget(String string) {
		currentPage = factory.createPage(NeedPage.class);
		((NeedPage) currentPage).inputBudget(string);
		return true;
	}

	public boolean sendNeed(PageContext context) {
		currentPage = factory.createPage(NeedPage.class);
		((NeedPage) currentPage).sendNeed(context);
		return true;
	}

	public boolean goNeedPageBack(PageContext context) {
		currentPage = factory.createPage(NeedPage.class);
		((NeedPage) currentPage).goNeedPageBack(context);
		return true;
	}

	public boolean switchSearchItem(PageContext context, String string) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).switchSearchItem(context, string);
		return true;

	}

	public boolean enterShop(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		((SearchServiceListPage) currentPage).enterShop(context);
		return true;
	}

	public boolean switchCircle(PageContext context) {
		currentPage = factory.createPage(CirclePage.class);
		((CirclePage) currentPage).switchCircle(context);
		return true;
	}

	public boolean enterTopic(PageContext context) {
		currentPage = factory.createPage(CirclePage.class);
		((CirclePage) currentPage).enterTopic(context);
		return true;
	}

	public boolean sendTopic(PageContext context, String topicContent, String topicItem) {
		currentPage = factory.createPage(CirclePage.class);
		((CirclePage) currentPage).sendTopic(context, topicContent, topicItem);
		return true;
	}

	public boolean enterIMShopkeeper(PageContext context) {
		currentPage = factory.createPage(CirclePage.class);
		((CirclePage) currentPage).enterIMShopkeeper(context);
		return true;
	}

	public String getTopicText(PageContext context) {
		currentPage = factory.createPage(CirclePage.class);
		return ((CirclePage) currentPage).getTopicText(context);
	}

	public List getServiceListTitle() {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceListTitle();
	}

	public boolean enterSettingPage(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).enterSettingPage(context);
		return true;
	}

	public boolean enterAboutPage(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).enterAboutPage(context);
		return true;
	}

	public boolean enterEnvironmentSwitch(PageContext context) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).enterEnvironmentSwitch(context);
		return true;	
	}

	public  boolean switchEnvironment(PageContext context,int environment) {
		currentPage = factory.createPage(PersonalCenterPage.class);
		((PersonalCenterPage) currentPage).switchEnvironment(context,environment);
		return true;		
	}

	public  List<WebElement> getServiceListPrice() {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceListPrice();
	}

	public List<WebElement> getServiceListCity() {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceListCity();
	}

	public List<WebElement> getServiceListSales() {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceListSales();
	}

	public List<WebElement> getServiceListSave() {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceListSave();
	}

	public String getServiceDetailTitle(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailTitle(context);
		
	}

	public String getServiceDetailPrice(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailPrice(context);
	}

	public String getServiceDetailSales(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailSales(context);
	}

	public String getServiceDetailCollection(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailCollection(context);
	}

	public String getServiceDetailScore(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailScore(context);
	}

	public String getServiceDetailSave(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailSave(context);
	}

	public String getServiceDetailEvaluate(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailEvaluate(context);
	}

	public String getServiceDetailShopName(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailShopName(context);
	}

	public String getServiceDetailRange(PageContext context) {
		currentPage = factory.createPage(SearchServiceListPage.class);
		return ((SearchServiceListPage) currentPage).getServiceDetailRange(context);
	}

}
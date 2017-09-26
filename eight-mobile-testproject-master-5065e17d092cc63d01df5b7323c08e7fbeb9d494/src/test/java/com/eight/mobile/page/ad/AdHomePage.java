package com.eight.mobile.page.ad;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.HomePage;
import com.eight.mobile.utils.UiObject;

/**
 * 首页
 * 
 * @author crest
 *
 */
public class AdHomePage implements HomePage {

	private static By BANNER = By.id("com.fengjr.mobile:id/carousel");
	private static By COMMUNITY = By.id("com.zhubajie.client:id/menu_layout_2");
	private static By PERSONALCENTER = By.id("com.zhubajie.client:id/menu_layout_5");
	private static By SEARCH = By.id("com.zhubajie.client:id/view_index_head_search");
	private static By SEARCHCONTEXT = By.id("com.zhubajie.client:id/search_et");
	private static By STARTSEARCH = By.id("com.zhubajie.client:id/search");
	private static By SENDNEED = By.id("com.zhubajie.client:id/view_index_head_pub");
	private static boolean isFind ;
	public AdHomePage() {

	}

	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean goBack(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean enterCommunity(PageContext context) {
		UiObject.waitFor(COMMUNITY).click();
		return true;
	}

	public boolean enterMessage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean enterPersonalCenter(PageContext context) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UiObject.waitFor(PERSONALCENTER).click();
		return true;
	}

	@Override
	public boolean enterSearchPage(PageContext context) {
		UiObject.waitFor(SEARCH).click();
		return true;
	}

	@Override
	public boolean inputSearchContext(PageContext context) {
		UiObject.waitFor(SEARCHCONTEXT).sendKeys("shangbiao");
		return true;
	}

	@Override
	public boolean inputSearchContext(PageContext context, String str) {
		UiObject.waitFor(SEARCHCONTEXT).sendKeys(str);
		UiObject.waitFor(STARTSEARCH).click();
		return true;
	}

	@Override
	public boolean enterNeedPage(PageContext context) {
		UiObject.waitFor(SENDNEED).click();
		return true;
	}

}

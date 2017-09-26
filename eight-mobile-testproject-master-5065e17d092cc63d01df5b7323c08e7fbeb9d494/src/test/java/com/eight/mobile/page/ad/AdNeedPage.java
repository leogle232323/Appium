package com.eight.mobile.page.ad;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.NeedPage;
import com.eight.mobile.utils.UiObject;

public class AdNeedPage implements NeedPage {
	private static By CONTENT = By.id("com.zhubajie.client:id/description_require_edit_text");
	private static By ITEM = By.id("com.zhubajie.client:id/demand_edit");
	private static By BUDGET = By.id("com.zhubajie.client:id/remand_total");
	private static By SUMMIT = By.id("com.zhubajie.client:id/demand_summit");
	private static By BACK = By.id("com.zhubajie.client:id/title_left_image_view");
	@Override
	public boolean inputNeedContent(PageContext context, String str) {
		UiObject.waitFor(CONTENT).sendKeys(str);
		return true;
	}

	@Override
	public boolean selectNeedItem(String string) {
		UiObject.waitFor(ITEM).click();
		UiObject.getAppiumDriver().findElementByName(string).click();;
		return true;
	}

	@Override
	public boolean inputBudget(String str) {
		UiObject.waitFor(BUDGET).sendKeys(str);
		return true;
	}

	@Override
	public boolean sendNeed(PageContext context) {
		UiObject.waitFor(SUMMIT).click();
		return true;
	}

	@Override
	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean goNeedPageBack(PageContext context) {
		UiObject.waitFor(BACK).click();
		return true;
	}

}

package com.eight.mobile.page.ad;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.LoginPage;
import com.eight.mobile.utils.UiObject;

public class AdLoginPage implements LoginPage {
	private static By LOGINNAME = By.id("com.zhubajie.client:id/username_et");
	private static By PASSWORD = By.id("com.zhubajie.client:id/password_et");
	private static By LOGIN = By.id("com.zhubajie.client:id/login_bt");


	@Override
	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inputName(String name) {
		UiObject.waitFor(LOGINNAME).clear();
		UiObject.waitFor(LOGINNAME).sendKeys(name);
		return true;
	}

	@Override
	public boolean inputPassword(String password) {
		UiObject.waitFor(PASSWORD).clear();
		UiObject.waitFor(PASSWORD).sendKeys(password);
		return true;
	}

	@Override
	public boolean clickLogin(PageContext context) {
		UiObject.waitFor(LOGIN).click();
		return true;
	}

}

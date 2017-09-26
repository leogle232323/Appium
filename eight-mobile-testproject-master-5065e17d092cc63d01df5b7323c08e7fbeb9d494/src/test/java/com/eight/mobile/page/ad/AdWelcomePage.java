package com.eight.mobile.page.ad;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.factory.AbstractFactory;
import com.eight.mobile.page.WelcomePage;
import com.eight.mobile.utils.UiObject;
import com.eight.mobile.setting.Settings;

public class AdWelcomePage implements WelcomePage{
	
	public final static By IMAGE_BYCLE = By.id("com.fengjr.mobile:id/bycleView");
	public final static By IMAGE_HOUSE = By.id("com.fengjr.mobile:id/house");
	public final static By IMAGE_EARTH = By.id("com.fengjr.mobile:id/earthView");
	public final static By BUTTON_GO = By.id("com.fengjr.mobile:id/go");
	public final static By NEXT = By.id("com.fengjr.mobile:id/next_btn");
	
	public final static By[] ID = {BUTTON_GO};
	
	public AdWelcomePage() {
		Logger.getLogger(AdWelcomePage.class).info("Android welcome page object created.");
	}

	public boolean goBack(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	public By[] getIdentification() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean skipWelcomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}

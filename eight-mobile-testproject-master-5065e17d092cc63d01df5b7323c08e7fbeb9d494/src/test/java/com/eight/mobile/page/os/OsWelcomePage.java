package com.eight.mobile.page.os;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.factory.AbstractFactory;
import com.eight.mobile.page.HomePage;
import com.eight.mobile.page.WelcomePage;
import com.eight.mobile.setting.Settings;
import com.eight.mobile.utils.UiObject;

public class OsWelcomePage implements WelcomePage{
	
	private By PAGE_INDICATOR = By.className("UIAPageIndicator");
	private By GO = By.name("FJRSPlash_Start_Button");
	private By MONEY = By.name("理理财");
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

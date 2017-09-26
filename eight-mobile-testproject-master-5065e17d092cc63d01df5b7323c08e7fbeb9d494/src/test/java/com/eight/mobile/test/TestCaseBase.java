package com.eight.mobile.test;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.eight.mobile.api.Config;
import com.eight.mobile.base.PageContext;
import com.eight.mobile.factory.AbstractFactory;
import com.eight.mobile.setting.Configurator;

public class TestCaseBase {

	@BeforeTest
	@Parameters({
		Configurator.SELENIUM_URL,
		Configurator.APP_URL, Configurator.APP_PACKAGE, Configurator.APP_ACTIVITY,
		Configurator.DEVICE_NAME, Configurator.PLATFORM_NAME, Configurator.PLATFORM_VERSION, Configurator.BROWSER_NAME,
		Configurator.LOGIN_MOBILE_NUMBER, Configurator.LOGIN_PASSWORD})
	public void beforeTest(String seleniumUrl, 
			String app, String appPackage, String appActivity,
			String deviceName, String platformName, String platformVersion, String browserName,
			String mobile, String password) throws IOException, InterruptedException {
			
		Configurator config = Configurator.instance();
		config.beforeTest(seleniumUrl, app, appPackage, appActivity, deviceName, platformName, platformVersion, browserName, mobile, password);
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void switchEnvironment(int environment) {
		PageContext context = new PageContext();
		context.enterPersonalCenter(context);
		context.enterSettingPage(context);
		context.enterAboutPage(context);
		context.enterEnvironmentSwitch(context);
		context.switchEnvironment(context,environment);		
	}

	public AppiumDriver getAppiumDriver() {
		return  Configurator.instance().getAppiumDriver();
	}
	
	public WebDriver getWebDriver() {
		return  Configurator.instance().getWebDriver();
	}
//
//	public Map<String, String> getParamters() {
//		return config.getParamters();
//	}
//	

	
	public String getLoginAccount() {
		return Configurator.instance().getParamters().get(Configurator.LOGIN_MOBILE_NUMBER);
	}
	
	public String getLoginPassword() {
		return Configurator.instance().getParamters().get(Configurator.LOGIN_PASSWORD);
	}
	
	public AbstractFactory getFactory() {
		return Configurator.instance().getFactory();
	}
}

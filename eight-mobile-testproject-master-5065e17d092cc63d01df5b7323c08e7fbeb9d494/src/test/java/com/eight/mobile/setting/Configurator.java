package com.eight.mobile.setting;

import com.eight.mobile.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.eight.mobile.factory.AbstractFactory;
import com.eight.mobile.factory.AndroidFactory;
import com.eight.mobile.factory.MacFactory;
import com.eight.mobile.factory.MobileWebFactory;



public class Configurator {
	
	public final static String SELENIUM_URL = "selenium-url";
	public final static String APP_URL = "app-url";
	public final static String APP_PACKAGE = "app-package";
	public final static String APP_ACTIVITY = "app-activity";
	public final static String DEVICE_NAME = "device-name";
	public final static String PLATFORM_NAME = "platform-name";
	public final static String PLATFORM_VERSION = "platform-version";
	public final static String BROWSER_NAME = "browser-name";

	public final static String LOGIN_MOBILE_NUMBER = "mobile-number";
	public final static String LOGIN_PASSWORD = "password";
	
	public final static int TIMEOUT_LONG = 10;
	public final static int TIMEOUT_SHORT = 5;


	// appium parameters
	private DesiredCapabilities capabilities;
	private AppiumDriver appium;
	private WebDriver driver;
	private AbstractFactory factory;
	private static String platForm ;
	
	private Map<String, String> para;
	
	private static Configurator configurator;
	
	public static Configurator instance() {
		if (configurator == null) {
			return configurator = new Configurator();
		} else {
			return configurator;
		}
	}

	private Configurator() {
		para = new HashMap<String,String>();
	}
	
	public void beforeTest(String seleniumUrl, 
			String app, String appPackage, String appActivity,
			String deviceName, String platformName, String platformVersion, String browserName,
			String mobile, String password) throws IOException, InterruptedException {
		
		para.put(Configurator.SELENIUM_URL, seleniumUrl);
		para.put(Configurator.APP_URL, app);
		para.put(Configurator.APP_PACKAGE, appPackage);
		para.put(Configurator.APP_ACTIVITY, appActivity);
		para.put(Configurator.DEVICE_NAME, deviceName);
		para.put(Configurator.PLATFORM_NAME, platformName);
		para.put(Configurator.PLATFORM_VERSION, platformVersion);
		para.put(Configurator.BROWSER_NAME, browserName);
		para.put(Configurator.LOGIN_MOBILE_NUMBER, mobile);
		para.put(Configurator.LOGIN_PASSWORD, password);
		confirmPlatForm();
	    capabilities = new DesiredCapabilities();
	    capabilities.setCapability("deviceName", para.get(DEVICE_NAME));
//	    capabilities.setCapability("platformName", para.get(PLATFORM_NAME));
		capabilities.setCapability("platformName", platForm);
	    capabilities.setCapability("platformVersion",  para.get(PLATFORM_VERSION));
	    capabilities.setCapability("browserName", para.get(BROWSER_NAME));
	    capabilities.setCapability("app", para.get(APP_URL));
	    capabilities.setCapability("appPackage", para.get(APP_PACKAGE));
	    capabilities.setCapability("appActivity", para.get(APP_ACTIVITY));
	    capabilities.setCapability("unicodeKeyboard", "True");  
	    capabilities.setCapability("resetKeyboard", "True");
		System.out.println(capabilities.toString());
		if ("Chrome".equalsIgnoreCase(para.get(BROWSER_NAME)) ||
				"Safari".equalsIgnoreCase(para.get(BROWSER_NAME))) {
		    driver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);
			factory = new MobileWebFactory();
		} else {
		
			if ("Android".equalsIgnoreCase(platForm)) {
				appium = new AndroidDriver(new URL(seleniumUrl), capabilities);
				System.out.println("seleniumUrl"+seleniumUrl);
				factory = new AndroidFactory();
			} else if ("iOS".equalsIgnoreCase(platForm)) {
				appium = new IOSDriver(new URL(seleniumUrl), capabilities);
				factory = new MacFactory();
			} else {
				throw new RuntimeException("Unknown Platform!");
			}
		}
	}

	private void confirmPlatForm() {
		String mess = Utils.runCommand("adb devices");
		try {
			if(mess.length()>24){
				platForm = "Android";
			}else {
				platForm = "iOS";
			}
		}catch (Exception e){
			platForm = "Android";
		}

	}
	public AppiumDriver getAppiumDriver() {
		return appium;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public AbstractFactory getFactory() {
		return factory;
	}
	
	public Map<String,String> getParamters() {
		System.out.println(para.toString());
		return para;
	}
	
	public String get(String key) {
		return para.get(key);
	}
	

}

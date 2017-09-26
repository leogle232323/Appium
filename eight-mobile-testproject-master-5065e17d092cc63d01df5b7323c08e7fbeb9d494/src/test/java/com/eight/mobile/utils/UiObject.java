package com.eight.mobile.utils;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eight.mobile.exception.UiObjectNotFoundException;
import com.eight.mobile.setting.Configurator;
import com.eight.mobile.setting.Settings;

public class UiObject {

	private Configurator config;
	private AppiumDriver appium;
	private By selector;
	
	private UiObject() {
		config = Configurator.instance();
		appium = config.getAppiumDriver();
	}

	public UiObject(By by) {
		this();
		selector = by;
	}


	/**
	 * 查看控件是否在当前界面显示，该函数立即返回
	 */
	public boolean exist() {
		try {
			appium.findElement(selector);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
	
	/**
	 * 等待控件出现
	 * @return
	 */
	public boolean waitFor() {
		return waitFor(Settings.TIMEOUT_LONG);
	}
	
	/**
	 * 等待控件出现
	 * @param timeout
	 * @return
	 */
	public boolean waitFor(long timeout) {
		try {
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), timeout);
			waitor.until(ExpectedConditions.visibilityOfElementLocated(selector));
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	// delegate methods
	
	public UiObject click() {
		WebElement element = appium.findElement(selector);
		element.click();
		return this;
	}

	public UiObject submit() {
		WebElement element = appium.findElement(selector);
		element.submit();
		return this;
	}

	public UiObject sendKeys(CharSequence... keysToSend) {
		WebElement element = appium.findElement(selector);
		element.sendKeys(keysToSend);
		return this;
	}

	public UiObject clear() {
		WebElement element = appium.findElement(selector);
		element.clear();
		return this;
	}

	public String getTagName() {
		WebElement element = appium.findElement(selector);
		return element.getTagName();
	}

	public String getAttribute(String name) {
		WebElement element = appium.findElement(selector);
		return element.getAttribute(name);
	}

	public boolean isSelected() {
		WebElement element = appium.findElement(selector);
		return element.isSelected();
	}

	public boolean isEnabled() {
		WebElement element = appium.findElement(selector);
		return element.isEnabled();
	}

	public String getText() {
		WebElement element = appium.findElement(selector);
		return element.getText();
	}

	public List<WebElement> findElements(By by) {
		WebElement element = appium.findElement(selector);
		return element.findElements(by);
	}

	public WebElement findElement(By by) {
		WebElement element = appium.findElement(selector);
		return element.findElement(by);
	}

	public boolean isDisplayed() {
		WebElement element = appium.findElement(selector);
		return element.isDisplayed();
	}

	public Point getLocation() {
		WebElement element = appium.findElement(selector);
		return element.getLocation();
	}

	public Dimension getSize() {
		WebElement element = appium.findElement(selector);
		return element.getSize();
	}

	public String getCssValue(String propertyName) {
		WebElement element = appium.findElement(selector);
		return element.getCssValue(propertyName);
	}

	// static methods
	/**
	 * 返回AppiumDriver对象
	 * @return
	 */
	public static AppiumDriver getAppiumDriver() {
		return Configurator.instance().getAppiumDriver();
	}
	
	/**
	 * 隐藏软键盘
	 */
	public static void hideKeyborad() {
		Configurator.instance().getAppiumDriver().hideKeyboard();
	}
	

	public static boolean waitGone(By by) {
		
		try {
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), Settings.TIMEOUT_SHORT);
			waitor.until(ExpectedConditions.invisibilityOfElementLocated(by));
			return true;
		} catch (Throwable e) {
			return false;
		}
	}
	
	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by) throws UiObjectNotFoundException {
		return waitFor(by, Settings.TIMEOUT_LONG);
	}

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @param msg
	 *            未找到视图时输出此消息
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by, String msg)
			throws UiObjectNotFoundException {
		return waitFor(by, Settings.TIMEOUT_LONG, msg);
	}


	public static UiObject waitFor(By by, long timeout)
			throws UiObjectNotFoundException {
		return waitFor(by, timeout, null);
	}

	/**
	 * 等待某视图出现
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            最大等待时长，单位秒
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public static UiObject waitFor(By by, long timeout, String msg)
			throws UiObjectNotFoundException {
		try {
			if(searchFor(by)){
				return new UiObject(by);
			}
			Utils.scrollUp();
			WebDriverWait waitor = new WebDriverWait(Configurator.instance()
					.getAppiumDriver(), timeout);
			waitor.until(ExpectedConditions.visibilityOfElementLocated(by));
			return new UiObject(by);
		} catch (Throwable e) {
            try {
                takeScreenShot(getAppiumDriver());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            String errorMessage = (msg == null ? "" : msg + ": ")
					+ by.toString() + " not found.";
			throw new UiObjectNotFoundException(errorMessage);
		}
	}
	

	public static boolean searchFor(By[] bys) {
		for (By by: bys) {
			if (!searchFor(by))
				return false;
		}
		return true;
	}


	public static boolean searchFor(By by) {
		return searchFor(by, Settings.TIMEOUT_SHORT, null);
	}

	public static boolean searchFor(By by, By scroll) {
		return searchFor(by, Settings.TIMEOUT_SHORT, scroll);
	}

	/**
	 * 在当前界面查找视图, 如果scroll可用，该方法会进行滑动查找，直到找到指定控件，或者超时
	 * 
	 * @param by
	 *            视图选择器
	 * @param timeout
	 *            查找的最大时长，单位秒
	 *        scroll 
	 * 			  可以进行滑动的试图，例如ListView, ScrollView等
	 * @return
	 */
	public static boolean searchFor(By by, long timeout, By scroll) {
		
		boolean result;
		int count = 0;
		while (true && count <= timeout) {
			try {
				WebDriverWait waitor = new WebDriverWait(Configurator.instance()
						.getAppiumDriver(), 1);
				count++;
				waitor.until(ExpectedConditions.visibilityOfElementLocated(by));
				result = true;
			} catch (Throwable e) {
				result = false;
			}
			if (scroll != null && result == false) {
				if (UiObject.searchFor(scroll)) {
					UiScroller.scrollDown(scroll);
				} else {
					return false;
				}
			} else {
				return result;
			}
		}
		return false;
	}
	
	public static void takeScreenShot(AppiumDriver appium) throws IOException
	{   String currentPath = System.getProperty("user.dir");
		File screen = appium.getScreenshotAs(OutputType.FILE);
        FileUtils
        .copyFile(screen, new File(currentPath + "/pictures/" +getCurrentDateTime()+".jpg"));
	} 
	
	public static String getCurrentDateTime(){
		   SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
		   return df.format(new Date());
		}
}

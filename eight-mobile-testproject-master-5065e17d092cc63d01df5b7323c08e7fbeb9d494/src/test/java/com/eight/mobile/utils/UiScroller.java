package com.eight.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eight.mobile.setting.Configurator;
import com.eight.mobile.setting.Settings;

public class UiScroller<T> {
	
	private By mListBy;
	private By mCellBy;
	
	public UiScroller(By listBy, By cellBy) {
		mListBy = listBy;
		mCellBy = cellBy;
	}
	
	/**
	 * 遍历列表中的元素
	 * @param clazz 列表元素类型
	 * @param listener 通知遍历状态：开始，发现元素，遍历结束
	 * @param listBy 列表元素	
	 * @param cellBy 列表项元素
	 */
	@SuppressWarnings("unchecked")
	public void traversal(Class<T> clazz, Tourist<T> listener) {
		
		AppiumDriver appium = com.eight.mobile.setting.Configurator.instance().getAppiumDriver();
		List<T> searchedList = new ArrayList<T>();
		int searchedElements = 0;
		
		if (listener != null) listener.start();

		do { 
			searchedElements = searchedList.size();	
			List<WebElement> elements = appium.findElements(mCellBy);
			
			for (WebElement elm: elements) {
				Constructor<?> ctor;
				T listItem = null;
				try {
					ctor = clazz.getConstructor(WebElement.class);
					listItem = (T) ctor.newInstance(elm);
					if (!searchedList.contains(listItem)) {
						searchedList.add(listItem);
						listener.notice(listItem);

						if (listener.stopCondition()) {
							return;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			scrollDown(mListBy);
		} while (searchedElements != searchedList.size());
		
		if (listener != null) listener.end();
	}
	
	/**
	 * 遍历列表中的元素
	 * @param clazz 列表元素类型
	 * @param listener 通知遍历状态：开始，发现元素，遍历结束
	 * @param listBy 列表元素	
	 * @param cellBy 列表项元素
	 */
	@SuppressWarnings("unchecked")
	public List<? extends T> traversal(Class<T> clazz) {
		
		AppiumDriver appium = com.eight.mobile.setting.Configurator.instance().getAppiumDriver();
		List<T> searchedList = new ArrayList<T>();
		int searchedElements = 0;

		int insertPoint = 0;

		do { 
			searchedElements = searchedList.size();	
			List<WebElement> elements = appium.findElements(mCellBy);
			
			for (int i = elements.size()-1; i >=0; i--) {
				WebElement elm = elements.get(i);
				
				Constructor<?> ctor;
				T listItem = null;
				try {
					ctor = clazz.getConstructor(WebElement.class);
					listItem = (T) ctor.newInstance(elm);
					if (!searchedList.contains(listItem)) {
						searchedList.add(insertPoint, listItem);
					} else {
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			insertPoint = searchedList.size();
			
			scrollDown(mListBy);
		} while (searchedElements != searchedList.size());
		
		return searchedList;
	}
	
	/**
	 * 向下滑动ListView
	 * @param listBy 滑动的View
	 */
	public static void scrollDown(By listBy) {
		AppiumDriver appium = com.eight.mobile.setting.Configurator.instance().getAppiumDriver();
		WebDriverWait wait = new WebDriverWait(appium, Settings.TIMEOUT_LONG);
		WebElement listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(listBy));
		Dimension dimension = listElm.getSize();
		Point point = listElm.getLocation();
		
		int startx = point.x + dimension.width / 2;
		int starty = point.y + dimension.height - dimension.height / 3;
		int endx = startx;
		int endy = point.y + dimension.height / 20;
		
		appium.swipe(startx, starty, endx, endy, 1000);
		
//		TouchAction touchAction = new TouchAction(appium);
//		touchAction.press(x1, y1);
//		for (int i = y1; i > y2; i-=20) {
//			touchAction.moveTo(x2, i).waitAction(1);
//		}
//		touchAction.release();
//		touchAction.perform();
	}

	/**
	 *  向上滑动ListView
	 * @param listBy 滑动的View
	 */
	public static void scrollUp(By listBy) {
		AppiumDriver appium = com.eight.mobile.setting.Configurator.instance().getAppiumDriver();
		WebDriverWait wait = new WebDriverWait(appium, Settings.TIMEOUT_LONG);
		WebElement listElm = wait.until(ExpectedConditions.visibilityOfElementLocated(listBy));
		
		Dimension dimension = listElm.getSize();
		Point point = listElm.getLocation();
		
		int endx = point.x + dimension.width / 2;
		int endy = point.y + dimension.height - dimension.height / 3;
		int startx = endx;
		int starty = point.y + dimension.height / 20;
		
		appium.swipe(startx, starty, endx, endy, 1000);
		
//		if (Configurator.instance().getParamters().get(Configurator.PLATFORM_NAME).equalsIgnoreCase("android")) {			
//			TouchAction touchAction = new TouchAction(appium);
//			touchAction.press(x2, y2);
//			for (int i = y2; i > y1; i+=20) {
//				touchAction.moveTo(x2, i).waitAction(1);
//			}
//			touchAction.release();
//			touchAction.perform();		
//		} else {
//			appium.swipe(startx, starty, endx, endy, duration);
//		}
	}
	
	
	public interface Tourist<T> {
		
		/**
		 * 遍历开始
		 */
		void start();
		
		/**
		 * 通知找到的元素
		 * @param listItem 已经找到的元素
		 */
		void notice(T listItem);
		
		/**
		 * 遍历结束
		 */
		void end();
		
		/**
		 * 
		 * @return true 停止遍历， false 继续遍历
		 */
		boolean stopCondition();

		
	}
}

package com.eight.mobile.factory;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import com.eight.mobile.base.Page;
import com.eight.mobile.page.UnknowPage;
import com.eight.mobile.setting.Configurator;
import com.eight.mobile.utils.UiObject;

public abstract class AbstractFactory {

	/**
	 * 创建页对象
	 * 
	 * @param clazz
	 * @return
	 */
	public abstract Page createPage(Class<?> clazz) ;

	/**
	 * 获取当前平台类型
	 * 
	 * @return
	 */
	public static Platform type() {

		String platform = Configurator.instance().getParamters()
				.get(Configurator.PLATFORM_NAME);
		if ("android".equalsIgnoreCase(platform)) {
			return Platform.ANDROID;
		} else if ("ios".equalsIgnoreCase(platform)) {
			return Platform.MAC;
		} else {
			throw new RuntimeException("unsupport platform: " + platform);
		}
	}

	/**
	 * 给定界面是否出现
	 * 
	 * @param clazz
	 * @return
	 */
//	public boolean isLoaded(Page page) {
//		if (page != null) {
//			By[] id = page.getIdentification();
//			if (id == null) return false;
//			for (By by : id) {
//				Logger.getRootLogger().info("Check Condition: " + by.toString());
// 				if (!UiObject.searchFor(by)) {
// 					Logger.getRootLogger().info("Check Condition: FAILED");
//					return false;
// 				} else {
// 					//Logger.getRootLogger().info("Check Condition: PASSED");
// 				}
//			}
//			return true;
//		} else {
//			Logger.getRootLogger().info("Page is null");
//			return false;
//		}
//	}

	/**
	 * 给定界面是否出现
	 * 
	 * @param clazz
	 * @return
	 */
//	public boolean isLoaded(Class<?> clazz) {
//		Page page = createPage(clazz);
//		return isLoaded(page);
//	}

	/**
	 * 获取页对象的指纹
	 * 
	 * @param clazz
	 * @return
	 */
//	public String getPageFingerprint(Class<?> clazz) {
//
//		Page pageObj = createPage(clazz);
//		if (pageObj != null) {
//			By[] id = pageObj.getIdentification();
//			StringBuilder builder = new StringBuilder();
//			for (By by : id) {
//				builder.append(by.toString());
//			}
//			return DigestUtils.md5Hex(builder.toString());
//		} else {
//			return null;
////		}
//	}
	
	/**
	 * 返回与当前界面对应的类的实例
	 * @return
	 */
//	public Page matchCurrentUi() {
//		return matchCurrentUi(null);
//	}

	/**
	 * 返回与当前界面对应的类的实例
	 * 
	 * @return
	 */
//	public Page matchCurrentUi(Class<?> intent) {
//		if (intent != null && isLoaded(intent)) return createPage(intent);
//
//		String packagename = "com.fengjr.mobile.page.os";
//
//		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
//		classLoadersList.add(ClasspathHelper.contextClassLoader());
//		classLoadersList.add(ClasspathHelper.staticClassLoader());
//
//		Reflections reflections = new Reflections(
//				new ConfigurationBuilder().setScanners(new SubTypesScanner(false),
//				new ResourcesScanner()).setUrls(ClasspathHelper.forPackage(packagename))
//				.filterInputsBy(new FilterBuilder().includePackage(packagename)));
//		
//		Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
//
//		Logger.getRootLogger().info(allClasses.size() +  " class has been found.");
//		for (Class<? extends Object> clazz : allClasses) {
//			Logger.getRootLogger().info("check the current page if " + clazz.getName() + " or not.");
//			if (clazz.getName().contains("UnknowPage")) continue;
//			if (isLoaded(clazz)) {
//				Logger.getRootLogger().info("The current page is " + clazz.getName());
//				return createPage(clazz);
//			} else {
//				Logger.getRootLogger().info("not " + clazz.getName());
//			}
//		}
//
//		return createPage(UnknowPage.class);
//	
//	}
}

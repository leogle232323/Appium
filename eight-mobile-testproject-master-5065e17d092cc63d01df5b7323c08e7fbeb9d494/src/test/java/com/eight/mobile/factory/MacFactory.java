package com.eight.mobile.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.eight.mobile.base.Page;

public class MacFactory extends AbstractFactory{

	@Override
	public Page createPage(Class<?> clazz) {
		
		Constructor<?> ctor;

		try {

			String clazzName = clazz.getName();
			String[] nameSplit = clazzName.split("\\.");

			if (nameSplit.length > 0) {
				System.out.println("clazzName:" + clazzName);
				String lastSplit = nameSplit[nameSplit.length - 1];
				System.out.println("lastSplit:" + lastSplit);
				if (!lastSplit.contains("Os")) {
					clazzName = clazzName.replace(lastSplit, "os.Os" + lastSplit);
				}
				clazz = Class.forName(clazzName);

				ctor = clazz.getConstructor();
				Page pageObj = (Page) ctor.newInstance();

				return pageObj;
			}

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("call createPage in MacFactory return null!");
		return null;

	}
}

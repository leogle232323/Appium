package com.eight.mobile.page.os;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.HomePage;
import com.eight.mobile.utils.UiObject;

public class OsHomePage implements HomePage{
	
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
	public boolean enterCommunity(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean enterMessage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean enterPersonalCenter(PageContext context) {
		
		return false;
	}
	@Override
	public boolean enterSearchPage(PageContext context) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean inputSearchContext(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean inputSearchContext(PageContext context, String str) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean enterNeedPage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

}

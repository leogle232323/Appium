package com.eight.mobile.page.os;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.exception.UnknowPageException;
import com.eight.mobile.page.UnknowPage;

public class OsUnknowPage implements UnknowPage{
	
	private void error(String message) {
		throw new UnknowPageException(message);
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

}

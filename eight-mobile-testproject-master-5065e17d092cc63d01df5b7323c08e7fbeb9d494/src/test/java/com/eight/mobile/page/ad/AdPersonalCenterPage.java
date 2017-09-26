package com.eight.mobile.page.ad;

import com.eight.mobile.setting.Configurator;
import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.PersonalCenterPage;
import com.eight.mobile.utils.UiObject;
import org.openqa.selenium.WebElement;

public class AdPersonalCenterPage implements PersonalCenterPage {
	private static By LOGINNAME = By.id("com.zhubajie.client:id/user_center_login_info");
	private static By MYORDER = By.id("com.zhubajie.client:id/main_item");
	private static By LOGINACCOUNT = By.id("com.zhubajie.client:id/user_center_head_band_phone_text_view");
	private static By HOMEPAGE = By.id("com.zhubajie.client:id/menu_layout_1");
	private static By E1 = By.id("com.zhubajie.client:id/switch_environment_e1");
	private static By T4 = By.id("com.zhubajie.client:id/switch_environment_t4");
	private static By T18 = By.id("com.zhubajie.client:id/switch_environment_t18");
	@Override
	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean enterLoginPage(PageContext context) {
		UiObject.waitFor(LOGINNAME).click();
		return true;
	}

	@Override
	public boolean enterMyOrderPage(PageContext context) {
		UiObject.waitFor(MYORDER).click();
		return true;
	}

	@Override
	public boolean isLogin(PageContext context) {
		boolean isLogined = UiObject.searchFor(LOGINACCOUNT);
		return isLogined;
	}

	@Override
	public boolean personalCenterGoback(PageContext context) {
		UiObject.waitFor(HOMEPAGE).click();
		return true;
	}

	@Override
	public boolean enterSettingPage(PageContext context) {
		UiObject.getAppiumDriver().scrollTo("设置");
		UiObject.getAppiumDriver().findElementByName("设置").click();
		return true;
	}

	@Override
	public boolean enterAboutPage(PageContext context) {
		UiObject.waitFor(By.id("com.zhubajie.client:id/setting_current_version_text_view")).click();
		return true;
	}

	@Override
	public boolean enterEnvironmentSwitch(PageContext context) {
		UiObject.waitFor(By.id("com.zhubajie.client:id/switch_environment")).click();
		return true;
	}

	@Override
	public boolean switchEnvironment(PageContext context, int environment) {
		if(environment==1){
			UiObject.waitFor(E1).click();
			if(UiObject.searchFor(E1)){
				context.goHomePage(context);
			}
		}else if(environment==4){
			UiObject.waitFor(T4).click();
			if(UiObject.searchFor(E1)){
				context.goHomePage(context);
			}
		}else {
			UiObject.waitFor(T18).click();
			if(UiObject.searchFor(E1)){
				context.goHomePage(context);
			}
		}
		return true;
	}

}

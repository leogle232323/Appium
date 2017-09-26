package com.eight.mobile.page.ad;

import org.openqa.selenium.By;

import com.eight.mobile.base.PageContext;
import com.eight.mobile.page.CirclePage;
import com.eight.mobile.utils.UiObject;

public class AdCirclePage implements CirclePage {
	private static By SENDTOPIC = By.id("com.zhubajie.client:id/ptrf_circle_publish_topic");
	private static By TOPIC = By.id("com.zhubajie.client:id/commu_release_topic");
	private static By TOPICCHOICE = By.id("com.zhubajie.client:id/commu_release_select");
	private static By SEND = By.id("com.zhubajie.client:id/comu_realse");
	private static By TEXT = By.id("com.zhubajie.client:id/activity_community_mycircle_lv_item_content");
	
	@Override
	public boolean goHomePage(PageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean switchCircle(PageContext context) {
		UiObject.getAppiumDriver().findElementByName("圈子").click();
		return true;
	}

	@Override
	public boolean enterTopic(PageContext context) {
		UiObject.waitFor(SENDTOPIC).click();
		return true;
	}

	@Override
	public boolean sendTopic(PageContext context, String topicContent, String topicItem) {
		UiObject.waitFor(TOPIC).sendKeys(topicContent);
		UiObject.waitFor(TOPICCHOICE).click();
		UiObject.getAppiumDriver().findElementByName(topicItem).click();
		UiObject.waitFor(SEND).click();
		return true;
	}

	@Override
	public boolean enterIMShopkeeper(PageContext context) {
		UiObject.getAppiumDriver().findElementByName("我是网店主").click();
		return true;
	}

	@Override
	public String getTopicText(PageContext context) {	
		return UiObject.waitFor(TEXT).getText();
	}

}

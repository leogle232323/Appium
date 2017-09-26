package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;
 /**
  * 社区page
  * @author houshuo
  *
  */
public interface CirclePage extends Page {
	/**
	 * 切换至圈子
	 * @param context
	 * @return
	 */
	public boolean switchCircle(PageContext context);
	
	/**
	 * 进入发话题页面
	 * @param context
	 * @return
	 */
	public boolean enterTopic(PageContext context);
	/**
	 * 圈子界面，发布话题
	 * @param context
	 * @param topicContent
	 * @param topicItem
	 * @return
	 */
	public boolean sendTopic(PageContext context, String topicContent, String topicItem);
	/**
	 * 圈子界面，进入“我是网店主”
	 * @param context
	 * @return
	 */
	public boolean enterIMShopkeeper(PageContext context);
	/**
	 * topic列表获得话题发布内容
	 * @param context
	 * @return
	 */
	public String getTopicText(PageContext context);
}

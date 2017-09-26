package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;

/**
 * 首页
 * @author edwards
 *
 */
public interface HomePage extends Page{
	/**
	 *  进入社区
	 * @param context
	 * @return
	 */
	public boolean enterCommunity(PageContext context);
	
	/**
	 * 进入消息tab
	 * @param context
	 * @return
	 */
	public boolean enterMessage(PageContext context);
	
	/**
	 * 进入个人中心
	 * @param context
	 * @return
	 */
	public boolean enterPersonalCenter(PageContext context);
	/**
	 * 进入搜索界面
	 * @param context
	 * @return
	 */
	public boolean enterSearchPage(PageContext context);
	/**
	 * 输入搜索内容
	 * @param context
	 * @return
	 */
	public boolean inputSearchContext(PageContext context);

	public boolean inputSearchContext(PageContext context, String str);
	/**
	 * 进入发需求界面
	 * @param context
	 * @return
	 */
	public boolean enterNeedPage(PageContext context);


	
}

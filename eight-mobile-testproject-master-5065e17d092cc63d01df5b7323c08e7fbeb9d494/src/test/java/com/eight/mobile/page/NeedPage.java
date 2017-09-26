package com.eight.mobile.page;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;
/**
 * 发布需求界面
 * @author edwards
 *
 */
public interface NeedPage extends Page{
	/**
	 * 输入需求内容
	 * @param context
	 * @param str
	 * @return 
	 */
	boolean inputNeedContent(PageContext context,String str);
	/**
	 * 选择类目名称
	 * @param string
	 */
	boolean selectNeedItem(String string);
	/**
	 * 输入预算
	 * @param string
	 * @return
	 */
	boolean inputBudget(String string);
	/**
	 * 发布需求
	 * @param context
	 * @return
	 */
	boolean sendNeed(PageContext context);
	/**
	 * 需求界面返回
	 * @param context
	 * @return
	 */
	boolean goNeedPageBack(PageContext context);
	
}

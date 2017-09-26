package com.eight.mobile.page;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.eight.mobile.base.Page;
import com.eight.mobile.base.PageContext;
/**
 *搜索服务列表页
 * @author houshuo
 *
 */
public interface SearchServiceListPage extends Page {
	/**
	 * 搜索服务列表，进入店铺
	 * @param context
	 * @return
	 */
	boolean enterShopList(PageContext context);
	/**
	 * 搜索服务列表，进入服务详情
	 * @param context
	 * @return
	 */
	boolean enterServiceDetail(PageContext context);
	/**
	 * 服务详情页面，切换至详情web
	 * @param context
	 * @return
	 */
	boolean switchDetail(PageContext context);
	/**
	 * 服务详情页面，切换至评价页面
	 * @param context
	 * @return
	 */
	boolean switchEvaluate(PageContext context);
	/**
	 * 切换搜索选项
	 * @param context
	 * @param string 服务or店铺
	 * @return
	 */
	boolean switchSearchItem(PageContext context, String string);
	/**
	 * 由详情页进入店铺
	 * @param context
	 * @return
	 */
	boolean enterShop(PageContext context);
	/**
	 * 返回搜索服务列表的title
	 * @return
	 */
	List getServiceListTitle();
	/**
	 * 返回搜索服务列表的价格
	 * @return
	 */
	List<WebElement> getServiceListPrice();
	/**
	 * 返回搜索服务列表的城市
	 * @return
	 */
	List<WebElement> getServiceListCity();
	/**
	 * 返回搜索服务列表卖出数量
	 * @return
	 */
	List<WebElement> getServiceListSales();
	/**
	 * 返回搜索服务列表节省
	 * @return
	 */
	List<WebElement> getServiceListSave();
	/**
	 * 获得服务详情的title
	 * @param context
	 * @return
	 */
	String getServiceDetailTitle(PageContext context);
	/**
	 * 获得服务详情的价格
	 * @param context
	 * @return
	 */
	String getServiceDetailPrice(PageContext context);
	/**
	 * 获得服务详情的销量
	 * @param context
	 * @return
	 */
	String getServiceDetailSales(PageContext context);
	/**
	 * 获得服务项详情的收藏
	 * @param context
	 * @return
	 */
	String getServiceDetailCollection(PageContext context);
	/**
	 * 获得服务详情的综合评分
	 * @param context
	 * @return
	 */
	String getServiceDetailScore(PageContext context);
	/**
	 * 获得服务详情的节省金额
	 * @param context
	 * @return
	 */
	String getServiceDetailSave(PageContext context);
	/**
	 * 获取评价
	 * @param context
	 * @return
	 */
	String getServiceDetailEvaluate(PageContext context);
	/**
	 * 获取店名
	 * @param context
	 * @return
	 */
	String getServiceDetailShopName(PageContext context);
	/**
	 * 获取服务范围
	 * @param context
	 * @return
	 */
	String getServiceDetailRange(PageContext context);

}

package com.web.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息类
 * 
 * @author Administrator
 *
 */
public class NewsPojo extends CommonPojo {

	public NewsPojo() {
		super.setMsgType("news");
	}

	//明细
	private List<NewsItem> allItems = new ArrayList<NewsItem>();

	/**
	 * 图文个数
	 * 
	 * @return
	 */
	public int getArticleCount() {
		return allItems.size();
	}

	public List<NewsItem> getAllItems() {
		return allItems;
	}

	public void setAllItems(List<NewsItem> allItems) {
		this.allItems = allItems;
	}

}

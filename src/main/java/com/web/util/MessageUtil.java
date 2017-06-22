package com.web.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.web.pojo.NewsPojo;
import com.web.pojo.NewsItem;
import com.web.pojo.TextPojo;

public class MessageUtil {

	/**
	 * 解析微信使用POST发送来的用户消息
	 * @param in
	 * @return
	 */
	public static Map<String, Object> parseXml(InputStream in) {

		Map<String, Object> mp = new HashMap<String, Object>();

		SAXReader sax = new SAXReader();
		try {
			// 根节点 src
			Document document = sax.read( in);

			Element root = document.getRootElement();

			Iterator itr = root.elementIterator();
			while (itr.hasNext()) {
				Element el = (Element) itr.next();
				mp.put(el.getName(), el.getTextTrim());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mp;
	}

	
	/**
	 * 我们自己的程序，回复文本给微信用户
	 * @param pojo
	 * @return
	 */
	public static String responseText(TextPojo pojo){
		StringBuffer str=new StringBuffer("<xml>");	
		str.append("<ToUserName><![CDATA["+pojo.getToUser()+"]]></ToUserName>");
		str.append("<FromUserName><![CDATA["+pojo.getFromUser()+"]]></FromUserName>");
		str.append("<CreateTime>"+pojo.getCreateTime()+"</CreateTime>");
		str.append("<MsgType><![CDATA[text]]></MsgType>");
		str.append("<Content><![CDATA["+pojo.getContent()+"]]></Content>");
		str.append("</xml>");
		return str.toString();
	}
	
	/**
	 * 图文消息微信xml格式制作
	 * @param news
	 * @return
	 */
	public static String responseNews(NewsPojo news){
		StringBuffer str=new StringBuffer("<xml>");	
		str.append("<ToUserName><![CDATA["+news.getToUser()+"]]></ToUserName>");	
		str.append("<FromUserName><![CDATA["+news.getFromUser()+"]]></FromUserName>");	
		str.append("<CreateTime>"+news.getCreateTime()+"</CreateTime>");	
		str.append("<MsgType><![CDATA["+news.getMsgType()+"]]></MsgType>");	
		str.append("<ArticleCount>"+news.getArticleCount()+"</ArticleCount>");	
		str.append("<Articles>");	
		
		for(NewsItem  n : news.getAllItems()){
			str.append("<item>");
			str.append("<Title><![CDATA["+n.getTitle()+"]]></Title> ");
			str.append("<Description><![CDATA["+n.getDescription()+"]]></Description>");
			str.append("<PicUrl><![CDATA["+n.getPicUrl()+"]]></PicUrl>");
			str.append("<Url><![CDATA["+n.getUrl()+"]]></Url>");
			str.append("</item>");
		} 
		str.append("</Articles>");	
		str.append("</xml>"); 
		return str.toString();
	}
	
	
}

package com.web.controller.weChart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.pojo.CommonPojo;
import com.web.pojo.NewsItem;
import com.web.pojo.NewsPojo;
import com.web.pojo.TextPojo;
import com.web.util.MessageUtil;
import com.web.util.WeiXinCheckUtil;

/**
 * 微信授权操作
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping
public class WeiXinAuthController {

	// 日志记录工具类
	private Logger logger = Logger.getLogger(WeiXinAuthController.class);

	// 微信验证 接入 操作 wein/adin/api.action?token=123456
	@RequestMapping("/api")
	public void auth(HttpServletRequest request, HttpServletResponse response) {
		// 取得当前请求的格式 GET/POST
		String type = request.getMethod();
		System.out.println("==============================");
		System.out.println("请求类型：" + type);

		logger.debug("请求类型:" + type);

		try {
			// 验证消息的确来自微信服务器
			if (type.equalsIgnoreCase("GET")) {
				System.out
						.println("token认证号是：" + request.getParameter("token"));

				String signature = request.getParameter("signature");
				String timestamp = request.getParameter("timestamp");
				String nonce = request.getParameter("nonce");
				String echostr = request.getParameter("echostr");

				boolean result = WeiXinCheckUtil.checkSignature(
						request.getParameter("token"), signature, timestamp,
						nonce);

				if (result) {
					// 请原样返回echostr参数内容
					PrintWriter out = response.getWriter();
					out.println(echostr);
					out.flush();
					out.close();
				}

			} else {
				// POST提过来的数据， 用户与你交互了
				executeProcess(request, response);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 接收微信的消息，做处理
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void executeProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// 微信用户给我的
		Map<String, Object> mp = MessageUtil.parseXml(request.getInputStream());

		logger.debug(mp.toString());

		// 我给微信用户的 需求回复消息
		CommonPojo pojo = null;

		// 用户发送的文本消息
		if (mp.get("MsgType").equals("text")) {
			// 这个SSM框架应用，是不是要发点消息给用户
			pojo = new NewsPojo();
			pojo.setFromUser(mp.get("ToUserName").toString());
			pojo.setToUser(mp.get("FromUserName").toString());
			pojo.setCreateTime(new Date().getTime());

			NewsPojo np = (NewsPojo) pojo;

			// 多张图最多放10个

			NewsItem item1 = new NewsItem();
			item1.setTitle("mybatis");
			item1.setDescription("mybatis程序开发");
			item1.setPicUrl("http://www.mybatis.org/images/mybatis-logo.png");
			item1.setUrl("http://www.mybatis.org/mybatis-3/zh/getting-started.html"); // 网址
			np.getAllItems().add(item1);

			item1 = new NewsItem();
			item1.setTitle("4.19全场打1折");
			item1.setDescription("全场1折，满500送2000元的券");
			item1.setPicUrl("https://misc.360buyimg.com/mtd/pc/index/home/images/logo.v2.png");
			item1.setUrl("https://www.jd.com/"); // 网址
			np.getAllItems().add(item1);

			String xml = MessageUtil.responseNews(np);

			logger.debug(xml);

			sendWeiXinMessage(xml, response);

		} else if (mp.get("MsgType").equals("event")) {
			// 第一次关注
			if (mp.get("Event").equals("subscribe")) {
				// 这个SSM框架应用，是不是要发点消息给用户
				pojo = new NewsPojo();
				pojo.setFromUser(mp.get("ToUserName").toString());
				pojo.setToUser(mp.get("FromUserName").toString());
				pojo.setCreateTime(new Date().getTime());

				NewsPojo np = (NewsPojo) pojo;

				// 多张图最多放10个

				NewsItem item1 = new NewsItem();
				item1.setTitle("mybatis");
				item1.setDescription("mybatis程序开发");
				item1.setPicUrl("http://www.mybatis.org/images/mybatis-logo.png");
				item1.setUrl("http://www.mybatis.org/mybatis-3/zh/getting-started.html"); // 网址
				np.getAllItems().add(item1);

				item1 = new NewsItem();
				item1.setTitle("4.19全场打1折");
				item1.setDescription("全场1折，满500送2000元的券");
				item1.setPicUrl("https://misc.360buyimg.com/mtd/pc/index/home/images/logo.v2.png");
				item1.setUrl("https://www.jd.com/"); // 网址
				np.getAllItems().add(item1);

				String xml = MessageUtil.responseNews(np);

				logger.debug(xml);

				sendWeiXinMessage(xml, response);
			}
		}

	}

	private void sendWeiXinMessage(String xmlInfo, HttpServletResponse response)
			throws IOException {
		// 开发者可以在响应包（Get）中返回特定XML结构，来对该消息进行响应（现支持回复文本、图片、图文、语音、视频、音乐）
		PrintWriter out = response.getWriter();
		out.write(xmlInfo);
		logger.debug(xmlInfo);
		out.flush();
		out.close();
	}

}

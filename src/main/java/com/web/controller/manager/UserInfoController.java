package com.web.controller.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.UserInfo;
import com.web.pojo.LoginPojo;
import com.web.service.UserInfoService;
import com.web.util.MD5Util;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/manager")
public class UserInfoController {
	
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	
	@RequestMapping(value="/login")
	public String login(LoginPojo pojo,HttpSession session,Model model){
	       String valcode =session.getAttribute("valcode").toString();
	       // 进行验证
    	   if(!valcode.equalsIgnoreCase(pojo.getVcode())){
    		   model.addAttribute("msg", "验证码错误"); 
    		   return "/login"; 	   
    	   }
    	   else{
    		   UserInfo userInfo = userInfoService.login(pojo.getLoginName(), pojo.getLoginPwd());
    		   if (userInfo==null) {
    			   model.addAttribute("msg", "账户名或密码错误");
    			   return "/login";	
    		   } else {
    			   session.setAttribute("userInfo", userInfo);
    			   return "redirect:/manager/showUserWeiXin.action";
    		   }
    	   }				
	}
	
	@RequestMapping(value="/out")
	public String out(HttpSession session){
		session.setAttribute("userInfo", null);
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(value="/getVerifyCode")
	public void getVerifyCode(HttpServletRequest request,HttpServletResponse response) {
		// 告知浏览当作图片处理
		HttpSession session=request.getSession();
		

		response.setContentType("image/jpeg");

		// 告诉浏览器不缓存

		response.setHeader("pragma", "no-cache");

		response.setHeader("cache-control", "no-cache");

		response.setHeader("expires", "0");

		// 产生由4位数字构成的验证码

		int length = 4;

		String valcode = "";

		Random rd = new Random();

		String words="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for (int i = 0; i < length; i++)

			valcode += words.charAt(rd.nextInt(36));

		// 把产生的验证码存入到Session中

	

		session.setAttribute("valcode", valcode);

		// 产生图片

		int width = 200;

		int height = 36;

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 获取一个Graphics

		Graphics g = img.getGraphics();

		// 填充背景色

		g.setColor(Color.WHITE);

		g.fillRect(0, 0, width, height);

		// 填充干扰线50

		for (int i = 0; i < 50; i++) {

			g.setColor(new Color(rd.nextInt(50) + 150, rd.nextInt(50) + 150, rd.nextInt(50) + 150));

			g.drawLine(rd.nextInt(width), rd.nextInt(height), rd.nextInt(width), rd.nextInt(height));

		}

		// 绘制边框

		g.setColor(Color.GRAY);

		g.drawRect(0, 0, width - 1, height - 1);

		// 绘制验证码

		Font[] fonts = { new Font("隶书", Font.BOLD, 24), new Font("楷体", Font.BOLD, 24), new Font("宋体", Font.BOLD, 24),
				new Font("幼圆", Font.BOLD, 24) };

		for (int i = 0; i < length; i++) {

			g.setColor(new Color(rd.nextInt(150), rd.nextInt(150), rd.nextInt(150)));

			g.setFont(fonts[rd.nextInt(fonts.length)]);

			g.drawString(valcode.charAt(i) + "", width / valcode.length() * i + 2, 24);
			
		}

		// 输出图像

		g.dispose();

		try {
			ImageIO.write(img, "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	@RequestMapping(value="/register")
	public String register(UserInfo userInfo,String vcode,HttpSession session,Model model){
	       String valcode =session.getAttribute("valcode").toString();
	       // 进行验证
	       if(!valcode.equalsIgnoreCase(vcode)){
	    	   model.addAttribute("msg", "验证码错误"); 
	    	   return "/register"; 	   
	       }
	       else{
	    	   String Pwd=userInfo.getLoginPwd();
	    	   userInfo.setLoginPwd(MD5Util.MD5(Pwd));
	    	   userInfo.setState(1);
	    	   userInfo.setRegTime(new Date());
	    	   userInfo.setEndTime(new Date(System.currentTimeMillis()+3600*24*30));
	    	   userInfoService.insert(userInfo);
	    	   UserInfo user=userInfoService.login(userInfo.getLoginName(), Pwd);
	    	   session.setAttribute("userInfo", user);
	    	   return "redirect:/manager/showUserWeiXin.action";
			}			
	}
}

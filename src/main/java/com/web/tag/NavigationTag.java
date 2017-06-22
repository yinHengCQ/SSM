package com.web.tag;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.web.util.PageUtil;

/**
 * 自定义分页导航标签
 * 
 * @author Administrator
 *
 */
public class NavigationTag extends TagSupport {
 
	private PageUtil pageUtil;

	// get方式跳转的页面
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PageUtil getPageUtil() {
		return pageUtil;
	}

	// 为了让外面的页面对这个类进行赋值
	public void setPageUtil(PageUtil pageUtil) {
		this.pageUtil = pageUtil;
	}

	// 开始显示数据
	@Override
	public int doStartTag() throws JspException {
		// 画你要显示 的样式

		JspWriter out = pageContext.getOut();

		try {
			out.println("<div class='row'>");

			// 显示导航信息
			out.println("  <div class=\"col-sm-5\">");
			out.println("       <div class=\"dataTables_info\" > ");

			// 没有数据
			if (this.pageUtil.getTotalPages() == 0) {
				out.println("查询不到满足条件的数据!");
			} else {
				out.println("共" + this.pageUtil.getTotalPages() + "页/当前"
						+ this.pageUtil.getPage() + "页  共"
						+ this.pageUtil.getTotalRecords() + "条数据/每页显示"
						+ this.pageUtil.getSize() + "条数据");
			}
			out.println("       </div>");

			out.println("  </div>");

			// 封装分页条
			out.println("  <div class=\"col-sm-7\">");

			printNav(out);

			out.println("  </div>");

			out.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	// 输出导航条
	private void printNav(JspWriter out) {

		// 如果页码小于等于1,就不要显示 导航条
		if (this.pageUtil.getTotalPages() <= 1) {
			return;
		}

		try {
			out.println(" <div class=\"dataTables_paginate paging_simple_numbers\">");

			out.println("    <ul class=\"pagination\">");

			// 当前是第1页,首页和上一页就要被禁用
			if (this.pageUtil.getPage() == 1) {
				out.println("     <li class=\"paginate_button previous disabled\" >");
				out.println("         <a href='"+createUrl(1)+"'>首页</a>");
				out.println("      </li>");

				out.println("     <li class=\"paginate_button previous disabled\" >");
				out.println("           <a href='"+createUrl(this.pageUtil.getPrev())+"'>上一页</a>");
				out.println("      </li>");
			} else {
				out.println("     <li class=\"paginate_button previous \" >");
				out.println("          <a href='"+createUrl(1)+"'>首页</a>");
				out.println("      </li>");

				out.println("     <li class=\"paginate_button previous \" >");
				out.println("          <a href='"+createUrl(this.pageUtil.getPrev())+"'>上一页</a>");
				out.println("      </li>");
			}

			// 默认要显示10个页码， 如果不足就显示最多的那个（共6页 1~6）
			int middle = 5;
			if (pageUtil.getPage() > middle) {
				middle = pageUtil.getPage();
			}

			// 共13页 ，当前第12页

			// 前面=middle-5
			int prev = middle - 5; // middel=12 prev=7 next=13

			if (prev <= 0) {
				prev = 1;
			}
			// 定后面
			int next = prev + 9; // 5+9=14
			// 如果最大页面小于 next
			if (next > this.pageUtil.getTotalPages()) {
				next = this.pageUtil.getTotalPages();
				// prev也要变化，不然不会有10个页码
				prev = next - 9;
				if (prev <= 0) {
					prev = 1;
				}
			}

			for (int i = prev; i <= next; i++) {
				// 这是当前被选中的页
				if (i == this.pageUtil.getPage()) {
					out.println("     <li class=\"paginate_button active\" >");
					out.println("          <a >" + i + "</a>");
					out.println("      </li>");
				} else {
					out.println("     <li class=\"paginate_button\" >");
					out.println("          <a href='"+createUrl(i)+"'>" + i + "</a>");
					out.println("      </li>");
				}
			}

			// 如果当前页是尾页
			if (this.pageUtil.getPage() == this.pageUtil.getTotalPages()) {
				out.println("     <li class=\"paginate_button next  disabled\" >");
				out.println("         <a href='"+createUrl(this.pageUtil.getNext())+"'>下一页</a>");
				out.println("      </li>");

				out.println("     <li class=\"paginate_button next  disabled\" >");
				out.println("          <a href='"+createUrl(this.pageUtil.getTotalPages())+"'>尾页</a>");
				out.println("      </li>");
			} else {
				out.println("     <li class=\"paginate_button next  \" >");
				out.println("          <a href='"+createUrl(this.pageUtil.getNext())+"'>下一页</a>");
				out.println("      </li>");

				out.println("     <li class=\"paginate_button next  \" >");
				out.println("          <a href='"+createUrl(this.pageUtil.getTotalPages())+"'>尾页</a>");
				out.println("      </li>");
			}

			out.println("   </ul> ");

			out.println("  </div>");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//自动生成get方式的url地址
	private String createUrl(int num){
		StringBuffer str=new StringBuffer();
		str.append(url);
		str.append("?page="+num);
		
		//没有必须 每次都要执行，因这样太浪费时间了
		//取得所有的参数
		HttpServletRequest request=(HttpServletRequest) pageContext.getRequest();
		
		Enumeration<String> allName=request.getParameterNames();
		//判断是否有值
		while( allName.hasMoreElements()){
			String key=allName.nextElement();
		    
			if(key!=null){
				//过滤掉分页的参数
				if(key.equals("page")){
					continue;
				}
				
				String value=request.getParameter(key);
				str.append("&"+key+"="+value);
			}
			 
		}
		
		return str.toString();
	}

}

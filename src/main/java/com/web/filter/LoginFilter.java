package com.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

    public LoginFilter() {

    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		if (req.getServletPath().equals("/manager/login.action")||req.getServletPath().equals("/manager/getVerifyCode.action")
				||req.getServletPath().equals("/manager/login.jsp")||req.getServletPath().equals("/manager/register.jsp")
				||req.getServletPath().equals("/manager/register.action")) {
			chain.doFilter(request, response);
			return;
		}else{
			if(null==session.getAttribute("userInfo")){		
				res.sendRedirect(req.getContextPath()+"/manager/login.jsp");
			}else {
				chain.doFilter(request, response);
			}
		}
	
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}

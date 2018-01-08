package com.qianfeng.web.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.shoppingUser;
import com.qianfeng.service.CheckLoginService;


public class autoLoginFilter implements Filter {

	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httprequest=(HttpServletRequest) request;
		Cookie[] cookies = httprequest.getCookies();
		String uname=null;
		String decode_uname=null;
		String password=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				
				if("cookie_uname".equals(cookie.getName())){
					//uname=cookie.getValue();
					decode_uname=cookie.getValue();
					uname = URLDecoder.decode(decode_uname, "utf-8");
				}
				if("cookie_password".equals(cookie.getName())){
					password=cookie.getValue();
					/*URLDecoder.decode("password", "utf-8");*/
				}
			}
			CheckLoginService service = new CheckLoginService();
			shoppingUser user =null;
			try {
				user = service.checkLogin(uname, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user!=null){
				HttpSession session = httprequest.getSession();
				session.setAttribute("user", user);
			}
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {

	}

}

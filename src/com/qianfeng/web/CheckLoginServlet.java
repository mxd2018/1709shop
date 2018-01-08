package com.qianfeng.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qianfeng.domain.User;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.service.CheckLoginService;
import com.qianfeng.utils.C3P0Utils;
import com.qianfeng.web.filter.EnchancedRequest;


public class CheckLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String autologin = request.getParameter("autologin");
		String checkcode = request.getParameter("checkcode");
		HttpSession session_checkcode = request.getSession();
		String word = (String) session_checkcode.getAttribute("word");
		/*System.out.println(word);
		System.out.println(checkcode);*/
		
		//判断自动登录选项
		if(autologin!=null&&!"".equals(autologin)){
			String encode_uname = URLEncoder.encode(uname, "utf-8");
			//Cookie cookie_uname = new Cookie("cookie_uname", uname);
			Cookie cookie_uname = new Cookie("cookie_uname", encode_uname);
			Cookie cookie_password = new Cookie("cookie_password", password);
			
			cookie_password.setMaxAge(60*5);
			cookie_uname.setMaxAge(60*5);
			response.addCookie(cookie_uname);
			response.addCookie(cookie_password);
			
		}
		
		CheckLoginService service = new CheckLoginService();
		
		shoppingUser user=null;
		try {
			user = service.checkLogin(uname,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//判断账号密码是否正确，不正确返回错误信息，正确跳转到首页
		if(user!=null&&checkcode.equals(word)){
			HttpSession session= request.getSession();
			session.setAttribute("user", user);
			
			response.sendRedirect(request.getContextPath()+"/pageProductServlet");	
		}else if(checkcode==null||"".equals(checkcode)){
			request.setAttribute("loginfaile", "请输入验证码");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(!checkcode.equals(word)){
			request.setAttribute("loginfaile", "验证码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.setAttribute("loginfaile", "帐号或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
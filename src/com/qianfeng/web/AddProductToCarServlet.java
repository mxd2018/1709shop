package com.qianfeng.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddProductToCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		
		//将pid作为键存放在session中
		HttpSession session = request.getSession();
		//session.setAttribute(pid, pname);
		
		//将pid放在值中，用拼接的方式
		String pid2=(String) session.getAttribute("p");
		if(pid2!=null){
			
			pid2=session.getAttribute("p")+"-"+pid;
			session.setAttribute("p", pid2);
		}else{
			pid2=pid;
			session.setAttribute("p", pid2);
		}
		//System.out.println(pid2);
		
		//退出浏览器后 购物车商品还能保存的最大时间
		String sessionId = session.getId();
		Cookie cookie=new Cookie("JSESSIONID", sessionId);
		cookie.setMaxAge(180);
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath()+"/pageProductServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
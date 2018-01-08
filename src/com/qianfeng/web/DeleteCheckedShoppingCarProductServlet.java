package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Product;
import com.qianfeng.service.ShoppingCarService;

public class DeleteCheckedShoppingCarProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除存在session中的存放pid的字符串
		String[] pids = request.getParameterValues("checkSingleBox");
		//String[] pids = request.getParameterValues("uname");
		HttpSession session = request.getSession();
		/*if(pids!=null){
			for(String pid:pids){
				session.removeAttribute(pid);
			}
		}*/
		
		String pid2=(String) session.getAttribute("p");
		if(pids!=null&&pid2!=null){
			for(String pid:pids){
				int indexOf = pid2.indexOf(pid);
				
				if(indexOf!=0){
					pid2=pid2.substring(0, indexOf-1)+pid2.substring(indexOf+pid.length());
				}else if(!pid2.equals(pid)){
					pid2=pid2.substring(indexOf+pid.length()+1);
				}else{
					pid2=null;
				}
			}
			session.setAttribute("p", pid2);
		}
		//System.out.println(pid2);
		
		response.sendRedirect(request.getContextPath()+"/shoppingCarServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
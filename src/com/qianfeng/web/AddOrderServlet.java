package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;import javax.swing.plaf.metal.MetalBorders.OptionDialogBorder;

import com.qianfeng.domain.Product;
import com.qianfeng.domain.shoppingOrder;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.domain.vo.Order;
import com.qianfeng.service.PayMoneyService;
import com.qianfeng.service.ShoppingCarService;

public class AddOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		 PayMoneyService service = new PayMoneyService();
		 HttpSession session = request.getSession();
		 
		 shoppingUser user = (shoppingUser) session.getAttribute("user");
		 
		 //获得所有选中的商品的pid
		 String[] parameterValues = request.getParameterValues("checkSingleBox");
		 
		 //获得所有商品的总价
		 double totalprice=0;
		 if(parameterValues!=null){
			for(String pid:parameterValues){
				ShoppingCarService ser=new ShoppingCarService();
				try {
					Product carProduct = ser.showShoppingCarProduct(pid);
					totalprice+=carProduct.getMarket_price();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
		 
		 
		 //o_u_relation 订单表中添加购物车信息
		 Order order =null;
		 String uid=null;
		 String oid=null;
		 if(user!=null&&parameterValues!=null){
			 uid=user.getUid();
			 oid=UUID.randomUUID().toString();
			 try {
				 order = service.addUid(uid,oid,totalprice);
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		
		} 
		
		if(parameterValues!=null){
			
			//o_p_relation中添加信息
			for(String pid:parameterValues){
				try {
					service.addPidandOid(pid,oid);	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			session.setAttribute("order", order);
			response.sendRedirect(request.getContextPath()+"/orderList.jsp");
		}else{
			response.getWriter().write("您没有选中商品！");
		}
		
		 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
package com.qianfeng.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.buyProducts;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.domain.vo.Order;
import com.qianfeng.domain.vo.Orderdetail;
import com.qianfeng.service.PayMoneyService;

public class Order_detailServlet extends HttpServlet {
/*SELECT uname,telephone,addr,ordertime,state,pname,shop_price 
FROM shoppinguser ,o_u_relation,o_p_relation,product 
WHERE shoppinguser.uid=o_u_relation.uno  AND o_u_relation.oid=o_p_relation.oid AND o_p_relation.pid=product.pid ;
 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		shoppingUser user = (shoppingUser) session.getAttribute("user");
		Order order = (Order)session.getAttribute("order");
		String oid=order.getOid();
		String uid = null;
		if(user!=null){
			uid = user.getUid();
		}
		
		
		PayMoneyService service = new PayMoneyService();
		//Orderdetail detail=null;
		List<buyProducts> list =null;
		try {
			list = service.getOrder_detail(uid,oid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(list);
		request.setAttribute("list",list);
		request.getRequestDispatcher("/orderDetail.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
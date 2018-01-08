package com.qianfeng.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.dao.CheckLoginDao;
import com.qianfeng.domain.shoppingUser;
import com.qianfeng.service.RegistService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map = request.getParameterMap();
		shoppingUser shoppinguser = new shoppingUser();
		try {
			BeanUtils.populate(shoppinguser, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shoppinguser.setUid(UUID.randomUUID().toString());
		shoppinguser.setHobby("movies");
		
		RegistService service= new RegistService();
		try {
			service.regist(shoppinguser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/pageProductServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public shoppingUser checkLogin(String uname) throws SQLException {
		CheckLoginDao dao = new CheckLoginDao();
		return dao.checkLogin(uname);
		
	}
}
package com.qianfeng.web.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EnchancedRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	public EnchancedRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	@Override
	public String getParameter(String name){
		
		String nameValue = this.request.getParameter(name);
		String string =null;
		if(nameValue!=null){
			try {
				string = new String(nameValue.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return string;
		
	}
}

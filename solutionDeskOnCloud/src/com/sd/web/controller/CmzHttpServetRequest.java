package com.sd.web.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletRequestWrapper;

public class CmzHttpServetRequest extends HttpServletRequestWrapper{

	public CmzHttpServetRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		
		if("user-agent".equals(name)){
			System.out.println(" name : "+name+"  : super.getHeader(name) : "+super.getHeader(name));
			return "multipart/form-data"; 
		}else{
			System.out.println(" name else : "+name+"  : super.getHeader(name) : "+super.getHeader(name));
			return super.getHeader(name);
		}
		
		
		
	}
	
}



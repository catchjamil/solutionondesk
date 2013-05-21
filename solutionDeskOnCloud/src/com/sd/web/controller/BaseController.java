package com.sd.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.sd.web.dto.BaseDTO;
import com.sd.web.security.Ticket;

//public class BaseController extends SimpleFormController {
public class BaseController {

	protected Object[] getListingData(BaseDTO baseDTO, HttpServletRequest request) {
		return new Object[0];
	}

	protected Ticket getTicket(HttpServletRequest request) {
		return (Ticket) request.getSession().getAttribute("ticket");
	}

	protected void setDataList(HttpServletRequest request) {

		Object[] object = getListingData(null, request);

		request.setAttribute("headerList", object[0]);
		request.setAttribute("dataList", object[1]);

	}
}

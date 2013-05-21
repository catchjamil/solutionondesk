package com.sd.web.util;

public class JsonResponse {

	private String status = null;
	private Object result = null;

	public Object getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
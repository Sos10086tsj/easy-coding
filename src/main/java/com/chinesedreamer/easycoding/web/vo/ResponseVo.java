package com.chinesedreamer.easycoding.web.vo;
/**
 * Description:
 * Auth:Paris
 * Date:Jan 12, 2017
**/
public class ResponseVo {
	private Boolean success;
	private Object data;
	private String errorMessage;
	public Boolean getSuccess() {
		return success;
	}
	public Object getData() {
		return data;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}

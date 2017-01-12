package com.chinesedreamer.easycoding.util;

import com.chinesedreamer.easycoding.web.vo.ResponseVo;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 12, 2017
**/
public class MessageUtil {
	
	public static ResponseVo success() {
		return success(null);
	}
	public static ResponseVo success(Object data) {
		ResponseVo vo =  new ResponseVo();
		vo.setData(data);
		vo.setSuccess(Boolean.TRUE);
		return vo;
	}
	
	public static ResponseVo failure() {
		return failure(null);
	}
	public static ResponseVo failure(String errorMessage) {
		return failure(errorMessage, null);
	}
	public static ResponseVo failure(String errorMessage,Object data) {
		ResponseVo vo =  new ResponseVo();
		vo.setData(data);
		vo.setErrorMessage(errorMessage);
		vo.setSuccess(Boolean.FALSE);
		return vo;
	}
}

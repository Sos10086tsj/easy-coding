package com.chinesedreamer.easycoding.util;

import java.text.MessageFormat;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinesedreamer.easycoding.exception.ErrorMessage;
import com.chinesedreamer.easycoding.exception.ErrorMessageCode;
import com.chinesedreamer.easycoding.web.init.GlobalResource;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 16, 2016
**/
public class ErrorMessageUtil {
	
	public static ErrorMessage getErrorMessage(String groupCode, String code, Object... objects) {
		ErrorMessage message = null;
		if (GlobalResource.errorMapping.containsKey(groupCode)) {
			Map<String,ErrorMessage> map = GlobalResource.errorMapping.get(groupCode);
			if (map.containsKey(code)) {
				ErrorMessage errorMessage = map.get(code);
				if (null == objects || objects.length == 0) {
					message = new ErrorMessage(code,errorMessage.getMessage());
				}else {
					message = new ErrorMessage(code,MessageFormat.format(errorMessage.getMessage(), objects));
				}
			}
		}
		if (null == message) {
			message = getErrorMessageFromFile(groupCode, code, objects);
		}
		return message;
	}
	
	public static ErrorMessage getErrorMessageFromFile(String groupCode, String code, Object... objects) {
		ErrorMessage errorMessage = null;
		JSONObject jsonObject = FileUtil.getJsonFromFile(FileUtil.getResouceRootPath("json/errorMessage.json"));
		GlobalResource.errorMapping.clear();
		JSONObject errorConfigs = jsonObject.getJSONObject("errorCode");
		if (errorConfigs.containsKey(groupCode)) {
			JSONArray keyErrorMessages = errorConfigs.getJSONArray(groupCode);
			for (Object object : keyErrorMessages) {
				JSONObject obj = (JSONObject)object;
				if (obj.containsKey(code)) {
					JSONObject emObj = obj.getJSONObject(code);
					if (null == objects || objects.length == 0) {
						errorMessage = new ErrorMessage(code,emObj.getString("message"));
					}else {
						errorMessage = new ErrorMessage(code,MessageFormat.format(emObj.getString("message"), objects));
					}
					break;
				}
			}
		}
		if (null == errorMessage) {
			errorMessage = new ErrorMessage(ErrorMessageCode.SYSTEM.UNEXPECTED_ERROR_MESSAGE_CODE, ErrorMessageCode.SYSTEM.UNEXPECTED_ERROR_MESSAGE_MSG);
		}
		return errorMessage;
	}
}

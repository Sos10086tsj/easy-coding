package com.chinesedreamer.easycoding.util;

import javax.servlet.http.HttpServletRequest;

import com.chinesedreamer.easycoding.exception.ErrorMessageCode;
import com.chinesedreamer.easycoding.exception.system.SessionOverdueException;
import com.chinesedreamer.easycoding.web.filter.SessionFilter;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 17, 2016
**/
public class SessionUtil {
	
	public static String getSessionId() {
		HttpServletRequest request = SessionFilter.SessionContext.getContextRequest();
		if (null == request) {
			throw new SessionOverdueException(ErrorMessageCode.SYSTEM.SESSION_OVERDUE_MESSAGE, ErrorMessageCode.SYSTEM.SESSION_OVERDUE_CODE);
		}
		return request.getSession().getId();		
	}
	
	public static Long getUserId() {
		String sessionId = getSessionId();
		return SessionFilter.SessionContext.getContent().get(sessionId);
	}
	
	public static void addUserId(Long userId){
		SessionFilter.SessionContext.setContent(getSessionId(), userId);
	}
	
}

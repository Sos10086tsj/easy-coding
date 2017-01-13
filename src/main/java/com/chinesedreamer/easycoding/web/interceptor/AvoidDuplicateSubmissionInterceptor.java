package com.chinesedreamer.easycoding.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chinesedreamer.easycoding.common.annotation.AvoidDuplicateSubmission;
import com.chinesedreamer.easycoding.common.tools.TokenProcessor;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 25, 2016
**/
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter{
	private Logger logger = LoggerFactory.getLogger(AvoidDuplicateSubmissionInterceptor.class);
	protected String tokenKey = "duplicateToken";
	public String getTokenKey() {
		return tokenKey;
	}
	public void setTokenKey(String tokenKey) {
		this.tokenKey = tokenKey;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  
            throws Exception {  
        HandlerMethod handlerMethod = (HandlerMethod) handler;  
        Method method = handlerMethod.getMethod();  
  
        AvoidDuplicateSubmission annotation = method.getAnnotation(AvoidDuplicateSubmission.class);  
        if (null != annotation) {  
            boolean needSaveToken = annotation.needAddToken(); 
            if (needSaveToken) {  
            	this.logger.info("Token added.");
                request.getSession(false).setAttribute(this.tokenKey,  
                        TokenProcessor.getInstance().generateToken(request));  
            }  
  
            boolean needRemoveToken = annotation.needRemoveToken();  
            if (needRemoveToken) {  
            	this.logger.info("Token removed.");
                if (isRepeatSubmit(request)) {
                	this.logger.info("RepeatSubmit.");
                    return false;  
                }  
                request.getSession(false).removeAttribute(this.tokenKey);   
            }  
        }  
        return true;  
    }
	
	private boolean isRepeatSubmit(HttpServletRequest request) {  
        String serverToken = (String) request.getSession(false).getAttribute(this.tokenKey);  
        if (null == serverToken) {  
            return true;  
        }  
  
        String clientToken = request.getParameter(this.tokenKey);  
        if (null == clientToken) {  
            return true;  
        }  
  
        if (!serverToken.equals(clientToken)) {  
            return true;  
        }  
  
        return false;  
    }
}

package com.chinesedreamer.easycoding.web.filter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinesedreamer.easycoding.constant.ApplicationConstant;
import com.chinesedreamer.easycoding.util.PropertiesUtil;
import com.chinesedreamer.easycoding.util.SessionUtil;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 17, 2016
**/
public class SessionFilter implements Filter{
	private Logger logger = LoggerFactory.getLogger("EC");
	
	private static List<String> ignoreUris = new ArrayList<String>();
	private static void initIgnoreUris() {
		PropertiesUtil pu = new PropertiesUtil(ApplicationConstant.APPLICATION_PROPERTY_FILE);
		String types = pu.getProperty(ApplicationConstant.PROPERTY_SESSION_FILTER_IGNORE);
		for (String type : types.split(",")) {
			ignoreUris.add(type);
		}
	}
	private static List<String> getIgnoreUris() {
		if (null == ignoreUris || ignoreUris.isEmpty()) {
			initIgnoreUris();
		}
		return ignoreUris;
	}
	
	private static List<String> whiteUris = new ArrayList<String>();
	private static void initWhiteUris() {
		PropertiesUtil pu = new PropertiesUtil(ApplicationConstant.APPLICATION_PROPERTY_FILE);
		String types = pu.getProperty(ApplicationConstant.PROPERTY_SESSION_FILTER_WHITE_URL);
		for (String type : types.split(",")) {
			whiteUris.add(type);
		}
	}
	private static List<String> getWhiteUris() {
		if (null == whiteUris || whiteUris.isEmpty()) {
			initWhiteUris();
		}
		return whiteUris;
	}
	
	private boolean isWhiteUri(String uri){
		List<String> whiteList = getWhiteUris();
		if (null == whiteList || whiteList.isEmpty() ) {
			return false;
		}else {
			for (String wl : whiteList) {
				if (uri.equals(wl)) {
					return true;
				}
				if (wl.endsWith("*")) {
					int index = wl.indexOf("*");
					String patternUri = wl.substring(0, index);
					if (uri.length() >= patternUri.length() && uri.substring(0, index).equals(patternUri)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static class SessionContext implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -2429316837819807679L;
		
		public static ThreadLocal<HttpServletRequest> contentRequest = new ThreadLocal<HttpServletRequest>();
		public static ConcurrentHashMap<String, Long> content = new ConcurrentHashMap<String, Long>();
		
		/*http 维护 */
		public static HttpServletRequest getContextRequest(){
			return contentRequest.get();
		}
		public static void setContextRequest(HttpServletRequest request){
			contentRequest.set(request);
		}   
		public static void cleanContextRequest(){   
			contentRequest.set(null);
		}
		
		/*content维护*/
		public static ConcurrentHashMap<String, Long> getContent(){
			return content;
		}
		public static void setContent(String key, Long value){
			content.put(key, value);
		}
		public static void cleanContext(){   
			content.clear();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String uri = httpServletRequest.getServletPath();
		PropertiesUtil pu = new PropertiesUtil(ApplicationConstant.APPLICATION_PROPERTY_FILE);
		String loginUrl = pu.getProperty(ApplicationConstant.PROPERTY_SESSION_FILTER_LOGIN_URL);
		
		SessionContext.setContextRequest(httpServletRequest);
		if (StringUtils.isNotEmpty(uri)) {
			if (uri.equals(loginUrl)) {
				chain.doFilter(request, response);
			}else if (this.isWhiteUri(uri)) {
				chain.doFilter(request, response);
			}else {
				int index = uri.lastIndexOf(".");
				if (index != -1) {
					String type = uri.substring(index);
					if (getIgnoreUris().contains(type)) {
						chain.doFilter(request, response);
					}else {
						try {
							if (null == SessionUtil.getUserId()) {
								request.getRequestDispatcher(loginUrl).forward(request, response);
								return;
							}
						} catch (Exception e) {
							logger.error("{}",e);
							request.getRequestDispatcher(loginUrl).forward(request, response);
							return;
						}
						chain.doFilter(request, response);
					}
				}else {
					try {
						if (null == SessionUtil.getUserId()) {
							request.getRequestDispatcher(loginUrl).forward(request, response);
							return;
						}
					} catch (Exception e) {
						logger.error("{}",e);
						request.getRequestDispatcher(loginUrl).forward(request, response);
						return;
					}
					chain.doFilter(request, response);
				}
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}

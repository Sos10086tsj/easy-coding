package com.chinesedreamer.easycoding.constant;
/**
 * Description:
 * Auth:Paris
 * Date:Nov 17, 2016
**/
public class ApplicationConstant {
	public static final String SESSION_SESSIONID_KEY = "sessionId";
	public static final String SESSION_USERID_KEY = "userId";
	
	public static final String APPLICATION_PROPERTY_FILE = "application.properties";
	public static final String PROPERTY_FILE_UPLOAD_ROOT_KEY = "file.upload.root";
	public static final String PROPERTY_SESSION_FILTER_LOGIN_URL = "session.filter.login.url";
	public static final String PROPERTY_SESSION_OVERDUE_URL = "session.overdue.url";
	public static final String PROPERTY_SESSION_FILTER_IGNORE = "session.filter.ignore.type";
	public static final String PROPERTY_SESSION_FILTER_WHITE_URL = "session.filter.white.url";
	
	public static class USER {
		public static final int SALT_LENGTH = 6;
	}
}

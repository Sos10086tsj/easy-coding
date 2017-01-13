package com.chinesedreamer.easycoding.domain.constant;
/**
 * Description:
 * Auth:Paris
 * Date:Jan 13, 2017
**/
public enum UserRegisterStatus {
	VALID(0),
	INVALID(1);
	private final Integer status;
	
	private UserRegisterStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
	public static UserRegisterStatus get(int status) {
		for (UserRegisterStatus urs : UserRegisterStatus.values()) {
			if (urs.getStatus().intValue() == status) {
				return urs;
			}
		}
		return null;
	}
}

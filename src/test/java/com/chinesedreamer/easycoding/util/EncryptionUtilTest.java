package com.chinesedreamer.easycoding.util;

import org.junit.Test;

import com.chinesedreamer.easycoding.constant.ApplicationConstant;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 10, 2017
**/
public class EncryptionUtilTest {

	@Test
	public void testMd5L32StringString() {
		String salt = IdUtil.generateSalt(ApplicationConstant.USER.SALT_LENGTH);
		String pass = "123456";
		String md5 = EncryptionUtil.md5L32(pass + salt);
		System.out.println("密码：" + pass + "    盐值：" + salt);
		System.out.println("md5：" + md5);
	}

}

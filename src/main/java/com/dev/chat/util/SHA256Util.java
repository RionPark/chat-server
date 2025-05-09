package com.dev.chat.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {

	private static final String SALT = "3213213213213132132103203210";
	
	public static String encodePwd(String pwd) {
		return DigestUtils.sha256Hex(pwd + SALT);
	}
	
	public static void main(String[] args) {
		String pwd = "12345678";
		String encode = SHA256Util.encodePwd(pwd);
		System.out.println(encode);
	}
}

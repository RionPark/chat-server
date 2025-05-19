package com.dev.chat.util;

import java.util.Date;

import org.springframework.stereotype.Component;
import com.dev.chat.controller.UserController;
import com.dev.chat.vo.UserVO;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	private final String KEY = "asdfasdfasd321321321321sdffasdfasdfasdfsda";
	private final long MAX = 3600000 * 24;
	
	public String getToken(UserVO user) {
		Date now = new Date();
		Date maxDate = new Date(now.getTime() + MAX);
		String token = Jwts.builder()
				.subject(user.getUiId())
				.issuedAt(now)
				.expiration(maxDate)
				.signWith(Keys.hmacShaKeyFor(KEY.getBytes()))
				.compact();
		return token;
	}
	
	public String getUiId(String token) {
		return Jwts.parser()
				.verifyWith(Keys.hmacShaKeyFor(KEY.getBytes()))
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	public boolean validToken(String token) {
		try {
			Jwts.parser()
			.verifyWith(Keys.hmacShaKeyFor(KEY.getBytes()))
			.build()
			.parseSignedClaims(token);
		}catch(JwtException jwte) {
			jwte.printStackTrace();
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		JWTUtil jwt = new JWTUtil();
		UserVO user = new UserVO();
		user.setUiId("test");
		String token = jwt.getToken(user);
		System.out.println(token);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean isValid = jwt.validToken(token);
		System.out.println(isValid);
		String uiId = jwt.getUiId(token);
		System.out.println(uiId);
	}
}

package com.dev.chat.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.dev.chat.util.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor{
	@Autowired
	private JWTUtil jwtUitl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String method = request.getMethod();
		log.info(request.getRequestURI());
		if("OPTIONS".equals(method)) {
			return true;
		}
		String jwt = request.getHeader("Authorization");
		if(jwt == null || !jwt.startsWith("Bearer")) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		String token = jwt.substring(7);

		if(!jwtUitl.validToken(token)) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}
		return true;
	}
	
}

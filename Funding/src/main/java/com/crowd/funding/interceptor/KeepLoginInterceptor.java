package com.crowd.funding.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.crowd.funding.member.model.memberDTO;
import com.crowd.funding.member.service.memberService;

public class KeepLoginInterceptor extends HandlerInterceptorAdapter{


	
	@Inject
	private memberService memService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("#### KeepLoginInterceptor interceptor pre #####");
		HttpSession http = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		if(loginCookie!=null) {
			System.out.println("쿠키가지고 있음");
			memberDTO memDTO = memService.checkSessionKey(loginCookie.getValue());
			
			if(memDTO!=null) {
				http.setAttribute("login", memDTO);
			}
		}
		
		return true;
	}

}

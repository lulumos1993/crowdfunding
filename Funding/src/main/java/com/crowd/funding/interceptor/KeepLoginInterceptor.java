package com.crowd.funding.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.crowd.funding.maker.model.makerDTO;
import com.crowd.funding.maker.service.makerService;
import com.crowd.funding.member.model.memberDTO;
import com.crowd.funding.member.service.memberService;

public class KeepLoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private memberService memService;
	
	@Inject
	private makerService maService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler )
			throws Exception {
		System.out.println("#### KeepLoginInterceptor interceptor pre #####");
		HttpSession http = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		if (loginCookie != null) {
			System.out.println("쿠키가지고 있음");
			memberDTO memDTO = memService.checkSessionKey(loginCookie.getValue());
			
			
			
			if (memDTO != null) {
				http.setAttribute("login", memDTO);
				http.setAttribute("mem_idx", memDTO.getMem_idx());
				
				/*
				 * int idx = maService.idx(memDTO.getMem_idx());
				 * 
				 * if(idx=='0') { int maker_idx = maService.makeridx(memDTO.getMem_idx());
				 * makerDTO maDTO = maService.makerinfo(maker_idx); http.setAttribute("maker",
				 * maDTO); http.setAttribute("maker_idx", maDTO.getMaker_idx()); }else {
				 * response.sendRedirect("/funding"); return false; }
				 */
			}
		}

		return true;
	}

	
}

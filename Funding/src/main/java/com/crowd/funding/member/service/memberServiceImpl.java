package com.crowd.funding.member.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.member.model.loginDTO;
import com.crowd.funding.member.model.memberDAO;
import com.crowd.funding.member.model.memberDTO;

@Service
public class memberServiceImpl implements memberService {
	
	@Inject
	memberDAO memDAO;

	@Override
	public void joinPOST(memberDTO memDTO) throws Exception {
		System.out.println("##### memberService : joinPOST #####");
		memDAO.joinPOST(memDTO);
	}

	@Override
	public memberDTO loginPOST(loginDTO logDTO) throws Exception {
		System.out.println("##### memberService : loginPOST #####");
		return memDAO.loginPOST(logDTO);
	}

	@Override
	public void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception {
		System.out.println("##### memberService : keepLogin #####");
		memDAO.keepLogin(mem_email, sessionid, sessionlimit);
		
	}

	@Override
	public memberDTO checkSessionKey(String value) throws Exception {
		System.out.println("##### memberService : checkSessionKey #####");
		return memDAO.checkSessionKey(value);
	}
	
	
	
	

}

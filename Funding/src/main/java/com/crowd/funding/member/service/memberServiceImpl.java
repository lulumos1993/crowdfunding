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
	public void lastLogin(String mem_email, Date lastLogin) throws Exception {
		System.out.println("##### memberService : lastLogin #####");
		memDAO.lastLogin(mem_email, lastLogin);
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

	@Override
	public memberDTO myinfo(int mem_idx) throws Exception {
		System.out.println("##### memberService : myinfo #####");
		return memDAO.myinfo(mem_idx);
	}

	@Override
	public void myinfoUP(memberDTO memDTO) throws Exception {
		System.out.println("##### memberService : myinfoUP #####");
		memDAO.myinfoUP(memDTO);
	}

	@Override
	public void myinfoDEL(int mem_idx) throws Exception {
		System.out.println("##### memberService : myinfoDEL #####");
		memDAO.myinfoDEL(mem_idx);
	}
	
	
	
	
	
	

}

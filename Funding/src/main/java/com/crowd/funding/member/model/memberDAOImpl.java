package com.crowd.funding.member.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class memberDAOImpl implements memberDAO {
	
	@Inject
	SqlSession sql;

	@Override
	public void joinPOST(memberDTO memDTO) throws Exception {
		System.out.println("##### memberDAO : joinPOST #####");
		sql.insert("member.join",memDTO);
	}

	@Override
	public memberDTO loginPOST(loginDTO logDTO) throws Exception {
		System.out.println("##### memberDAO : loginPOST #####");
		return sql.selectOne("member.login", logDTO);
	}
	
	@Override
	public void lastLogin(String mem_email, Date lastLogin) throws Exception {
		System.out.println("##### memberDAO : lastLogin #####");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("lastLogin", lastLogin);
		
		sql.update("member.lastLogin", paramMap);
	}

	@Override
	public void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception {
		System.out.println("##### memberDAO : keepLogin #####");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("sessionid", sessionid);
		paramMap.put("sessionlimit", sessionlimit);
		
		sql.update("member.keepLogin", paramMap);
	}

	@Override
	public memberDTO checkSessionKey(String value) throws Exception {
		System.out.println("##### memberDAO : checkSessionKey #####");
		return sql.selectOne("member.checkSessionKey", value);
	}

	@Override
	public memberDTO myinfo(int mem_idx) throws Exception {
		System.out.println("##### memberDAO : myinfo #####");
		return sql.selectOne("member.myinfo", mem_idx);
	}

	@Override
	public void myinfoUP(memberDTO memDTO) throws Exception {
		System.out.println("##### memberDAO : myinfoUP #####");
		sql.selectOne("member.myinfo_up", memDTO);
	}

	@Override
	public void myinfoDEL(int mem_idx) throws Exception {
		System.out.println("##### memberDAO : myinfoDEL #####");
		sql.update("member.myinfo_del", mem_idx);
	}
	
	

	

	
	
}

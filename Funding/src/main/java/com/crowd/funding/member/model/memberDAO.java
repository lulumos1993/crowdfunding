package com.crowd.funding.member.model;

import java.util.Date;

public interface memberDAO {

	void joinPOST(memberDTO memDTO) throws Exception;

	memberDTO loginPOST(loginDTO logDTO) throws Exception;

	// 로그인 유지 처리
	void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception;

	// 세션키 검증
	memberDTO checkSessionKey(String value) throws Exception;

}

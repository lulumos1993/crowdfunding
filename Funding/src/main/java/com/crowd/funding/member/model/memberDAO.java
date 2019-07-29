package com.crowd.funding.member.model;

import java.util.Date;

public interface memberDAO {

	void joinPOST(memberDTO memDTO) throws Exception;

	memberDTO loginPOST(loginDTO logDTO) throws Exception;

	// 마지막 로그인 시간 저장
	void lastLogin(String mem_email, Date lastLogin) throws Exception;

	// 로그인 유지 처리
	void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception;

	// 세션키 검증
	memberDTO checkSessionKey(String value) throws Exception;

	// 내정보
	memberDTO myinfo(int mem_idx) throws Exception;

	// 내정보 - 수정
	void myinfoUP(memberDTO memDTO) throws Exception;

	// 내정보 - 삭제(탈퇴요청)
	void myinfoDEL(int mem_idx) throws Exception;

}

package com.crowd.funding.member.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.crowd.funding.member.MailHandler;
import com.crowd.funding.member.TempKey;
import com.crowd.funding.member.model.loginDTO;
import com.crowd.funding.member.model.memberDAO;
import com.crowd.funding.member.model.memberDTO;

@Service
public class memberServiceImpl implements memberService {

	@Inject
	memberDAO memDAO;
	@Inject
	private JavaMailSender mailSender;

	@Override
	public void joinPOST(memberDTO memDTO) throws Exception {
		System.out.println("##### memberService : joinPOST #####");
		memDAO.joinPOST(memDTO);
		
		//인증키 생성
		String email_key = new TempKey().getKey(50, false);
		memDAO.creatKey(memDTO.getMem_email(), email_key);
		
		//eamil 발송
		MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[이메일 인증]");
			sendMail.setText(new StringBuffer().append("<h1>메일인증</h1>")
						.append("<a href='http://localhost:8080/funding/user/emailConfirm?mem_email="+memDTO.getMem_email())
						.append("&email_key="+ email_key + "' target='_blank'>이메일 인증</a>").toString());
			sendMail.setFrom("lulumos1993@gmail.com", "페퍼민트");
			sendMail.setTo(memDTO.getMem_email());
			sendMail.send();
				
				System.out.println("----------------email_key : " + email_key);
	}


	@Override
	public int chkKey(String mem_email,int email_type) throws Exception {
		
		return memDAO.chkKey(mem_email, email_type);
	}


	@Override
	public void emailAuth(String mem_email, String email_key) throws Exception {
		memDAO.emailAuth(mem_email,email_key);
		
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


	@Override
	public int userfindID(String find) throws Exception {
		System.out.println("##### memberService : userfindID #####");
		return memDAO.userfindID(find);
	}


	@Override
	public void userfindPW(String find) throws Exception {
		
		//인증키 생성
		String email_key = new TempKey().getKey(50, false);
		memDAO.userfindPW(find,email_key);
				
		//eamil 발송
		MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[비밀번호 재설정 안내]");
			sendMail.setText(new StringBuffer().append("<h1>비밀번호 변경</h1>")
					.append("<a href='http://localhost:8080/funding/user/resetpw?mem_email="+find)
					.append("&email_key="+ email_key + "' target='_blank'>비밀번호 변경</a>").toString());
			sendMail.setFrom("lulumos1993@gmail.com", "페퍼민트");
			sendMail.setTo(find);
			sendMail.send();
			
			System.out.println("메일발송 완료");
							
	}


	@Override
	public void resetPW(String mem_password, String mem_email, String email_key) throws Exception {
		memDAO.resetPW(mem_password, mem_email, email_key);	
	}
	
	
	
	
	
	

}

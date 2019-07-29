package com.crowd.funding.member.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.crowd.funding.member.model.loginDTO;
import com.crowd.funding.member.model.memberDTO;
import com.crowd.funding.member.service.memberService;

@Controller
@RequestMapping(value = "/user")
public class memberController {

	@Inject
	protected memberService memService;

	// 회원가입 페이지로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinGET() throws Exception {
		return "user/user_join";
	}

	// 회원가입 처리
	@RequestMapping(value = "/joinPOST", method = RequestMethod.POST)
	public String joinPOST(memberDTO memDTO, RedirectAttributes redirect) throws Exception {

		// pw암호화 : BCrypt.hashpw(암호화할 비밀번호, 암호화된 비밀번호);
		String hashedPW = BCrypt.hashpw(memDTO.getMem_password(), BCrypt.gensalt());
		memDTO.setMem_password(hashedPW);

		memService.joinPOST(memDTO);
		redirect.addFlashAttribute("msg", "registered");

		return "redirect:/user/login";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET() throws Exception {
		return "user/login";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/loginPOST", method = RequestMethod.GET)
	public String loginPOST() throws Exception {
		return "user/loginPOST";
	}

	// 로그인 처리
	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public void loginPOST(loginDTO logDTO, HttpSession http, Model model) throws Exception {
		// login 뷰에서 받은 데이터를 memDTO에 담는다.
		memberDTO memDTO = memService.loginPOST(logDTO);

		System.out.println("##### 로그인 시도");
		System.out.println("### 아이디 : " + logDTO.getMem_email());
		System.out.println("### 비밀번호 : " + logDTO.getMem_password());

		// 아이디가 없거나, 비밀번호가 불일치 하면 메서드 종료
		if (memDTO == null) {
			System.out.println("### 아이디가 DB에 없다.");
			return;
		} else if (memDTO != null) {
			if (!BCrypt.checkpw(logDTO.getMem_password(), memDTO.getMem_password())) {
				System.out.println("### 비밀번호 불일치");
				return;
			}
			System.out.println("로그인 성공");
		}

		// login 뷰에서 받은 데이터를 memDTO에 담는다. -> mem에 저장
		model.addAttribute("mem", memDTO);

		// 자동로그인을 선택한 경우
		if (logDTO.isUseCookie()) {
			System.out.println("자동로그인 선택함");
			int amount = 60 * 60 * 24 * 3; // 3일동안 쿠키 유지
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			memService.keepLogin(memDTO.getMem_email(), http.getId(), sessionLimit);
		}

		// 마지막 로그인 시간 업데이트
		memService.lastLogin(memDTO.getMem_email(), new Date());

	}

	// 로그아웃 처리
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession http) throws Exception {
		Object ob = http.getAttribute("login");

		if (ob != null) {
			memberDTO memDTO = (memberDTO) ob;
			http.removeAttribute("login");
			http.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {

				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				memService.keepLogin(memDTO.getMem_email(), "none", new Date());
			}
		}

		return "/user/logout";
	}

	// myinfo페이지 이동
	@RequestMapping(value = "/myinfo")
	public String myinfoGET(@RequestParam int mem_idx, Model model) throws Exception {

		model.addAttribute("myinfo", memService.myinfo(mem_idx));
		return "user/myinfo";
	}

	// myinfo - 수정
	@RequestMapping(value = "/myinfo_up")
	public String myinfoUP(@ModelAttribute memberDTO memDTO, Model model) throws Exception {
		System.out.println("%%% 회원번호 : " + memDTO.getMem_idx() + " 수정 %%%");

		// 수정 전 정보
		memberDTO memDTOpre = memService.myinfo(memDTO.getMem_idx());

		// 비밀번호 일치 확인
		if (BCrypt.checkpw(memDTOpre.getMem_password(), memDTO.getMem_password())) {
		}

		// pw암호화 : BCrypt.hashpw(암호화할 비밀번호, 암호화된 비밀번호);
		String hashedPW = BCrypt.hashpw(memDTO.getMem_password(), BCrypt.gensalt());
		memDTO.setMem_password(hashedPW);

		memService.myinfoUP(memDTO);
		return "redirect:/user/myinfo?mem_idx=" + memDTO.getMem_idx();
	}

	// myinfo - 삭제
	@RequestMapping(value = "/myinfo_del")
	public String myinfoDEL(@RequestParam int mem_idx) throws Exception {
		System.out.println("%%% 회원번호 : " + mem_idx + " 탈퇴요청 %%%");
		// 비밀번호 일치 확인
		// 진행중인 펀딩이 있는지? 확인후 진행
		// 참가중인 펀딩이 있는지 ? 확인후 진행
		memService.myinfoDEL(mem_idx);
		return "redirect:/user/logout";
	}

}

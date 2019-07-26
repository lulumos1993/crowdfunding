package com.crowd.funding.member.model;

public class loginDTO {
	
	//로그인 view의 정보
	private String mem_email;
	private String mem_password;
	private boolean useCookie;
	
	
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "loginDTO [mem_email=" + mem_email + ", mem_password=" + mem_password + ", useCookie=" + useCookie + "]";
	}
	
	

}

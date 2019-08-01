package com.crowd.funding.member.model;

public class emailDTO {
	
	private int email_idx;
	private int email_type;
	private String email_key;
	private String mem_email;
	
	public int getEmail_idx() {
		return email_idx;
	}
	public void setEmail_idx(int email_idx) {
		this.email_idx = email_idx;
	}
	public int getEmail_type() {
		return email_type;
	}
	public void setEmail_type(int email_type) {
		this.email_type = email_type;
	}
	public String getEmail_key() {
		return email_key;
	}
	public void setEmail_key(String email_key) {
		this.email_key = email_key;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	
	

}

package com.crowd.funding.member.model;

import java.util.Date;

public class memberDTO {

	// 회원가입시 받을 최소 정보
	private int mem_idx;
	private int mem_type;
	private String mem_email;
	private String mem_password;
	private String mem_name;
	private String mem_phone;
	private int mem_birth;
	private int mem_sex;

	private int mem_email_cert;
	private Date mem_register_datetime;
	private Date mem_lastlogin_datetime;

	//
	private int mem_zipcode;
	private String mem_address1;
	private String mem_address2;
	private String mem_address3;
	private String mem_address4;
	private String mem_photo; // 기본이미지 default로 추가해주기

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public int getMem_type() {
		return mem_type;
	}

	public void setMem_type(int mem_type) {
		this.mem_type = mem_type;
	}

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

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public int getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(int mem_birth) {
		this.mem_birth = mem_birth;
	}

	public int getMem_sex() {
		return mem_sex;
	}

	public void setMem_sex(int mem_sex) {
		this.mem_sex = mem_sex;
	}

	public int getMem_email_cert() {
		return mem_email_cert;
	}

	public void setMem_email_cert(int mem_email_cert) {
		this.mem_email_cert = mem_email_cert;
	}

	public Date getMem_register_datetime() {
		return mem_register_datetime;
	}

	public void setMem_register_datetime(Date mem_register_datetime) {
		this.mem_register_datetime = mem_register_datetime;
	}

	public Date getMem_lastlogin_datetime() {
		return mem_lastlogin_datetime;
	}

	public void setMem_lastlogin_datetime(Date mem_lastlogin_datetime) {
		this.mem_lastlogin_datetime = mem_lastlogin_datetime;
	}

	public int getMem_zipcode() {
		return mem_zipcode;
	}

	public void setMem_zipcode(int mem_zipcode) {
		this.mem_zipcode = mem_zipcode;
	}

	public String getMem_address1() {
		return mem_address1;
	}

	public void setMem_address1(String mem_address1) {
		this.mem_address1 = mem_address1;
	}

	public String getMem_address2() {
		return mem_address2;
	}

	public void setMem_address2(String mem_address2) {
		this.mem_address2 = mem_address2;
	}

	public String getMem_address3() {
		return mem_address3;
	}

	public void setMem_address3(String mem_address3) {
		this.mem_address3 = mem_address3;
	}

	public String getMem_address4() {
		return mem_address4;
	}

	public void setMem_address4(String mem_address4) {
		this.mem_address4 = mem_address4;
	}

	public String getMem_photo() {
		return mem_photo;
	}

	public void setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
	}

	@Override
	public String toString() {
		return "memberDTO [mem_idx=" + mem_idx + ", mem_type=" + mem_type + ", mem_email=" + mem_email
				+ ", mem_password=" + mem_password + ", mem_name=" + mem_name + ", mem_phone=" + mem_phone
				+ ", mem_birth=" + mem_birth + ", mem_sex=" + mem_sex + ", mem_email_cert=" + mem_email_cert
				+ ", mem_register_datetime=" + mem_register_datetime + ", mem_lastlogin_datetime="
				+ mem_lastlogin_datetime + ", mem_zipcode=" + mem_zipcode + ", mem_address1=" + mem_address1
				+ ", mem_address2=" + mem_address2 + ", mem_address3=" + mem_address3 + ", mem_address4=" + mem_address4
				+ ", mem_photo=" + mem_photo + "]";
	}

}

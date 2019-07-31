package com.crowd.funding.maker.model;

public class makerDTO {
	
	private int maker_idx;
	private String maker_name;
	private String maker_phone;
	
	private int maker_zipcode;
	private String maker_address1;
	private String maker_address2;
	private String maker_address3;
	private String maker_address4;
	
	private String maker_intro;
	private String maker_photo;
	
	private int mem_idx;
	
	
	
	
	public int getMaker_idx() {
		return maker_idx;
	}
	public void setMaker_idx(int maker_idx) {
		this.maker_idx = maker_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMaker_name() {
		return maker_name;
	}
	public void setMaker_name(String maker_name) {
		this.maker_name = maker_name;
	}
	public String getMaker_phone() {
		return maker_phone;
	}
	public void setMaker_phone(String maker_phone) {
		this.maker_phone = maker_phone;
	}
	public int getMaker_zipcode() {
		return maker_zipcode;
	}
	public void setMaker_zipcode(int maker_zipcode) {
		this.maker_zipcode = maker_zipcode;
	}
	public String getMaker_address1() {
		return maker_address1;
	}
	public void setMaker_address1(String maker_address1) {
		this.maker_address1 = maker_address1;
	}
	public String getMaker_address2() {
		return maker_address2;
	}
	public void setMaker_address2(String maker_address2) {
		this.maker_address2 = maker_address2;
	}
	public String getMaker_address3() {
		return maker_address3;
	}
	public void setMaker_address3(String maker_address3) {
		this.maker_address3 = maker_address3;
	}
	public String getMaker_address4() {
		return maker_address4;
	}
	public void setMaker_address4(String maker_address4) {
		this.maker_address4 = maker_address4;
	}
	public String getMaker_intro() {
		return maker_intro;
	}
	public void setMaker_intro(String maker_intro) {
		this.maker_intro = maker_intro;
	}
	public String getMaker_photo() {
		return maker_photo;
	}
	public void setMaker_photo(String maker_photo) {
		this.maker_photo = maker_photo;
	}
	@Override
	public String toString() {
		return "makerDTO [maker_idx=" + maker_idx + ", maker_name=" + maker_name + ", maker_phone=" + maker_phone
				+ ", maker_zipcode=" + maker_zipcode + ", maker_address1=" + maker_address1 + ", maker_address2="
				+ maker_address2 + ", maker_address3=" + maker_address3 + ", maker_address4=" + maker_address4
				+ ", maker_intro=" + maker_intro + ", maker_photo=" + maker_photo + ", mem_idx=" + mem_idx + "]";
	}

	
	

	
	

}

package com.spring.exam.beans;

public class MemberBean {
	private String mem_car;
	private String name;
	private String phone;
	
	
	@Override
	public String toString() {
		return "MemberBean [mem_car=" + mem_car + ", name=" + name + ", phone=" + phone + "]";
	}
	public String getMem_car() {
		return mem_car;
	}
	public void setMem_car(String mem_car) {
		this.mem_car = mem_car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}

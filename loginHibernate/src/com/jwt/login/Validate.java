package com.jwt.login;

public class Validate{
	private int id;
	private String userid;
	private String email;
	private String pass;
	private long mobile_no;
	private int profile;
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setUserid(String userid) {
		this.userid=userid;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	
	public void setMobile(long mobile_no) {
		this.mobile_no=mobile_no;
	}
	
	public void setProfile(int profile){
		this.profile=profile;
	}
	
	public int getId(){
		return id;
	}
	
	public String getUserid() {
		return userid;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	
	public long getMobile() {
		return mobile_no;
	}
	
	public int getProfile(){
		return profile;
	}
}
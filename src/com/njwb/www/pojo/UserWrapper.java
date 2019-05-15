package com.njwb.www.pojo;

import java.util.Date;
/**
 * 用户组合类
 * @author soft02
 *
 */
public class UserWrapper {
	private int uId;
	private String uAccount;
	private String uPassword;
	private String uName;
	private String uPhoneNumber;
	private int uPId;
	private Province province;
	private int uState;
	private int uRole;
	private int uPhoneBalance;
	private int uJoyBeanBalance;
	private Date uCreateTime;
	
	public UserWrapper() {
		super();
	}

	public UserWrapper(int uId, String uAccount, String uPassword, String uName, String uPhoneNumber, int uPId, Province province, int uState, int uRole, int uPhoneBalance, int uJoyBeanBalance, Date uCreateTime) {
		super();
		this.uId = uId;
		this.uAccount = uAccount;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uPhoneNumber = uPhoneNumber;
		this.uPId = uPId;
		this.province = province;
		this.uState = uState;
		this.uRole = uRole;
		this.uPhoneBalance = uPhoneBalance;
		this.uJoyBeanBalance = uJoyBeanBalance;
		this.uCreateTime = uCreateTime;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuAccount() {
		return uAccount;
	}

	public void setuAccount(String uAccount) {
		this.uAccount = uAccount;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoneNumber() {
		return uPhoneNumber;
	}

	public void setuPhoneNumber(String uPhoneNumber) {
		this.uPhoneNumber = uPhoneNumber;
	}
	
	public int getuPId() {
		return uPId;
	}

	public void setuPId(int uPId) {
		this.uPId = uPId;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public int getuState() {
		return uState;
	}

	public void setuState(int uState) {
		this.uState = uState;
	}

	public int getuRole() {
		return uRole;
	}

	public void setuRole(int uRole) {
		this.uRole = uRole;
	}

	public int getuPhoneBalance() {
		return uPhoneBalance;
	}

	public void setuPhoneBalance(int uPhoneBalance) {
		this.uPhoneBalance = uPhoneBalance;
	}

	public int getuJoyBeanBalance() {
		return uJoyBeanBalance;
	}

	public void setuJoyBeanBalance(int uJoyBeanBalance) {
		this.uJoyBeanBalance = uJoyBeanBalance;
	}

	public Date getuCreateTime() {
		return uCreateTime;
	}

	public void setuCreateTime(Date uCreateTime) {
		this.uCreateTime = uCreateTime;
	}

	@Override
	public String toString() {
		return "用户编号："+uId+",用户账号："+uAccount+",用户密码："+uPassword+",用户姓名："+uName+",手机号码："+uPhoneNumber+",省份编号："+uPId+",用户状态："+uState
				+",用户角色："+uRole+",话费余额："+uPhoneBalance+",乐豆余额："+uJoyBeanBalance+",创建时间："+uCreateTime+",省份：["+province+"]";
	}
	
	
	

}

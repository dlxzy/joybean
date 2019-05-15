package com.njwb.www.pojo;

import java.util.Date;

public class ExpendRecord {
	private int erId;
	private int erGId;
	private int erConsumeAmount;
	private int erPurchaseWays;
	private int erGiftJoybeanAmount;
	private int erUId;
	private Date erPurchaseTime;
	
	public ExpendRecord() {
		super();
	}

	public ExpendRecord(int erGId, int erPurchaseWays, int erUId) {
		super();
		this.erGId = erGId;
		this.erPurchaseWays = erPurchaseWays;
		this.erUId = erUId;
	}
	
	public ExpendRecord(int erGId, int erConsumeAmount, int erPurchaseWays, int erGiftJoybeanAmount, int erUId) {
		super();
		this.erGId = erGId;
		this.erConsumeAmount = erConsumeAmount;
		this.erPurchaseWays = erPurchaseWays;
		this.erGiftJoybeanAmount = erGiftJoybeanAmount;
		this.erUId = erUId;
	}

	public int getErId() {
		return erId;
	}

	public void setErId(int erId) {
		this.erId = erId;
	}

	public int getErGId() {
		return erGId;
	}

	public void setErGId(int erGId) {
		this.erGId = erGId;
	}

	public int getErConsumeAmount() {
		return erConsumeAmount;
	}

	public void setErConsumeAmount(int erConsumeAmount) {
		this.erConsumeAmount = erConsumeAmount;
	}

	public int getErPurchaseWays() {
		return erPurchaseWays;
	}

	public void setErPurchaseWays(int erPurchaseWays) {
		this.erPurchaseWays = erPurchaseWays;
	}

	public int getErGiftJoybeanAmount() {
		return erGiftJoybeanAmount;
	}

	public void setErGiftJoybeanAmount(int erGiftJoybeanAmount) {
		this.erGiftJoybeanAmount = erGiftJoybeanAmount;
	}

	public int getErUId() {
		return erUId;
	}

	public void setErUId(int erUId) {
		this.erUId = erUId;
	}

	public Date getErPurchaseTime() {
		return erPurchaseTime;
	}

	public void setErPurchaseTime(Date erPurchaseTime) {
		this.erPurchaseTime = erPurchaseTime;
	}

	@Override
	public String toString() {
		return "消费记录编号："+erId+",游戏名称编号："+erGId+",消费金额："+erConsumeAmount+",购买方式："+erPurchaseWays+",赠送乐豆："+erGiftJoybeanAmount
				+",购买用户编号："+erUId+",购买时间："+erPurchaseTime;
	}
	
	
	
}

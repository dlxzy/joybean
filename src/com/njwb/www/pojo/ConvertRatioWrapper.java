package com.njwb.www.pojo;

import java.util.Date;

/**
 * 乐豆换算比例组合类
 * @author soft02
 *
 */
public class ConvertRatioWrapper {
	private int crId;
	private int crPId;
	private int crConsumeAmount;
	private Date crCreateTime;
	private Date crUpdateTime;
	private Province province;
	
	public ConvertRatioWrapper() {
		super();
	}

	public ConvertRatioWrapper(int crId, int crPId, int crConsumeAmount, Date crCreateTime, Date crUpdateTime, Province province) {
		super();
		this.crId = crId;
		this.crPId = crPId;
		this.crConsumeAmount = crConsumeAmount;
		this.crCreateTime = crCreateTime;
		this.crUpdateTime = crUpdateTime;
		this.province = province;
	}

	public int getCrId() {
		return crId;
	}

	public void setCrId(int crId) {
		this.crId = crId;
	}

	
	public int getCrPId() {
		return crPId;
	}

	public void setCrPId(int crPId) {
		this.crPId = crPId;
	}

	public int getCrConsumeAmount() {
		return crConsumeAmount;
	}

	public void setCrConsumeAmount(int crConsumeAmount) {
		this.crConsumeAmount = crConsumeAmount;
	}

	public Date getCrCreateTime() {
		return crCreateTime;
	}

	public void setCrCreateTime(Date crCreateTime) {
		this.crCreateTime = crCreateTime;
	}

	public Date getCrUpdateTime() {
		return crUpdateTime;
	}

	public void setCrUpdateTime(Date crUpdateTime) {
		this.crUpdateTime = crUpdateTime;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "乐豆换算比例编号："+crId+",省份编号："+crPId+",消费金额："+crConsumeAmount+",创建时间："+crCreateTime+",更新时间："+crUpdateTime+",省份：["+province+"]";
	}

	
	
	
	
}

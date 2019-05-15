package com.njwb.www.pojo;

import java.util.Date;
/**
 * 乐豆换算比例实体类
 * @author soft02
 *
 */
public class ConvertRatio {
	private int crId;
	private int crPId;
	private int crConsumeAmount;
	private Date crCreateTime;
	private Date crUpdateTime;
	
	public ConvertRatio() {
		super();
	}

	public ConvertRatio(int crId, int crPId, int crConsumeAmount, Date crCreateTime, Date crUpdateTime) {
		super();
		this.crId = crId;
		this.crPId = crPId;
		this.crConsumeAmount = crConsumeAmount;
		this.crCreateTime = crCreateTime;
		this.crUpdateTime = crUpdateTime;
	}

	public ConvertRatio(int crPId, int crConsumeAmount) {
		super();
		this.crPId = crPId;
		this.crConsumeAmount = crConsumeAmount;
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

	@Override
	public String toString() {
		return "乐豆换算比例编号："+crId+",省份编号："+crPId+",消费金额："+crConsumeAmount+",创建时间："+crCreateTime+",更新时间："+crUpdateTime;
	}

	
	
}

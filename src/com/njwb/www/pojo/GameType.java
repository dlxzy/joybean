package com.njwb.www.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 游戏类型实体类
 * @author soft02
 *
 */
public class GameType {
	private int gtId;
	private String gtName;
	private int gtState;
	private Date gtCreateTime;
	private Date gtUpdateTime;
	
	public GameType() {
		super();
	}
	
	public GameType(int gtId, String gtName, int gtState, Date gtCreateTime, Date gtUpdateTime) {
		super();
		this.gtId = gtId;
		this.gtName = gtName;
		this.gtState = gtState;
		this.gtCreateTime = gtCreateTime;
		this.gtUpdateTime = gtUpdateTime;
	}
	
	public GameType(String gtName, int gtState) {
		super();
		this.gtName = gtName;
		this.gtState = gtState;
	}

	public int getGtId() {
		return gtId;
	}

	public void setGtId(int gtId) {
		this.gtId = gtId;
	}

	public String getGtName() {
		return gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

	public int getGtState() {
		return gtState;
	}

	public void setGtState(int gtState) {
		this.gtState = gtState;
	}

	public Date getGtCreateTime() {
		return gtCreateTime;
	}

	public void setGtCreateTime(Date gtCreateTime) {
		this.gtCreateTime = gtCreateTime;
	}

	public Date getGtUpdateTime() {
		return gtUpdateTime;
	}

	public void setGtUpdateTime(Date gtUpdateTime) {
		this.gtUpdateTime = gtUpdateTime;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return "游戏类型编号："+gtId+",游戏类型名称："+gtName+",游戏类型状态："+gtState+",创建时间："+sdf.format(gtCreateTime)+",更新时间："+sdf.format(gtUpdateTime);
	}
	
	
	

}

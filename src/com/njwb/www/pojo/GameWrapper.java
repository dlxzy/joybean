package com.njwb.www.pojo;

import java.util.Date;
/**
 * 游戏组合类
 * @author soft02
 *
 */
public class GameWrapper {
	private int gId;
	private String gName;
	private int gGTId;
	private GameType gameType;
	private String gPicture;
	private int gState;
	private String gDetails;
	private int gJoybeanPrice;
	private int gPhonePrice;
	private Date gCreateTime;
	private int gCrId;
	private Date gUpdateTime;
	private int gUpId;
	
	public GameWrapper() {
		super();
	}

	public GameWrapper(int gId, String gName, int gGTId, GameType gameType, String gPicture, int gState, String gDetails, int gJoybeanPrice, int gPhonePrice, Date gCreateTime, int gCrId, Date gUpdateTime, int gUpId) {
		super();
		this.gId = gId;
		this.gName = gName;
		this.gGTId = gGTId;
		this.gameType = gameType;
		this.gPicture = gPicture;
		this.gState = gState;
		this.gDetails = gDetails;
		this.gJoybeanPrice = gJoybeanPrice;
		this.gPhonePrice = gPhonePrice;
		this.gCreateTime = gCreateTime;
		this.gCrId = gCrId;
		this.gUpdateTime = gUpdateTime;
		this.gUpId = gUpId;
	}

	public int getgId() {
		return gId;
	}

	public void setgId(int gId) {
		this.gId = gId;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getgGTId() {
		return gGTId;
	}

	public void setgGTId(int gGTId) {
		this.gGTId = gGTId;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getgPicture() {
		return gPicture;
	}

	public void setgPicture(String gPicture) {
		this.gPicture = gPicture;
	}

	public int getgState() {
		return gState;
	}

	public void setgState(int gState) {
		this.gState = gState;
	}

	public String getgDetails() {
		return gDetails;
	}

	public void setgDetails(String gDetails) {
		this.gDetails = gDetails;
	}

	public int getgJoybeanPrice() {
		return gJoybeanPrice;
	}

	public void setgJoybeanPrice(int gJoybeanPrice) {
		this.gJoybeanPrice = gJoybeanPrice;
	}

	public int getgPhonePrice() {
		return gPhonePrice;
	}

	public void setgPhonePrice(int gPhonePrice) {
		this.gPhonePrice = gPhonePrice;
	}

	public Date getgCreateTime() {
		return gCreateTime;
	}

	public void setgCreateTime(Date gCreateTime) {
		this.gCreateTime = gCreateTime;
	}

	public int getgCrId() {
		return gCrId;
	}

	public void setgCrId(int gCrId) {
		this.gCrId = gCrId;
	}

	public Date getgUpdateTime() {
		return gUpdateTime;
	}

	public void setgUpdateTime(Date gUpdateTime) {
		this.gUpdateTime = gUpdateTime;
	}

	public int getgUpId() {
		return gUpId;
	}

	public void setgUpId(int gUpId) {
		this.gUpId = gUpId;
	}

	@Override
	public String toString() {
		return "游戏编号："+gId+",游戏名称："+gName+",游戏类型编号："+gGTId+",游戏图片路径："+gPicture+",游戏状态："+gState+",游戏详情："+gDetails+",乐豆价格："+gJoybeanPrice
				+",话费价格："+gPhonePrice+",创建时间："+gCreateTime+",创建用户编号："+gCrId+",更新时间："+gUpdateTime+",更新用户编号："+gUpId+",游戏类型：["+gameType+"]";
	}
	
	
	
	
}

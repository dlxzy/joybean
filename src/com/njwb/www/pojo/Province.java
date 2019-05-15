package com.njwb.www.pojo;
/**
 * 省份实体类
 * @author soft02
 *
 */
public class Province {	
	private int pId;
	private String pAreaCode;
	private String pDistrictName;
	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpAreaCode() {
		return pAreaCode;
	}

	public void setpAreaCode(String pAreaCode) {
		this.pAreaCode = pAreaCode;
	}

	public String getpDistrictName() {
		return pDistrictName;
	}

	public void setpDistrictName(String pDistrictName) {
		this.pDistrictName = pDistrictName;
	}

	public Province() {
		super();
	}

	public Province(int pId, String pAreaCode, String pDistrictName) {
		super();
		this.pId = pId;
		this.pAreaCode = pAreaCode;
		this.pDistrictName = pDistrictName;
	}



	@Override
	public String toString() {
		return "省份编号："+pId+",省份区号："+pAreaCode+",省份名称："+pDistrictName;
	}
	
	
	
}

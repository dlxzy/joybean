package com.njwb.www.mapper;

import java.util.List;

import com.njwb.www.pojo.Province;

public interface ProvinceMapper {
	/**
	 * 根据省份编号查询省份
	 * @param pId
	 * @return
	 */
	public Province queryProvinceByPId(int pId);
	/**
	 * 根据省份名称查询省份
	 * @param pDistrictName
	 * @return
	 */
	public Province queryProvinceByPDistrictName(String pDistrictName);
	/**
	 * 显示所有省份
	 * @return
	 */
	public List<Province> queryAllProvince();
}

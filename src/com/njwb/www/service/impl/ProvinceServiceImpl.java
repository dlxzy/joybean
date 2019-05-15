package com.njwb.www.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njwb.www.mapper.ProvinceMapper;
import com.njwb.www.pojo.Province;
import com.njwb.www.service.ProvinceService;
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceMapper provinceMapper;
	
	/**
	 * 根据省份编号查询省份
	 * @param pId
	 * @return
	 */
	public Province selectProvinceByPId(int pId){
		Province province = provinceMapper.queryProvinceByPId(pId);
		return province;
	}
	/**
	 * 根据省份名称查询省份
	 * @param pDistrictName
	 * @return
	 */
	public Province selectProvinceByPDistrictName(String pDistrictName){
		Province province = provinceMapper.queryProvinceByPDistrictName(pDistrictName);
		return province;
	}
	/**
	 * 显示所有省份
	 * @return
	 */
	public List<Province> showAllProvince(){
		List<Province> provinceList = provinceMapper.queryAllProvince();
		return provinceList;
	}
}

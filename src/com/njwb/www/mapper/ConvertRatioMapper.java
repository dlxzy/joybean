package com.njwb.www.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.www.pojo.ConvertRatio;
import com.njwb.www.pojo.ConvertRatioWrapper;
import com.njwb.www.pojo.Province;

public interface ConvertRatioMapper {
	/**
	 * 添加乐豆换算比例
	 * @param convertRatio
	 * @return
	 */
	public boolean addConvertRatio(ConvertRatio convertRatio);
	/**
	 * 根据编号删除乐豆换算比例
	 * @param crId
	 * @return
	 */
	public boolean delConvertRatioByCrId(int crId);
	/**
	 * 根据编号修改乐豆换算比例
	 * @param convertRatio
	 * @return
	 */
	public boolean updateConvertRatioByCrId(ConvertRatio convertRatio);
	/**
	 * 根据编号查询乐豆换算比例
	 * @param crId
	 * @return
	 */
	public ConvertRatio queryConvertRatioByCrId(int crId);
	/**
	 * 根据省份编号查询乐豆换算比例
	 * @param crPId
	 * @return
	 */
	public ConvertRatio queryConvertRatioByCrPId(int crPId);
	/**
	 * 查询记录行数
	 * @return
	 */
	public int queryCount();
	/**
	 * 分页查询
	 * @param params（pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> queryAllConvertRatioWrapperByPage(Map<String,Object> params);
	/**
	 * 根据省份名称查询记录行数
	 * @param province
	 * @return
	 */
	public int queryCountByPDistrictName(Province province);
	/**
	 * 根据省份名称分页查询乐豆换算比例
	 * @param params（pDistrictName,pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> queryAllByPDistrictNameByPage(Map<String,Object> params);
	/**
	 * 查询所有乐豆换算比例
	 * @return
	 */
	public List<ConvertRatioWrapper> queryAllConvertRatioWrapper();

}

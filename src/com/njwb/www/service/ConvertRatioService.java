package com.njwb.www.service;

import java.util.List;
import java.util.Map;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.ConvertRatio;
import com.njwb.www.pojo.ConvertRatioWrapper;

public interface ConvertRatioService {
	/**
	 * 添加乐豆换算比例
	 * @param convertRatio
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean addConvertRatio(ConvertRatio convertRatio) throws JoyBeanException;
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
	 * @throws JoyBeanException 
	 */
	public boolean updateConvertRatioByCrId(ConvertRatio convertRatio) throws JoyBeanException;
	/**
	 * 根据编号查询乐豆换算比例
	 * @param crId
	 * @return
	 */
	public ConvertRatio selectConvertRatioByCrId(int crId);
	/**
	 * 根据省份编号查询乐豆换算比例
	 * @param crPId
	 * @return
	 */
	public ConvertRatio selectConvertRatioByCrPId(int crPId);
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount();
	/**
	 *分页查询
	 * @param params（pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllConvertRatioWrapperByPage(Map<String,Object> params);
	/**
	 * 根据省份名称查询记录行数
	 * @param pDistrictName
	 * @return
	 */
	public int selectCountByPDistrictName(String pDistrictName);
	/**
	 * 根据省份名称分页查询乐豆换算比例
	 * @param params（pDistrictName,pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllByPDistrictNameByPage(Map<String,Object> params);
	/**
	 * 查询所有乐豆换算比例
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllConvertRatioWrapper();

}

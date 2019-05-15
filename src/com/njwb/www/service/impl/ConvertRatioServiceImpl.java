package com.njwb.www.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.mapper.ConvertRatioMapper;
import com.njwb.www.pojo.ConvertRatio;
import com.njwb.www.pojo.ConvertRatioWrapper;
import com.njwb.www.pojo.Province;
import com.njwb.www.service.ConvertRatioService;
import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
@Service("convertRatioService")
public class ConvertRatioServiceImpl implements ConvertRatioService {
	@Autowired
	private ConvertRatioMapper convertRatioMapper;
	
	/**
	 * 添加乐豆换算比例
	 * @param convertRatio
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean addConvertRatio(ConvertRatio convertRatio) throws JoyBeanException{
		if(convertRatioMapper.queryConvertRatioByCrPId(convertRatio.getCrPId())!=null){
			throw new JoyBeanException("该省份已有乐豆换算比例", ErrorCode.CONVERT_RATIO_PID_REPEAT_ERROR);
		}
		if(convertRatio.getCrConsumeAmount()<=StaticCode.ZERO){
			throw new JoyBeanException("消费金额不能小于等于0", ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_LESS_THAN_ZERO_ERROR);
		}
		boolean f = convertRatioMapper.addConvertRatio(convertRatio);
		return f;
	}
	/**
	 * 根据编号删除乐豆换算比例
	 * @param crId
	 * @return
	 */
	@Transactional
	public boolean delConvertRatioByCrId(int crId){
		boolean f = convertRatioMapper.delConvertRatioByCrId(crId);
		return f;
	}
	/**
	 * 根据编号修改乐豆换算比例
	 * @param convertRatio
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean updateConvertRatioByCrId(ConvertRatio convertRatio) throws JoyBeanException{
		if(convertRatio.getCrConsumeAmount()<=StaticCode.ZERO){
			throw new JoyBeanException("消费金额不能小于等于0", ErrorCode.CONVERT_RATIO_CONSUME_AMOUNT_LESS_THAN_ZERO_ERROR);
		}
		boolean f = convertRatioMapper.updateConvertRatioByCrId(convertRatio);
		return f;
	}
	/**
	 * 根据编号查询乐豆换算比例
	 * @param crId
	 * @return
	 */
	public ConvertRatio selectConvertRatioByCrId(int crId){
		ConvertRatio convertRatio = convertRatioMapper.queryConvertRatioByCrId(crId);
		return convertRatio;
	}
	/**
	 * 根据省份编号查询乐豆换算比例
	 * @param crPId
	 * @return
	 */
	public ConvertRatio selectConvertRatioByCrPId(int crPId){
		ConvertRatio convertRatio = convertRatioMapper.queryConvertRatioByCrPId(crPId);
		return convertRatio;
	}	
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount(){
		int cnt = convertRatioMapper.queryCount();
		return cnt;
	}
	/**
	 * 分页查询
	 * @param params（pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllConvertRatioWrapperByPage(Map<String,Object> params){
		List<ConvertRatioWrapper> crwList = convertRatioMapper.queryAllConvertRatioWrapperByPage(params);
		return crwList;
	}
	/**
	 * 根据省份名称查询记录行数
	 * @param pDistrictName
	 * @return
	 */
	public int selectCountByPDistrictName(String pDistrictName){
		Province province = new Province();
		province.setpDistrictName(pDistrictName);
		int cnt = convertRatioMapper.queryCountByPDistrictName(province);
		return cnt;
	}
	/**
	 * 根据省份名称分页查询乐豆换算比例
	 * @param params（pDistrictName,pageNo,pageSize）
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllByPDistrictNameByPage(Map<String,Object> params){
		List<ConvertRatioWrapper> crwList = convertRatioMapper.queryAllByPDistrictNameByPage(params);
		return crwList;
	}
	/**
	 * 查询所有乐豆换算比例
	 * @return
	 */
	public List<ConvertRatioWrapper> showAllConvertRatioWrapper(){
		List<ConvertRatioWrapper> crwList = convertRatioMapper.queryAllConvertRatioWrapper();
		return crwList;
	}

}

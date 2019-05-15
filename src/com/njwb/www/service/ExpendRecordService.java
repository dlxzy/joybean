package com.njwb.www.service;

import java.util.List;
import java.util.Map;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.ExpendRecord;
import com.njwb.www.pojo.ExpendRecordWrapper;

public interface ExpendRecordService {
	/**
	 * 添加消费记录
	 * @param expendRecord
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean addExpendRecord(ExpendRecord expendRecord) throws JoyBeanException;
	/**
	 * 根据用户编号、游戏编号查询消费记录
	 * @param params(erUId,erGId)
	 * @return
	 */
	public ExpendRecordWrapper selectExpendRecordWrapperByErUIdAndErGId(Map<String,Object> params);
	/**
	 * 根据消费记录编号查询消费记录
	 * @param erId
	 * @return
	 */
	public ExpendRecordWrapper selectExpendRecordWrapperByErId(int erId);
	/**
	 * 根据用户编号查询消费记录行数
	 * @param erUId
	 * @return
	 */
	public int selectCountByErUId(int erUId);
	/**
	 * 根据用户编号分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllByErUIdByPage(Map<String,Object> map);
	/**
	 * 根据用户编号、游戏名称、购买方式查询消费记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByErUIdAndGNameAndErPurchaseWays(Map<String,Object> params);
	/**
	 * 根据用户编号、游戏名称、购买方式分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllByErUIdAndGNameAndErPurchaseWaysByPage(Map<String,Object> map);
	/**
	 * 根据用户编号查询所有消费记录
	 * @param erUId
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllExpendRecordWrapperByErUId(int erUId);
}

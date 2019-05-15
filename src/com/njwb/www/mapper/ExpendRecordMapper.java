package com.njwb.www.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.www.pojo.ExpendRecord;
import com.njwb.www.pojo.ExpendRecordWrapper;

public interface ExpendRecordMapper {
	/**
	 * 添加消费记录
	 * @param expendRecord
	 * @return
	 */
	public boolean addExpendRecord(ExpendRecord expendRecord);
	/**
	 * 根据用户编号、游戏编号查询消费记录
	 * @param params(erUId,erGId)
	 * @return
	 */
	public ExpendRecordWrapper queryExpendRecordWrapperByErUIdAndErGId(Map<String,Object> params);
	/**
	 * 根据消费记录编号查询消费记录
	 * @param erId
	 * @return
	 */
	public ExpendRecordWrapper queryExpendRecordWrapperByErId(int erId);
	/**
	 * 根据用户编号查询消费记录行数
	 * @param erUId
	 * @return
	 */
	public int queryCountByErUId(int erUId);
	/**
	 * 根据用户编号分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> queryAllByErUIdByPage(Map<String,Object> map);
	/**
	 * 根据用户编号、游戏名称、购买方式查询消费记录行数
	 * @param params
	 * @return
	 */
	public int queryCountByErUIdAndGNameAndErPurchaseWays(Map<String,Object> params);
	/**
	 * 根据用户编号、游戏名称、购买方式分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> queryAllByErUIdAndGNameAndErPurchaseWaysByPage(Map<String,Object> map);
	/**
	 * 根据用户编号查询所有消费记录
	 * @param erUId
	 * @return
	 */
	public List<ExpendRecordWrapper> queryAllExpendRecordWrapperByErUId(int erUId);
}

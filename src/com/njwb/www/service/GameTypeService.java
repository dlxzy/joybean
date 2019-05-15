package com.njwb.www.service;

import java.util.List;
import java.util.Map;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.GameType;

public interface GameTypeService {
	/**
	 * 添加游戏类型
	 * @param gameType
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean addGameType(GameType gameType) throws JoyBeanException;
	/**
	 * 通过游戏类型编号修改游戏类型
	 * @param gameType
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean updateGameTypeByGtId(GameType gameType) throws JoyBeanException;
	/**
	 * 通过游戏类型编号查询游戏类型
	 * @param gtId
	 * @return
	 */
	public GameType selectGameTypeByGtId(int gtId);
	/**
	 * 通过游戏类型名称查询游戏类型
	 * @param gtName
	 * @return
	 */
	public GameType selectGameTypeByGtName(String gtName);
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount();
	/**
	 * 分页查询
	 * @param params(pageNo,pageSize)
	 * @return
	 */
	public List<GameType> showAllGameTypeByPage(Map<String,Object> params);
	/**
	 *通过游戏类型名称、游戏类型状态查询记录行数
	 * @param params(gtName,gtState)
	 * @return
	 */
	public int selectCountByGtNameAndGtState(Map<String,Object> params);
	/**
	 * 通过游戏类型名称、游戏类型状态分页查询游戏类型
	 * @param params(gtName,gtState,pageNo,pageSize)
	 * @return
	 */
	public List<GameType> showAllByGtNameAndGtStateByPage(Map<String,Object> params);
	/**
	 * 通过游戏类型状态查询游戏类型
	 * @return
	 */
	public List<GameType> showAllByGtState(int gtState);
	/**
	 * 查询所有游戏类型
	 * @return
	 */
	public List<GameType> showAllGameType();
}

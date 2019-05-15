package com.njwb.www.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.www.pojo.GameType;

public interface GameTypeMapper {
	/**
	 * 添加游戏类型
	 * @param gameType
	 * @return
	 */
	public boolean addGameType(GameType gameType);
	/**
	 * 通过游戏类型编号修改游戏类型
	 * @param gameType
	 * @return
	 */
	public boolean updateGameTypeByGtId(GameType gameType);
	/**
	 * 通过游戏类型编号查询游戏类型
	 * @param gtId
	 * @return
	 */
	public GameType queryGameTypeByGtId(int gtId);
	/**
	 * 通过游戏类型名称查询游戏类型
	 * @param gtName
	 * @return
	 */
	public GameType queryGameTypeByGtName(String gtName);
	/**
	 *  查询记录行数
	 * @return
	 */
	public int queryCount();
	/**
	 * 分页查询
	 * @param params(pageNo,pageSize)
	 * @return
	 */
	public List<GameType> queryAllGameTypeByPage(Map<String,Object> params);
	/**
	 * 通过游戏类型名称、游戏类型状态查询记录行数
	 * @param params(gtName,gtState)
	 * @return
	 */
	public int queryCountByGtNameAndGtState(Map<String,Object> params);
	/**
	 * 通过游戏类型名称、游戏类型状态分页查询游戏类型
	 * @param params(gtName,gtState,pageNo,pageSize)
	 * @return
	 */
	public List<GameType> queryAllByGtNameAndGtStateByPage(Map<String,Object> params);
	/**
	 * 通过游戏类型状态查询游戏类型
	 * @return
	 */
	public List<GameType> queryAllByGtState(int gtState);
	/**
	 * 查询所有游戏类型
	 * @return
	 */
	public List<GameType> queryAllGameType();

}

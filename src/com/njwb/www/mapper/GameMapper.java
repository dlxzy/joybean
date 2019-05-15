package com.njwb.www.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.www.pojo.Game;
import com.njwb.www.pojo.GameWrapper;

public interface GameMapper {
	/**
	 * 添加游戏
	 * @param game
	 * @return
	 */
	public boolean addGame(Game game);
	/**
	 * 根据游戏编号修改游戏
	 * @param game
	 * @return
	 */
	public boolean updateGameByGId(Game game);
	/**
	 * 根据游戏编号查询游戏
	 * @param gId
	 * @return
	 */
	public GameWrapper queryGameWrapperByGId(int gId); 
	/**
	 * 根据游戏名称查询游戏
	 * @param gName
	 * @return
	 */
	public GameWrapper queryGameWrapperByGName(String gName);
	/**
	 * 根据游戏类型名称、游戏状态查询游戏
	 * @param params(gtName,gState)
	 * @return
	 */
	public List<GameWrapper> queryAllByGtNameAndGState(Map<String,Object> params);
	/**
	 * 查询记录行数
	 * @return
	 */
	public int queryCount();
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> queryAllGameWrapperByPage(Map<String,Object> params);
	/**
	 * 根据游戏名称、游戏类型名称查询记录行数
	 * @param params
	 * @return
	 */
	public int queryCountByGNameAndGTName(Map<String,Object> params);
	/**
	 * 根据游戏名称、游戏类型名称分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> queryAllByGNameAndGTNameByPage(Map<String,Object> params);
	/**
	 * 查询所有游戏
	 * @return
	 */
	public List<GameWrapper> queryAllGameWrapper();

}

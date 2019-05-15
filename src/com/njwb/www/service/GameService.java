package com.njwb.www.service;

import java.util.List;
import java.util.Map;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.Game;
import com.njwb.www.pojo.GameWrapper;

public interface GameService {
	/**
	 * 添加游戏
	 * @param game
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean addGame(Game game) throws JoyBeanException;
	/**
	 * 根据游戏编号修改游戏
	 * @param game
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean updateGameByGId(Game game) throws JoyBeanException;
	/**
	 * 根据游戏编号查询游戏
	 * @param gId
	 * @return
	 */
	public GameWrapper selectGameWrapperByGId(int gId); 
	/**
	 * 根据游戏名称查询游戏
	 * @param gName
	 * @return
	 */
	public GameWrapper selectGameWrapperByGName(String gName); 
	/**
	 * 根据游戏类型名称、游戏状态查询游戏
	 * @param params(gtName,gState)
	 * @return
	 */
	public List<GameWrapper> showAllByGtNameAndGState(Map<String,Object> params);
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount();
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> showAllGameWrapperByPage(Map<String,Object> params);
	/**
	 * 根据游戏名称、游戏类型名称查询记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByGNameAndGTName(Map<String,Object> params);
	/**
	 * 根据游戏名称、游戏类型名称分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> showAllByGNameAndGTNameByPage(Map<String,Object> params);
	/**
	 * 查询所有游戏
	 * @return
	 */
	public List<GameWrapper> showAllGameWrapper();

}

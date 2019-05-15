package com.njwb.www.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.mapper.GameMapper;
import com.njwb.www.pojo.Game;
import com.njwb.www.pojo.GameWrapper;
import com.njwb.www.service.GameService;
import com.njwb.www.util.ErrorCode;
@Service("gameService")
public class GameServiceImpl implements GameService {
	@Autowired
	private GameMapper gameMapper;
	
	/**
	 * 添加游戏
	 * @param game
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean addGame(Game game) throws JoyBeanException{
		if(gameMapper.queryGameWrapperByGName(game.getgName())!=null){
			throw new JoyBeanException("该游戏名称已存在", ErrorCode.GAME_NAME_REPEAT_ERROR);
		}
		boolean f = gameMapper.addGame(game);
		return f;
	}
	/**
	 * 根据游戏编号修改游戏
	 * @param game
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean updateGameByGId(Game game) throws JoyBeanException{
		GameWrapper gw = gameMapper.queryGameWrapperByGName(game.getgName());
		if(gw!=null&&gw.getgId()!=game.getgId()){
			throw new JoyBeanException("该游戏名称已存在", ErrorCode.GAME_NAME_REPEAT_ERROR);
		}
		boolean f = gameMapper.updateGameByGId(game);
		return f;
	}
	/**
	 * 根据游戏编号查询游戏
	 * @param gId
	 * @return
	 */
	public GameWrapper selectGameWrapperByGId(int gId){
		GameWrapper gameWrapper = gameMapper.queryGameWrapperByGId(gId);
		return gameWrapper;
	}
	/**
	 * 根据游戏名称查询游戏
	 * @param gName
	 * @return
	 */
	public GameWrapper selectGameWrapperByGName(String gName){
		GameWrapper gameWrapper = gameMapper.queryGameWrapperByGName(gName);
		return gameWrapper;
	}
	/**
	 * 根据游戏类型名称、游戏状态查询游戏
	 * @param params(gtName,gState)
	 * @return
	 */
	public List<GameWrapper> showAllByGtNameAndGState(Map<String,Object> params){
		List<GameWrapper> gameWrapperList = gameMapper.queryAllByGtNameAndGState(params);
		return gameWrapperList;
	}
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount(){
		int cnt = gameMapper.queryCount();
		return cnt;
	}
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> showAllGameWrapperByPage(Map<String,Object> params){
		List<GameWrapper> gameWrapperList = gameMapper.queryAllGameWrapperByPage(params);
		return gameWrapperList;
	}
	/**
	 * 根据游戏名称、游戏类型名称查询记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByGNameAndGTName(Map<String,Object> params){
		int cnt = gameMapper.queryCountByGNameAndGTName(params);
		return cnt;
	}
	/**
	 * 根据游戏名称、游戏类型名称分页查询
	 * @param params
	 * @return
	 */
	public List<GameWrapper> showAllByGNameAndGTNameByPage(Map<String,Object> params){
		List<GameWrapper> gameWrapperList = gameMapper.queryAllByGNameAndGTNameByPage(params);
		return gameWrapperList;
	}
	/**
	 * 查询所有游戏
	 * @return
	 */
	public List<GameWrapper> showAllGameWrapper(){
		List<GameWrapper> gameWrapperList = gameMapper.queryAllGameWrapper();
		return gameWrapperList;
	}

}

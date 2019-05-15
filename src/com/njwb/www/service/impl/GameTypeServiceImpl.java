package com.njwb.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.mapper.GameMapper;
import com.njwb.www.mapper.GameTypeMapper;
import com.njwb.www.pojo.GameType;
import com.njwb.www.pojo.GameWrapper;
import com.njwb.www.service.GameTypeService;
@Service("gameTypeService")
public class GameTypeServiceImpl implements GameTypeService {
	@Autowired
	private GameTypeMapper gameTypeMapper;
	@Autowired
	private GameMapper gameMapper;
	/**
	 * 添加游戏类型
	 * @param gameType
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean addGameType(GameType gameType) throws JoyBeanException {
		if(gameTypeMapper.queryGameTypeByGtName(gameType.getGtName())!=null){
			throw new JoyBeanException("游戏类型名称重复", ErrorCode.GAME_TYPE_NAME_REPEAT_ERROR);
		}
		boolean f = gameTypeMapper.addGameType(gameType);
		return f;
	}
	
	/**
	 * 通过游戏类型编号修改游戏类型
	 * @param gameType
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean updateGameTypeByGtId(GameType gameType) throws JoyBeanException {
		GameType gte = gameTypeMapper.queryGameTypeByGtName(gameType.getGtName());
		if(gte!=null&&gte.getGtId()!=gameType.getGtId()){
			throw new JoyBeanException("游戏类型名称重复", ErrorCode.GAME_TYPE_NAME_REPEAT_ERROR);
		}
		if(gameType.getGtState()==StaticCode.OFFLINE){
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("gtName",gameType.getGtName());
			params.put("gState",StaticCode.COMMERCIAL);
			List<GameWrapper> gwList = gameMapper.queryAllByGtNameAndGState(params);		
			if(gwList.size()>0){
				throw new JoyBeanException("该游戏类型下仍有未下线游戏",ErrorCode.GAME_TYPE_HAS_GAME_COMMERCIAL_ERROR);
			}	
		}
		boolean f = gameTypeMapper.updateGameTypeByGtId(gameType);
		return f;
	}
	
	/**
	 * 通过游戏类型编号查询游戏类型
	 * @param gtId
	 * @return
	 */
	public GameType selectGameTypeByGtId(int gtId) {
		GameType gameType = gameTypeMapper.queryGameTypeByGtId(gtId);
		return gameType;
	}

	/**
	 * 通过游戏类型名称查询游戏类型
	 * @param gtName
	 * @return
	 */
	public GameType selectGameTypeByGtName(String gtName) {
		GameType gameType = gameTypeMapper.queryGameTypeByGtName(gtName);
		return gameType;
	}
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount(){
		int cnt = gameTypeMapper.queryCount();
		return cnt;
	}
	/**
	 * 分页查询
	 * @param params(pageNo,pageSize)
	 * @return
	 */
	public List<GameType> showAllGameTypeByPage(Map<String,Object> params){
		List<GameType> gameTypeList = gameTypeMapper.queryAllGameTypeByPage(params);
		return gameTypeList;
	}
	/**
	 *通过游戏类型名称、游戏类型状态查询记录行数
	 * @param params(gtName,gtState)
	 * @return
	 */
	public int selectCountByGtNameAndGtState(Map<String,Object> params) {
		int cnt = gameTypeMapper.queryCountByGtNameAndGtState(params);
		return cnt;
	}

	/**
	 * 通过游戏类型名称、游戏类型状态分页查询游戏类型
	 * @param params(gtName,gtState,pageNo,pageSize)
	 * @return
	 */
	public List<GameType> showAllByGtNameAndGtStateByPage(Map<String, Object> params) {
		List<GameType> gameTypeList = gameTypeMapper.queryAllByGtNameAndGtStateByPage(params);
		return gameTypeList;
	}
	/**
	 * 通过游戏类型状态查询游戏类型
	 * @return
	 */
	public List<GameType> showAllByGtState(int gtState){
		List<GameType> gameTypeList = gameTypeMapper.queryAllByGtState(gtState);
		return gameTypeList;
	}
	/**
	 * 查询所有游戏类型
	 * @return
	 */
	public List<GameType> showAllGameType() {
		List<GameType> gameTypeList = gameTypeMapper.queryAllGameType();
		return gameTypeList;
	}

	

	
	
		

	

}

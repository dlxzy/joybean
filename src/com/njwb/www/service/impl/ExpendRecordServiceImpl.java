package com.njwb.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.mapper.ConvertRatioMapper;
import com.njwb.www.mapper.ExpendRecordMapper;
import com.njwb.www.mapper.GameMapper;
import com.njwb.www.mapper.UserMapper;
import com.njwb.www.pojo.ConvertRatio;
import com.njwb.www.pojo.ExpendRecord;
import com.njwb.www.pojo.ExpendRecordWrapper;
import com.njwb.www.pojo.GameWrapper;
import com.njwb.www.pojo.User;
import com.njwb.www.service.ExpendRecordService;
import com.njwb.www.util.ErrorCode;
import com.njwb.www.util.StaticCode;
@Service("expendRecordService")
public class ExpendRecordServiceImpl implements ExpendRecordService {
	@Autowired
	private ExpendRecordMapper expendRecordMapper;
	
	@Autowired
	private GameMapper gameMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ConvertRatioMapper convertRatioMapper;
	/**
	 * 添加消费记录
	 * @param expendRecord
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean addExpendRecord(ExpendRecord expendRecord) throws JoyBeanException{
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("erUId",expendRecord.getErUId());
		params.put("erGId",expendRecord.getErGId());
		//判断是否已购买过
		if(expendRecordMapper.queryExpendRecordWrapperByErUIdAndErGId(params)!=null){
			throw new JoyBeanException("本账户已购买该游戏", ErrorCode.EXPEND_RECORD_HAS_ERROR);
		}
		//通过游戏编号获得游戏的信息
		GameWrapper gameWrapper = gameMapper.queryGameWrapperByGId(expendRecord.getErGId());
		//游戏的乐豆价格
		int gJoybeanPrice = gameWrapper.getgJoybeanPrice();
		//游戏的话费价格
		int gPhonePrice = gameWrapper.getgPhonePrice();
		//用户编号
		int erUId = expendRecord.getErUId();
		//赠送乐豆
		int erGiftJoybeanAmount = 0;
		//消费金额或者乐豆
		int erConsumeAmount = 0;
		//比例
		int crConsumeAmount = 0;
		
		//通过用户编号获得用户信息
		User user = userMapper.queryUserByUId(erUId);
		//获取该用户所在的省份编号
		int uPId =user.getuPId();
		//用户乐豆余额
		int uJoyBeanBalance = user.getuJoyBeanBalance();
		//用户话费余额
		int uPhoneBalance = user.getuPhoneBalance();
		//获取该省份所对应的消费比例
		ConvertRatio convertRatio =convertRatioMapper.queryConvertRatioByCrPId(uPId);
		if(convertRatio==null){
			crConsumeAmount = StaticCode.DEFAULTRATIO;
		}else{
			crConsumeAmount = convertRatio.getCrConsumeAmount();
		}
		
		boolean fu;
		//1为话费购买，赠送乐豆，2为乐豆兑换，不赠送乐豆
		
		if(expendRecord.getErPurchaseWays()==StaticCode.PHONEBUY){
			//消费金额对比例是否取整
			if(gPhonePrice%crConsumeAmount==0){
				erGiftJoybeanAmount = gPhonePrice/crConsumeAmount;
			}else{
				erGiftJoybeanAmount = (gPhonePrice/crConsumeAmount)+1;
			}
			//消费金额为游戏话费价格
			erConsumeAmount = gPhonePrice;
			
			if(uPhoneBalance>=erConsumeAmount){
				fu = userMapper.updateUserBalanceByUId(new User(erUId,(uPhoneBalance-erConsumeAmount),(uJoyBeanBalance+erGiftJoybeanAmount)));
				
			}else{
				throw new JoyBeanException("该账号话费不足",ErrorCode.EXPEND_RECORD_PHONE_NOT_ENOUGH_ERROR);
			}
		}else{
			//乐豆兑换不赠送乐豆
			erGiftJoybeanAmount = 0;
			//消费金额为乐豆价格
			erConsumeAmount = gJoybeanPrice;
			
			if(uJoyBeanBalance>=erConsumeAmount){
				fu = userMapper.updateUserBalanceByUId(new User(erUId,uPhoneBalance,(uJoyBeanBalance-erConsumeAmount)));
				
			}else{
				throw new JoyBeanException("该账号乐豆不足",ErrorCode.EXPEND_RECORD_JOYBEAN_NOT_ENOUGH_ERROR);
			}
		}
		
		boolean fa = expendRecordMapper.addExpendRecord(new ExpendRecord(expendRecord.getErGId(), erConsumeAmount, expendRecord.getErPurchaseWays(), erGiftJoybeanAmount, erUId));
		return fu&&fa; 
	}
	/**
	 * 根据用户编号、游戏编号查询消费记录
	 * @param params(erUId,erGId)
	 * @return
	 */
	public ExpendRecordWrapper selectExpendRecordWrapperByErUIdAndErGId(Map<String,Object> params){
		ExpendRecordWrapper expendRecordWrapper = expendRecordMapper.queryExpendRecordWrapperByErUIdAndErGId(params);
		return expendRecordWrapper;
	}
	/**
	 * 根据消费记录编号查询消费记录
	 * @param erId
	 * @return
	 */
	public ExpendRecordWrapper selectExpendRecordWrapperByErId(int erId){
		ExpendRecordWrapper expendRecordWrapper = expendRecordMapper.queryExpendRecordWrapperByErId(erId);
		return expendRecordWrapper;
	}
	/**
	 * 根据用户编号查询消费记录行数
	 * @param erUId
	 * @return
	 */
	public int selectCountByErUId(int erUId){
		int cnt = expendRecordMapper.queryCountByErUId(erUId);
		return cnt;
	}
	/**
	 * 根据用户编号分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllByErUIdByPage(Map<String,Object> map){
		List<ExpendRecordWrapper> expendRecordWrapperList = expendRecordMapper.queryAllByErUIdByPage(map);
		return expendRecordWrapperList;
	}
	/**
	 * 根据用户编号、游戏名称、购买方式查询消费记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByErUIdAndGNameAndErPurchaseWays(Map<String,Object> params){
		int cnt = expendRecordMapper.queryCountByErUIdAndGNameAndErPurchaseWays(params);
		return cnt;
	}
	/**
	 * 根据用户编号、游戏名称、购买方式分页查询消费记录
	 * @param map
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllByErUIdAndGNameAndErPurchaseWaysByPage(Map<String,Object> map){
		List<ExpendRecordWrapper> expendRecordWrapperList = expendRecordMapper.queryAllByErUIdAndGNameAndErPurchaseWaysByPage(map);
		return expendRecordWrapperList;
	}
	/**
	 * 根据用户编号查询所有消费记录
	 * @param erUId
	 * @return
	 */
	public List<ExpendRecordWrapper> showAllExpendRecordWrapperByErUId(int erUId){
		List<ExpendRecordWrapper> expendRecordWrapperList = expendRecordMapper.queryAllExpendRecordWrapperByErUId(erUId);
		return expendRecordWrapperList;
	}
}

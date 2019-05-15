package com.njwb.www.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.mapper.UserMapper;
import com.njwb.www.pojo.User;
import com.njwb.www.pojo.UserWrapper;
import com.njwb.www.service.UserService;
import com.njwb.www.util.ErrorCode;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登陆
	 * @param user(uAccount,uPassword,uState)
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean login(String uAccount,String uPassword,int uRole) throws JoyBeanException{
		if(userMapper.queryUserByUAccount(uAccount)==null){
			throw new JoyBeanException("该用户账号不存在", ErrorCode.USER_NULL_ERROR);
		}
		if(uPassword.equals(userMapper.queryUserByUAccount(uAccount).getuPassword())&&uRole==userMapper.queryUserByUAccount(uAccount).getuRole()){
			return true;
		}else{
			return false;
		}
			
	}
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws JoyBeanException 
	 */
	@Transactional
	public boolean addUser(User user) throws JoyBeanException{
		if(userMapper.queryUserByUAccount(user.getuAccount())!=null){
			throw new JoyBeanException("该用户账号已存在", ErrorCode.USER_ACCOUNT_REPEAT_ERROR);
		}
		boolean f = userMapper.addUser(user);
		return f;
	}
	/**
	 * 根据用户编号修改用户状态
	 * @param user(uId,uState)
	 * @return
	 */
	@Transactional
	public boolean updateUStateByUId(User user){
		boolean f = userMapper.updateUStateByUId(user);
		return f;
	}
	/**
	 * 根据用户编号修改话费余额
	 * @param params
	 * @return
	 */
	@Transactional
	public boolean updatePhoneBalanceByUId(Map<String,Object> params){
		boolean f = userMapper.updatePhoneBalanceByUId(params);
		return f;
	}
	/**
	 * 根据用户编号修改话费、乐豆余额
	 * @param user(uId,uPhoneBalance,uJoyBeanBalance)
	 * @return
	 */
	@Transactional
	public boolean updateUserBalanceByUId(User user){
		boolean f = userMapper.updateUserBalanceByUId(user);
		return f;
	}
	/**
	 * 根据用户编号查询用户
	 * @param uId
	 * @return
	 */
	public User selectUserByUId(int uId){
		User user = userMapper.queryUserByUId(uId);
		return user;
	}
	/**
	 * 根据用户账户查询用户
	 * @param uAccount
	 * @return
	 */
	public User selectUserByUAccount(String uAccount){
		User user = userMapper.queryUserByUAccount(uAccount);
		return user;
	}
	/**
	 * 查询记录行数
	 * @return
	 */
	public int selectCount(){
		int cnt = userMapper.queryCount();
		return cnt;
	}
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<UserWrapper> showAllUserWrapperByPage(Map<String,Object> params){
		List<UserWrapper> userWrapperList = userMapper.queryAllUserWrapperByPage(params);
		return userWrapperList;
	}
	/**
	 * 根据用户账号、用户姓名、手机号码查询记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByUAccountAndUNameAndUPhoneNumber(Map<String,Object> params){
		int cnt = userMapper.queryCountByUAccountAndUNameAndUPhoneNumber(params);
		return cnt;
	}
	/**
	 * 根据用户账号、用户姓名、手机号码分页查询
	 * @param params
	 * @return
	 */
	public List<UserWrapper> showAllByUAccountAndUNameAndUPhoneNumberByPage(Map<String,Object> params){
		List<UserWrapper> userWrapperList = userMapper.queryAllByUAccountAndUNameAndUPhoneNumberByPage(params);
		return userWrapperList;
	}
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserWrapper> showAllUserWrapper(){
		List<UserWrapper> userWrapperList = userMapper.queryAllUserWrapper();
		return userWrapperList;
	}
}

package com.njwb.www.service;

import java.util.List;
import java.util.Map;

import com.njwb.www.exception.JoyBeanException;
import com.njwb.www.pojo.User;
import com.njwb.www.pojo.UserWrapper;

public interface UserService {
	/**
	 * 用户登陆
	 * @param (uAccount,uPassword)
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean login(String uAccount,String uPassword,int uRole) throws JoyBeanException;
	/**
	 * 添加用户
	 * @param user
	 * @return
	 * @throws JoyBeanException 
	 */
	public boolean addUser(User user) throws JoyBeanException;
	/**
	 * 根据用户编号修改用户状态
	 * @param user(uId,uState)
	 * @return
	 */
	public boolean updateUStateByUId(User user);
	/**
	 * 根据用户编号修改话费余额
	 * @param params
	 * @return
	 */
	public boolean updatePhoneBalanceByUId(Map<String,Object> params);
	/**
	 * 根据用户编号修改话费、乐豆余额
	 * @param user(uId,uPhoneBalance,uJoyBeanBalance)
	 * @return
	 */
	public boolean updateUserBalanceByUId(User user);
	/**
	 * 根据用户编号查询用户
	 * @param uId
	 * @return
	 */
	public User selectUserByUId(int uId);
	/**
	 * 根据用户账户查询用户
	 * @param uAccount
	 * @return
	 */
	public User selectUserByUAccount(String uAccount);
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
	public List<UserWrapper> showAllUserWrapperByPage(Map<String,Object> params);
	/**
	 * 根据用户账号、用户姓名、手机号码查询记录行数
	 * @param params
	 * @return
	 */
	public int selectCountByUAccountAndUNameAndUPhoneNumber(Map<String,Object> params);
	/**
	 * 根据用户账号、用户姓名、手机号码分页查询
	 * @param params
	 * @return
	 */
	public List<UserWrapper> showAllByUAccountAndUNameAndUPhoneNumberByPage(Map<String,Object> params);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserWrapper> showAllUserWrapper();
}

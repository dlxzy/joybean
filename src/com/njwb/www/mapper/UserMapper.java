package com.njwb.www.mapper;

import java.util.List;
import java.util.Map;

import com.njwb.www.pojo.User;
import com.njwb.www.pojo.UserWrapper;

public interface UserMapper {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user);
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
	public User queryUserByUId(int uId);
	/**
	 * 根据用户账户查询用户
	 * @param uAccount
	 * @return
	 */
	public User queryUserByUAccount(String uAccount);
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
	public List<UserWrapper> queryAllUserWrapperByPage(Map<String,Object> params);
	/**
	 * 根据用户账号、用户姓名、手机号码查询记录行数
	 * @param params
	 * @return
	 */
	public int queryCountByUAccountAndUNameAndUPhoneNumber(Map<String,Object> params);
	/**
	 * 根据用户账号、用户姓名、手机号码分页查询
	 * @param params
	 * @return
	 */
	public List<UserWrapper> queryAllByUAccountAndUNameAndUPhoneNumberByPage(Map<String,Object> params);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<UserWrapper> queryAllUserWrapper();
}

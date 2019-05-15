package com.njwb.www.util;

public class ErrorCode {

	public static final String USER_LOGIN_SUCCESS = "0001";//登录成功
	public static final String USER_ADD_SUCCESS = "0002";//用户注册成功
	public static final String USER_STATE_NORMAL_EDIT_SUCCESS = "0003";//用户状态(正常)修改成功
	public static final String USER_STATE_SUSPEND_EDIT_SUCCESS = "0004";//用户状态(暂停使用)修改成功
	public static final String USER_PHONEBALANCE_EDIT_SUCCESS = "0005";//话费充值成功
	public static final String USER_JOYBEANBALANCE_EDIT_SUCCESS = "0006";//乐豆兑换成功

	public static final String GAME_TYPE_ADD_SUCCESS = "0101";//游戏类型添加成功
	public static final String GAME_TYPE_EDIT_SUCCESS = "0102";//游戏类型修改成功

	public static final String CONVERT_RATIO_ADD_SUCCESS = "0201";//乐豆换算比例添加成功
	public static final String CONVERT_RATIO_DEL_SUCCESS = "0202";//乐豆换算比例删除成功
	public static final String CONVERT_RATIO_EDIT_SUCCESS = "0203";//乐豆换算比例修改成功

	public static final String GAME_ADD_SUCCESS = "0301";//游戏添加成功
	public static final String GAME_EDIT_SUCCESS = "0302";//游戏修改成功
	
	public static final String EXPEND_RECORD_ADD_SUCCESS = "0401";//游戏购买成功
	public static final String EXPEND_RECORD_DOWNLOAD_GAME_SUCCESS = "0402";//游戏下载成功
	
	public static final String USER_LOGIN_ERROR = "9001";//登录失败
	public static final String USER_ADD_ERROR = "9002";//用户注册失败
	public static final String USER_STATE_NORMAL_EDIT_ERROR = "9003";//用户状态(正常)修改失败
	public static final String USER_STATE_SUSPEND_EDIT_ERROR = "9004";//用户状态(暂停使用)修改失败
	public static final String USER_PHONEBALANCE_EDIT_ERROR = "9005";//话费充值失败
	public static final String USER_JOYBEANBALANCE_EDIT_ERROR = "9006";//乐豆兑换失败
	
	
	public static final String GAME_TYPE_ADD_ERROR = "9101";//游戏类型添加失败
	public static final String GAME_TYPE_EDIT_ERROR = "9102";//游戏类型修改失败
	
	public static final String CONVERT_RATIO_ADD_ERROR = "9201";//乐豆换算比例添加失败
	public static final String CONVERT_RATIO_DEL_ERROR = "9202";//乐豆换算比例删除失败
	public static final String CONVERT_RATIO_EDIT_ERROR = "9203";//乐豆换算比例修改失败
	
	public static final String GAME_ADD_ERROR = "9301";//游戏添加失败
	public static final String GAME_EDIT_ERROR = "9302";//游戏修改失败
	
	public static final String EXPEND_RECORD_ADD_ERROR = "9401";//游戏购买失败
	public static final String EXPEND_RECORD_DOWNLOAD_GAME_ERROR = "9402";//游戏下载失败，请先购买该游戏
	
	public static final String USER_NULL_ERROR = "7001";//用户不存在
	public static final String USER_ACCOUNT_NULL_ERROR = "7002";//用户账号为空
	public static final String USER_PASSWORD_NULL_ERROR = "7003";//密码为空
	public static final String USER_CODE_NULL_ERROR = "7004";//验证码为空
	public static final String USER_PASSWORD_ERROR = "7005";//密码错误
	public static final String USER_CODE_ERROR = "7006";//验证码错误
	public static final String USER_PHONENUMBER_NULL_ERROR = "7007";//手机号码为空
	public static final String USER_ACCOUNT_REPEAT_ERROR = "7008";//用户账号重复
	public static final String USER_PID_NULL_ERROR = "7009";//省份不能为空
	public static final String USER_STATE_ERROR = "7010";//用户状态(正常)修改失败
	public static final String USER_PHONENUMBER_FORMAT_ERROR = "7011";//手机号码格式错误
	public static final String USER_PHONE_NOT_ENOUGH_ERROR = "7012";//兑换乐豆失败，话费不足
	public static final String USER_PHONE_NULL_ERROR = "7013";//充值话费金额为空
	public static final String USER_JOYBEAN_NULL_ERROR = "7014";//兑换乐豆数量为空	
	public static final String USER_PHONE_FORMAT_ERROR = "7015";//充值话费金额不能为非数字
	public static final String USER_JOYBEAN_FORMAT_ERROR = "7016";//兑换乐豆数量不能为非数字
	public static final String USER_PHONE_LESS_THAN_ZERO_ERROR = "7017";//充值话费金额不能小于0或者等于0
	public static final String USER_JOYBEAN_LESS_THAN_ZERO_ERROR = "7018";//兑换乐豆数量不能小于0或者等于0
	
	public static final String GAME_TYPE_NAME_NULL_ERROR = "7101";//游戏类型名称为空
	public static final String GAME_TYPE_NAME_REPEAT_ERROR = "7102";//游戏类型名称重复
	public static final String GAME_TYPE_HAS_GAME_COMMERCIAL_ERROR = "7103";//游戏类型下仍有未下线游戏

	public static final String CONVERT_RATIO_PID_NULL_ERROR = "7201";//省份名称为空
	public static final String CONVERT_RATIO_PID_REPEAT_ERROR = "7202";//省份名称重复
	public static final String CONVERT_RATIO_CONSUME_AMOUNT_NULL_ERROR = "7203";//消费金额为空
	public static final String CONVERT_RATIO_CONSUME_AMOUNT_FORMAT_ERROR = "7204";//消费金额不能为非数字
	public static final String CONVERT_RATIO_CONSUME_AMOUNT_LESS_THAN_ZERO_ERROR = "7205";//消费金额不能等于小于0
	
	public static final String GAME_NAME_NULL_ERROR = "7301";//游戏名称为空
	public static final String GAME_GGTID_NULL_ERROR = "7302";//游戏类别为空
	public static final String GAME_DETAILS_NULL_ERROR = "7303";//游戏详情为空
	public static final String GAME_PICTURE_NULL_ERROR = "7304";//游戏图片为空
	public static final String GAME_JOYBEANPRICE_NULL_ERROR = "7305";//游戏乐豆价格为空
	public static final String GAME_PHONEPRICE_NULL_ERROR = "7306";//游戏话费价格为空
	public static final String GAME_NAME_REPEAT_ERROR = "7307";//游戏名称重复
	public static final String GAME_JOYBEANPRICE_FORMAT_ERROR = "7308";//游戏乐豆价格不能为非数字
	public static final String GAME_PHONEPRICE_FORMAT_ERROR = "7309";//游戏话费价格不能为非数字
	
	public static final String EXPEND_RECORD_HAS_ERROR = "7401";//本账户已购买该游戏
	public static final String EXPEND_RECORD_JOYBEAN_NOT_ENOUGH_ERROR = "7402";//该账号乐豆不足
	public static final String EXPEND_RECORD_PHONE_NOT_ENOUGH_ERROR = "7403";//该账号话费不足
	public static final String EXPEND_RECORD_USER_NULL_ERROR = "7404";//用户未登录，请先登录
	
}

package com.vector.tfriend.helper;

/**
 * @author vector.huang
 * @date 2016年2月26日 上午11:48:49
 */
public interface StatusCode {

	/**
	 * 系统内部出错，抛出无法处理的异常，例如IOException，IllegalStateException等无处处理的异常。 <br >
	 * 处理方法： <br >
	 * ① 重试接口<br >
	 * ② 检查服务器是否错误的位置 <br >
	 * ③ 提示用户的说明需要友好一点<br >
	 */
	public static final int CODE_SYSTEM_ERROR = -1;
	/** 成功 */
	public static final int CODE_SUCCESS = 0;
	/** 未知错误 */
	public static final int CODE_UNKNOW_ERROR = 1;
	/** 请求参数有误 */
	public static final int CODE_PARAM_INCORRECT = 2;
	/** 记录找不到 */
	public static final int CODE_RECORD_NOT_FOUND = 3;
	/** 请求方式出错 */
	public static final int CODE_REQUEST_MODEL_ERROR = 4;
    /** 没有权限，例如有一些操作是需要管理员才能操作的 */
    public static final int CODE_NOT_PERMISSION = 5;
    /** token 过期了，请重新登录 */
    public static final int CODE_NOT_LOGIN = 6;

}

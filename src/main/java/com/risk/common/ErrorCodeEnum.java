package com.risk.common;

public enum ErrorCodeEnum {
	
	op_success(1,"操作成功"),
	illegal_para(1000, "非法参数"),
	not_exist(1001, "数据不存在"),
	login_timeout(-100,"登录超时"),
	illegal_password(1100,"密码错误");
	
	
	private int errorCode;
	
	
	private String errorMsg;

	private ErrorCodeEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
}

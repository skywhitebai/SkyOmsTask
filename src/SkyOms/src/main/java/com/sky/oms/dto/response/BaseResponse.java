package com.sky.oms.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseResponse <T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 操作成功编码
	 */
	public static final String SUCCESS_CODE = "200";
	/**
	 * 操作失败编码
	 */
	public static final String FAIL_CODE = "99";
	private static final String SUCCESS_MESSAGE="操作成功";
	private static final String FAIL_MESSAGE="操作失败";
	private String code;

	/**
	 * 信息
	 */
	private String message;
	/**
	 * 详细信息
	 */
	private String detailMessage;
	/**
	 * 响应其他数据
	 */
	private T data;
public static BaseResponse success() {
		
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(SUCCESS_CODE);
		baseResponse.setMessage("操作成功");
		return baseResponse;
	}

	public static BaseResponse success(String message, Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(SUCCESS_CODE);
		baseResponse.setMessage(SUCCESS_MESSAGE);
		baseResponse.setData(data);
		return baseResponse;
	}

	public static BaseResponse successMessage(String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(SUCCESS_CODE);
		baseResponse.setMessage(message);
		return baseResponse;
	}

	public static BaseResponse successData(Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(SUCCESS_CODE);
		baseResponse.setMessage(SUCCESS_MESSAGE);
		baseResponse.setData(data);
		return baseResponse;
	}

	public static BaseResponse fail() {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(FAIL_CODE);
		baseResponse.setMessage(FAIL_MESSAGE);
		return baseResponse;
	}

	public static BaseResponse failMessage(String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(FAIL_CODE);
		baseResponse.setMessage(message);
		return baseResponse;
	}

	public static BaseResponse fail(String code, String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(code);
		baseResponse.setMessage(message);
		return baseResponse;
	}
}

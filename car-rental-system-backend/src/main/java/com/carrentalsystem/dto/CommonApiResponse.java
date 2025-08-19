package com.carrentalsystem.dto;

// API 共通レスポンス用 DTO
public class CommonApiResponse {

	private String responseMessage; // レスポンスメッセージ

	private boolean isSuccess; // 成功フラグ（true=成功, false=失敗）

	// --- Getter & Setter ---
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}

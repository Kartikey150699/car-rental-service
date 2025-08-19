package com.carrentalsystem.dto;

// ユーザーステータス更新用リクエスト DTO
public class UserStatusUpdateRequestDto {

	private int userId; // ユーザー ID

	private String status; // 更新後のステータス（ACTIVE / INACTIVE など）

	// --- Getter & Setter ---
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

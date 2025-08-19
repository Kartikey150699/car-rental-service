package com.carrentalsystem.dto;

// ユーザーログイン用リクエスト DTO
public class UserLoginRequest {

	private String emailId; // メールアドレス

	private String password; // パスワード

	private String role; // ロール（ユーザーの役割）

	// --- Getter & Setter ---
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

package com.carrentalsystem.dto;

// ログイン成功時のレスポンス DTO（共通レスポンスを継承）
public class UserLoginResponse extends CommonApiResponse {

	private UserDto user; // ログインしたユーザー情報

	private String jwtToken; // 認証用 JWT トークン

	// --- Getter & Setter ---
	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

}

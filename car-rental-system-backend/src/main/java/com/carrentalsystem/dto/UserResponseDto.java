package com.carrentalsystem.dto;

import java.util.ArrayList;
import java.util.List;

// ユーザー一覧を返すレスポンス DTO（共通レスポンスを継承）
public class UserResponseDto extends CommonApiResponse {

	private List<UserDto> users = new ArrayList<>(); // ユーザーリスト

	// --- Getter & Setter ---
	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}

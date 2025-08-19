package com.carrentalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.carrentalsystem.entity.User;
import com.carrentalsystem.service.UserService;
import com.carrentalsystem.utility.Constants.ActiveStatus;


// Spring Security でユーザー認証に利用されるサービスクラス
@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService; // ユーザー情報を取得するサービス

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// メールアドレスでユーザーを検索（有効状態のみ）
		User user = this.userService.getUserByEmailAndStatus(email, ActiveStatus.ACTIVE.value());

		// User エンティティを CustomUserDetails に変換
		CustomUserDetails customUserDetails = new CustomUserDetails(user);

		return customUserDetails; // Spring Security に返す
	}
}

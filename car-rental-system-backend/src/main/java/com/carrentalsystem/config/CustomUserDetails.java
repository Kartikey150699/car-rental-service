package com.carrentalsystem.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.carrentalsystem.entity.User;


// Spring Security の認証用ユーザー情報を保持するクラス
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
    private String email; // ユーザーのメールアドレス
    private String password; // ユーザーのパスワード
    private List<GrantedAuthority> authorities; // 権限（ロール）のリスト

    // User エンティティから認証用の情報を作成
    public CustomUserDetails(User user) {
    	email=user.getEmailId();
        password=user.getPassword();
        
        authorities = new ArrayList<>();
        
        String[] roles = user.getRole().split(","); // 複数ロールをカンマで分割
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role)); // 権限を追加
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // ユーザーの権限を返す
    }

    @Override
    public String getPassword() {
        return password; // ユーザーのパスワードを返す
    }

    @Override
    public String getUsername() {
        return email; // ユーザー名としてメールアドレスを返す
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // アカウントが有効期限切れでない
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // アカウントがロックされていない
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 資格情報が有効期限切れでない
    }

    @Override
    public boolean isEnabled() {
        return true; // アカウントが有効
    }
}

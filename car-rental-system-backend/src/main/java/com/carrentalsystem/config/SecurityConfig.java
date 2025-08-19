package com.carrentalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.carrentalsystem.filter.JwtAuthFilter;

@Configuration // 設定クラスであることを示す
@EnableWebSecurity // Spring Security を有効化
@EnableMethodSecurity // メソッド単位のセキュリティを有効化
public class SecurityConfig {

	@Autowired
	private JwtAuthFilter authFilter; // JWT 認証用フィルター
	
	@Bean
	// 認証時に使用する UserDetailsService を定義
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable()) // CSRF & CORS を無効化

		// API の認可設定
		.authorizeHttpRequests(auth -> auth.requestMatchers("/api/user/login", "/api/user/register").permitAll()
				// 上記の API は認証不要でアクセス可能
				
				.anyRequest().permitAll()) // その他の API も現在は全て許可
				
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
				// セッションを使わずステートレスで管理

		http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		// 認証処理の前に JWT フィルターを実行

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // パスワードを暗号化するエンコーダ
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService()); // ユーザー情報の取得方法を設定
		authenticationProvider.setPasswordEncoder(passwordEncoder()); // パスワードの暗号化方式を設定
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		// AuthenticationManager を Spring に提供
		return config.getAuthenticationManager();
	}

}

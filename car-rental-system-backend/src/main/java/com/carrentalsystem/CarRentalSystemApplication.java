package com.carrentalsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.carrentalsystem.entity.User;
import com.carrentalsystem.service.UserService;
import com.carrentalsystem.utility.Constants.ActiveStatus;
import com.carrentalsystem.utility.Constants.UserRole;

@SpringBootApplication // Spring Boot アプリケーションのエントリポイントを示す
public class CarRentalSystemApplication implements CommandLineRunner {
	
	private final Logger LOG = LoggerFactory.getLogger(CarRentalSystemApplication.class); 
	// ログ出力のための Logger を定義
	
	@Autowired
	private UserService userService; 
	// ユーザー関連の処理を行うサービスを注入

	@Autowired
	private PasswordEncoder passwordEncoder; 
	// パスワード暗号化用のエンコーダを注入

	public static void main(String[] args) {
		SpringApplication.run(CarRentalSystemApplication.class, args); 
		// アプリケーションを起動
	}

	@Override
	public void run(String... args) throws Exception {
		// アプリケーション起動後に実行される処理
		
		User admin = this.userService.getUserByEmailIdAndRoleAndStatus("demo.admin@demo.com",
				UserRole.ROLE_ADMIN.value(), ActiveStatus.ACTIVE.value());
		// デフォルト管理者が存在するかどうかを確認

		if (admin == null) {
			// 管理者が存在しない場合の処理

			LOG.info("Admin not found in system, so adding default admin"); 
			// 管理者がいないことをログに記録

			User user = new User();
			user.setEmailId("demo.admin@demo.com"); // 管理者のメールアドレスを設定
			user.setPassword(passwordEncoder.encode("123456")); // パスワードを暗号化して設定
			user.setRole(UserRole.ROLE_ADMIN.value()); // 管理者ロールを設定
			user.setStatus(ActiveStatus.ACTIVE.value()); // 有効状態を設定

			this.userService.addUser(user); 
			// デフォルト管理者を追加

		}
		
	}

}

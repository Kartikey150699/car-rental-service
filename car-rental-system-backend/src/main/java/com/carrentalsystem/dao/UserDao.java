package com.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.User;

@Repository // User エンティティ用のリポジトリ（DB アクセスを担当）
public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmailId(String email); // メールアドレスでユーザーを検索

	User findByEmailIdAndStatus(String email, String status); // メールアドレスとステータスで検索

	User findByRoleAndStatusIn(String role, List<String> status); // ロールと複数ステータスで検索

	List<User> findByRole(String role); // ロールごとのユーザー一覧を取得

	User findByEmailIdAndRoleAndStatus(String emailId, String role, String status); // メール・ロール・ステータスで検索

	List<User> findByRoleAndStatus(String role, String status); // ロールとステータスで検索

}

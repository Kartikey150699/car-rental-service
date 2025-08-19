package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.UserDao;
import com.carrentalsystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	// User データアクセスオブジェクトを注入
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		// 新しいユーザーを保存
		return userDao.save(user);
	}

	@Override
	public User updateUser(User user) {
		// ユーザー情報を更新
		return userDao.save(user);
	}

	@Override
	public User getUserByEmailAndStatus(String emailId, String status) {
		// メールアドレスとステータスでユーザーを検索
		return userDao.findByEmailIdAndStatus(emailId, status);
	}

	@Override
	public User getUserByEmailid(String emailId) {
		// メールアドレスでユーザーを検索
		return userDao.findByEmailId(emailId);
	}

	@Override
	public List<User> getUserByRole(String role) {
		// 役割でユーザーを検索
		return userDao.findByRole(role);
	}

	@Override
	public User getUserById(int userId) {
		// IDでユーザーを検索（存在しない場合は null を返す）
		Optional<User> optionalUser = this.userDao.findById(userId);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	@Override
	public User getUserByEmailIdAndRoleAndStatus(String emailId, String role, String status) {
		// メールアドレス、役割、ステータスでユーザーを検索
		return this.userDao.findByEmailIdAndRoleAndStatus(emailId, role, status);
	}

	@Override
	public List<User> updateAllUser(List<User> users) {
		// 複数のユーザー情報を更新
		return this.userDao.saveAll(users);
	}

	@Override
	public List<User> getUserByRoleAndStatus(String role, String status) {
		// 役割とステータスでユーザーを検索
		return this.userDao.findByRoleAndStatus(role, status);
	}
	
}

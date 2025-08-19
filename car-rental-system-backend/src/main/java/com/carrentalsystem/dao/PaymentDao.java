package com.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.Payment;
import com.carrentalsystem.entity.User;

@Repository // Payment エンティティ用のリポジトリ（DB アクセスを担当）
public interface PaymentDao extends JpaRepository<Payment, Integer> {

	Payment findByBookingId(String bookingId); // 予約 ID で支払い情報を検索
	
	Payment findByTransactionRefId(String transactionId); // 取引参照 ID で支払い情報を検索

	List<Payment> findByCustomer(User user); // 顧客ごとの支払い履歴を取得
	
}

package com.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.Booking;
import com.carrentalsystem.entity.User;
import com.carrentalsystem.entity.Vehicle;

@Repository // Booking エンティティ用のリポジトリ（DB アクセスを担当）
public interface BookingDao extends JpaRepository<Booking, Integer> {

	Booking findByBookingId(String bookingId); // 予約 ID で予約を検索

	List<Booking> findByCustomer(User customer); // 顧客ごとの予約を取得

	List<Booking> findByStatus(String status); // ステータスごとの予約を取得

	List<Booking> findByVehicle(Vehicle vehicle); // 車両ごとの予約を取得

}

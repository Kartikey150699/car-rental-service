package com.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.Variant;
import com.carrentalsystem.entity.Vehicle;

@Repository // Vehicle エンティティ用のリポジトリ（DB アクセスを担当）
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByVariantAndStatus(Variant variant, String status); // バリアントとステータスで車両を検索
	
	List<Vehicle> findByStatus(String status); // ステータスごとの車両を取得

}

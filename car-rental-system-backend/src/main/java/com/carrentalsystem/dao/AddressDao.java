package com.carrentalsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.Address;

@Repository // Address エンティティ用のリポジトリ（DB アクセスを担当）
public interface AddressDao extends JpaRepository<Address, Integer> {
	// JpaRepository を継承することで基本的な CRUD 操作を利用可能
}

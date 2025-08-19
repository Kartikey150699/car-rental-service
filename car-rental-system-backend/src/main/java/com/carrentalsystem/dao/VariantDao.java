package com.carrentalsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.entity.Company;
import com.carrentalsystem.entity.Variant;

@Repository // Variant エンティティ用のリポジトリ（DB アクセスを担当）
public interface VariantDao extends JpaRepository<Variant, Integer>{
	
	List<Variant> findByCompany(Company company); // 会社ごとのバリアントを取得
	
	List<Variant> findByCompanyAndStatus(Company company, String status); // 会社とステータスでバリアントを検索
	
	List<Variant> findByStatus(String status); // ステータスごとのバリアントを取得
	
	List<Variant> findByNameContainingIgnoreCaseAndStatus(String variantName, String status); // 名前部分一致（大文字小文字無視）＋ステータスで検索

}

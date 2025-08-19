package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carrentalsystem.dao.VariantDao;
import com.carrentalsystem.entity.Company;
import com.carrentalsystem.entity.Variant;

@Repository
public class VariantServiceImpl implements VariantService {

	// Variant データアクセスオブジェクトを注入
	@Autowired
	private VariantDao variantDao;

	@Override
	public Variant addVariant(Variant variant) {
		// 新しいバリアントを保存
		return variantDao.save(variant);
	}

	@Override
	public Variant updateVariant(Variant variant) {
		// バリアント情報を更新
		return variantDao.save(variant);
	}

	@Override
	public Variant getById(int variantId) {
		// IDでバリアントを検索（存在しない場合は null を返す）
		Optional<Variant> optional = variantDao.findById(variantId);

		if (optional.isPresent()) {
			return optional.get();
		}

		return null;
	}

	@Override
	public List<Variant> getByCompany(Company company) {
		// 会社に紐づくバリアント一覧を取得
		return this.variantDao.findByCompany(company);
	}

	@Override
	public List<Variant> getByCompanyAndStatus(Company company, String status) {
		// 会社とステータスに基づいてバリアントを検索
		return this.variantDao.findByCompanyAndStatus(company, status);
	}

	@Override
	public List<Variant> getByStatus(String status) {
		// ステータスでバリアントを検索
		return this.variantDao.findByStatus(status);
	}

	@Override
	public List<Variant> searchByVariants(String variantName, String status) {
		// バリアント名とステータスで検索（大文字小文字を無視）
		return this.variantDao.findByNameContainingIgnoreCaseAndStatus(variantName, status);
	}

}

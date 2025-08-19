package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.CompanyDao;
import com.carrentalsystem.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company addCompany(Company company) {
		// 新しい会社を追加
		return companyDao.save(company);
	}

	@Override
	public Company updateCompany(Company company) {
		// 既存の会社を更新
		return companyDao.save(company);
	}

	@Override
	public Company getById(int companyId) {
		// IDで会社を取得
		Optional<Company> optional = companyDao.findById(companyId);

		if (optional.isPresent()) {
			return optional.get();
		}

		// 見つからない場合は null を返す
		return null;
	}

	@Override
	public List<Company> getAllCompany() {
		// 全ての会社を取得
		return companyDao.findAll();
	}

}

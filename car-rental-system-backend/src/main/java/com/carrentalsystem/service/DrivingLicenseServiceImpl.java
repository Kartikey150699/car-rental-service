package com.carrentalsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.DrivingLicenseDao;
import com.carrentalsystem.entity.DrivingLicense;

@Service
public class DrivingLicenseServiceImpl implements DrivingLicenseService {

	@Autowired
	private DrivingLicenseDao drivingLicenseDao;

	@Override
	public DrivingLicense addLicense(DrivingLicense drivingLicense) {
		// 新しい運転免許証を追加
		return drivingLicenseDao.save(drivingLicense);
	}

	@Override
	public DrivingLicense updateLicense(DrivingLicense drivingLicense) {
		// 運転免許証を更新
		return drivingLicenseDao.save(drivingLicense);
	}

	@Override
	public DrivingLicense getById(int licenseId) {
		// IDで運転免許証を取得
		Optional<DrivingLicense> optional = drivingLicenseDao.findById(licenseId);

		if (optional.isPresent()) {
			return optional.get();
		}

		// 見つからない場合は null を返す
		return null;
	}

}

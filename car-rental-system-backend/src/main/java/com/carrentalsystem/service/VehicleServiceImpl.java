package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.VehicleDao;
import com.carrentalsystem.entity.Variant;
import com.carrentalsystem.entity.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	// Vehicle データアクセスオブジェクトを注入
	@Autowired
	private VehicleDao vehicleDao;
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		// 新しい車両を保存
		return vehicleDao.save(vehicle);
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		// 車両情報を更新
		return vehicleDao.save(vehicle);
	}

	@Override
	public Vehicle getById(int vehicleId) {
		// IDで車両を検索（存在しない場合は null を返す）
		Optional<Vehicle> optional = this.vehicleDao.findById(vehicleId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public List<Vehicle> getByVariantAndStatus(Variant variant, String status) {
		// バリアントとステータスで車両を検索
		return vehicleDao.findByVariantAndStatus(variant, status);
	}

	@Override
	public List<Vehicle> getByStatus(String status) {
		// ステータスで車両を検索
		return vehicleDao.findByStatus(status);
	}

}

package com.carrentalsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.entity.Vehicle;

// 車両情報のレスポンス DTO（共通レスポンスを継承）
public class VehicleResponse extends CommonApiResponse {

	private List<Vehicle> vehicles = new ArrayList<>(); // 車両一覧

	// --- Getter & Setter ---
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}

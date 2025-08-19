package com.carrentalsystem.dto;

// 車両を追加・更新するためのリクエスト DTO
public class AddVehicleRequest {

	private Integer vehicleId; // 車両 ID

	private String registrationNumber; // 登録番号（ナンバープレート）

	private Integer variantId; // バリアント ID

	// --- Getter & Setter ---
	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

}

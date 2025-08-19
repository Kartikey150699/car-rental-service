package com.carrentalsystem.dto;

import org.springframework.web.multipart.MultipartFile;

// 顧客の運転免許証情報を追加するためのリクエスト DTO
public class AddDrivingLicenseRequest {

	private Integer customerId; // 顧客 ID

	private String licenseNumber; // 免許証番号

	private String expirationDate; // 有効期限

	private MultipartFile licensePic; // 免許証画像ファイル

	// --- Getter & Setter ---
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public MultipartFile getLicensePic() {
		return licensePic;
	}

	public void setLicensePic(MultipartFile licensePic) {
		this.licensePic = licensePic;
	}

}

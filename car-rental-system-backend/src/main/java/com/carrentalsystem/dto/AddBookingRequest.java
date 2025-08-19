package com.carrentalsystem.dto;

public class AddBookingRequest {

	// *** 予約追加リクエスト用フィールド ***
	private String startDate; // 予約開始日（文字列形式の LocalDate）

	private String endDate; // 予約終了日

	private Integer customerId; // 顧客 ID

	private Integer variantId; // 車両バリアント ID
	// *** end ***

	// *** 予約更新/管理用フィールド ***
	private Integer bookingId; // 予約 ID

	private String status; // 予約ステータス

	private Integer vehicleId; // 車両 ID
	// *** end ***

	// --- Getter & Setter ---
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getVariantId() {
		return variantId;
	}

	public void setVariantId(Integer variantId) {
		this.variantId = variantId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

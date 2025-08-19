package com.carrentalsystem.dto;

// 顧客の予約支払い情報を送信するためのリクエスト DTO
public class CustomerBookingPaymentRequest {

	private Integer bookingId; // 予約 ID

	private String nameOnCard; // カード名義人

	private String cardNo; // カード番号

	private String cvv; // セキュリティコード (CVV)

	private String expiryDate; // 有効期限

	// --- Getter & Setter ---
	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

}

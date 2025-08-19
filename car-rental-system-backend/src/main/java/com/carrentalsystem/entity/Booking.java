package com.carrentalsystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity // 予約情報を表すエンティティ
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー自動採番
	private int id; // 予約 ID（内部管理用）

	private String bookingId; // 外部公開用の予約番号

	private String startDate; // 開始日（文字列形式 LocalDate）

	private String endDate; // 終了日

	private String bookingTime; // 予約日時（ミリ秒形式）

	private int totalDay; // 予約日数

	private BigDecimal totalPrice; // 合計金額

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User customer; // 顧客情報（User との関連）

	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle; // 車両情報（Vehicle との関連）

	@ManyToOne
	@JoinColumn(name = "variant_id")
	private Variant variant; // 車両バリアント情報（Variant との関連）

	@OneToOne
	@JoinColumn(name = "payment_id")
	private Payment payment; // 支払い情報（Payment との関連）

	private String status; // 予約ステータス

	// --- Getter & Setter ---
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

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

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

}

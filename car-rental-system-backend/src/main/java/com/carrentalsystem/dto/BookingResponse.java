package com.carrentalsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.entity.Booking;

// 予約情報のレスポンス DTO（共通レスポンスを継承）
public class BookingResponse extends CommonApiResponse {

	private List<Booking> bookings = new ArrayList<>(); // 予約リスト

	// --- Getter & Setter ---
	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}

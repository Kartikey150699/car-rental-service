package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.dto.AddBookingRequest;
import com.carrentalsystem.dto.BookingResponse;
import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.CustomerBookingPaymentRequest;
import com.carrentalsystem.resource.BookingResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController // REST API を提供するコントローラー
@RequestMapping("api/booking") // booking 関連の API のルートパス
@CrossOrigin(origins = "http://localhost:3000") // フロントエンド (React) との通信を許可
public class BookingController {

	@Autowired
	private BookingResource bookingResource; // ビジネスロジックを扱うリソースクラス

	@PostMapping("/add")
	@Operation(summary = "顧客がレンタル予約を追加する API")
	public ResponseEntity<CommonApiResponse> addRentBook(@RequestBody AddBookingRequest request) {
		return bookingResource.addBooking(request);
	}

	@PutMapping("/update/assign/vehicle")
	@Operation(summary = "予約ステータスを更新し、車両を割り当てる API")
	public ResponseEntity<CommonApiResponse> updateStatusAndAssignVehicle(@RequestBody AddBookingRequest request) {
		return bookingResource.updateStatusAndAssignVehicle(request);
	}

	@GetMapping("/fetch/all")
	@Operation(summary = "全ての予約を取得する API")
	public ResponseEntity<BookingResponse> fetchAllBookings() {
		return bookingResource.fetchAllBookings();
	}

	@GetMapping("/fetch/customer-wise")
	@Operation(summary = "顧客ごとの予約を取得する API")
	public ResponseEntity<BookingResponse> fetchAllCustomerBookings(@RequestParam("customerId") Integer customerId) {
		return bookingResource.fetchAllCustomerBookings(customerId);
	}
	
	@DeleteMapping("/cancel")
	@Operation(summary = "予約をキャンセルする API")
	public ResponseEntity<CommonApiResponse> cancelbooking(@RequestBody AddBookingRequest request) {
		return bookingResource.cancelbooking(request);
	}

	@PutMapping("/customer/payment")
	@Operation(summary = "顧客の予約に対する支払い API")
	public ResponseEntity<CommonApiResponse> customerPaymentForBooking(
			@RequestBody CustomerBookingPaymentRequest request) {
		return bookingResource.customerPaymentForBooking(request);
	}

}

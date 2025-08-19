package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.BookingDao;
import com.carrentalsystem.entity.Booking;
import com.carrentalsystem.entity.User;
import com.carrentalsystem.entity.Vehicle;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public Booking addBooking(Booking booking) {
		// 新しい予約を追加
		return bookingDao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// 既存の予約を更新
		return bookingDao.save(booking);
	}

	@Override
	public Booking getById(int bookingId) {
		// IDで予約を取得
		Optional<Booking> optional = bookingDao.findById(bookingId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		// 見つからない場合は null を返す
		return null;
	}

	@Override
	public Booking getByBookingId(String bookingId) {
		// 予約番号で予約を取得
		return bookingDao.findByBookingId(bookingId);
	}

	@Override
	public List<Booking> getByCustomer(User customer) {
		// 顧客ごとの予約を取得
		return bookingDao.findByCustomer(customer);
	}

	@Override
	public List<Booking> getByStatus(String status) {
		// ステータスごとの予約を取得
		return bookingDao.findByStatus(status);
	}

	@Override
	public List<Booking> getByVehicle(Vehicle vehicle) {
		// 車両ごとの予約を取得
		return bookingDao.findByVehicle(vehicle);
	}

	@Override
	public List<Booking> getAllBookings() {
		// すべての予約を取得
		return bookingDao.findAll();
	}

}

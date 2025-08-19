package com.carrentalsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrentalsystem.dao.PaymentDao;
import com.carrentalsystem.entity.Payment;
import com.carrentalsystem.entity.User;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	
	@Override
	public Payment addPayment(Payment payment) {
		// 新しい支払いを追加
		return paymentDao.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment) {
		// 支払いを更新
		return paymentDao.save(payment);
	}

	@Override
	public Payment getById(int paymentId) {
		// IDで支払いを取得
		Optional<Payment> optional = paymentDao.findById(paymentId);

		if (optional.isPresent()) {
			return optional.get();
		}

		// 見つからない場合は null を返す
		return null;
	}

	@Override
	public Payment getByBookingId(String bookingId) {
		// 予約IDで支払いを取得
		return paymentDao.findByBookingId(bookingId);
	}

	@Override
	public Payment getByTransactionRefId(String transactionId) {
		// 取引参照IDで支払いを取得
		return paymentDao.findByTransactionRefId(transactionId);
	}

	@Override
	public List<Payment> getByCustomer(User user) {
		// 顧客ごとの支払い一覧を取得
		return paymentDao.findByCustomer(user);
	}

}

package com.carrentalsystem.dto;

import org.springframework.beans.BeanUtils;

import com.carrentalsystem.entity.User;

// ユーザー登録用のリクエスト DTO
public class RegisterUserRequestDto {

	private String firstName; // 名

	private String lastName; // 姓

	private String emailId; // メールアドレス

	private String password; // パスワード

	private String phoneNo; // 電話番号

	private String role; // ユーザーの役割（Admin, Customer, Seller など）

	private String street; // 住所（番地）

	private String city; // 住所（市区町村）

	private int pincode; // 郵便番号

	// --- Getter & Setter ---
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	// DTO を User エンティティに変換するユーティリティメソッド
	public static User toUserEntity(RegisterUserRequestDto registerUserRequestDto) {
		User user = new User();
		BeanUtils.copyProperties(registerUserRequestDto, user);
		return user;
	}

}

package com.carrentalsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity // ユーザー情報を表すエンティティ
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー自動採番
	private int id; // ユーザーID

	private String firstName; // 名

	private String lastName; // 姓

	private String emailId; // メールアドレス

	@JsonIgnore // セキュリティのためパスワードをJSONに含めない
	private String password; // パスワード

	private String phoneNo; // 電話番号

	private String role; // ユーザーの役割（例：管理者、顧客）

	@ManyToOne
	@JoinColumn(name = "address_id") // 複数のユーザーが同じ住所を持つ可能性あり
	private Address address; // 住所情報

	@OneToOne
	@JoinColumn(name = "license_id") // 1ユーザーにつき1つの免許証
	private DrivingLicense license; // 運転免許証情報

	private String status; // ユーザー状態（例：有効、無効）

	// --- Getter & Setter ---
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DrivingLicense getLicense() {
		return license;
	}

	public void setLicense(DrivingLicense license) {
		this.license = license;
	}

}

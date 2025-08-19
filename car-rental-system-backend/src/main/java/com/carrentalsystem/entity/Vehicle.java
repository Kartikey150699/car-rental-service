package com.carrentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // 車両情報を表すエンティティ
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー自動採番
	private int id; // 車両ID

	private String registrationNumber; // 登録番号（ナンバープレート）

	@ManyToOne
	@JoinColumn(name = "variant_id") // 複数の車両が同じバリエーションに属する
	private Variant variant; // 車両のバリエーション（モデル情報）

	private String status; // 状態（例：利用可能、整備中、貸出中）

	// --- Getter & Setter ---
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

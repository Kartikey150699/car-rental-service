package com.carrentalsystem.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // 車両バリエーションを表すエンティティ
public class Variant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー自動採番
	private int id; // バリエーションID

	private String name; // 車両名（例：Corolla、Civicなど）

	private String description; // 説明文

	private String modelNumber; // モデル番号

	private int year; // 製造年

	private String fuelType; // 燃料タイプ（例：ガソリン、ディーゼル、EV）

	private boolean isAC; // エアコン有無

	private int seatingCapacity; // 座席数

	private BigDecimal pricePerDay; // 1日あたりのレンタル料金

	@ManyToOne
	@JoinColumn(name = "company_id") // 各バリエーションは特定の会社に所属
	private Company company; // メーカー会社情報

	private String status; // バリエーションの状態（例：利用可能、停止中）

	private String image; // 車両画像のパスまたはURL

	// --- Getter & Setter ---
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public boolean isAC() {
		return isAC;
	}

	public void setAC(boolean isAC) {
		this.isAC = isAC;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

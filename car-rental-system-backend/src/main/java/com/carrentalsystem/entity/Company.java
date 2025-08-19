package com.carrentalsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // 会社情報を表すエンティティ
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主キー自動採番
	private int id; // 会社 ID

	private String name; // 会社名

	private String description; // 会社の説明

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

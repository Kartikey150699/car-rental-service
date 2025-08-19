package com.carrentalsystem.dto;

import java.util.ArrayList;
import java.util.List;

import com.carrentalsystem.entity.Company;

// 会社情報のレスポンス DTO（共通レスポンスを継承）
public class CompanyResponse extends CommonApiResponse {

	List<Company> companies = new ArrayList<>(); // 会社リスト

	// --- Getter & Setter ---
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

}

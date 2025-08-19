package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.CompanyResponse;
import com.carrentalsystem.entity.Company;
import com.carrentalsystem.resource.CompanyResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController // REST API コントローラー
@RequestMapping("api/company") // company 関連の API のルート
@CrossOrigin(origins = "http://localhost:3000") // フロントエンド (React) からの通信を許可
public class CompanyController {

	@Autowired
	private CompanyResource companyResource; // 会社情報を扱うリソースクラス

	@PostMapping("/add")
	@Operation(summary = "会社を追加する API")
	public ResponseEntity<CommonApiResponse> addCompany(@RequestBody Company company) {
		return companyResource.addCompany(company);
	}

	@GetMapping("/fetch/all")
	@Operation(summary = "全ての会社情報を取得する API")
	public ResponseEntity<CompanyResponse> fetchAllCompany() {
		return companyResource.fetchAllCompany();
	}

	@PutMapping("/udpate")
	@Operation(summary = "会社情報を更新する API")
	public ResponseEntity<CommonApiResponse> updateCompany(@RequestBody Company company) {
		return companyResource.updateCompany(company);
	}

}

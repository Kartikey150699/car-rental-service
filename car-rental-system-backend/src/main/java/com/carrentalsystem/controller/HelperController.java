package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.resource.HelperResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController // REST API コントローラー
@RequestMapping("api/car/rental/helper") // helper 関連 API のルート
@CrossOrigin(origins = "http://localhost:3000") // フロントエンド (React) からの通信を許可
public class HelperController {
	
	@Autowired
	private HelperResource helperResource; // 補助データを扱うリソース
	
	@GetMapping("/fetch/fuel-type")
	@Operation(summary = "燃料タイプを全件取得する API")
	public ResponseEntity fetchAllFuelType() {
		return helperResource.fetchAllFuelType();
	}

}

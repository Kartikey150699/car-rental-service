package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.VariantAddRequest;
import com.carrentalsystem.dto.VariantResponse;
import com.carrentalsystem.resource.VariantResource;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;

@RestController // REST API コントローラー
@RequestMapping("api/variant") // variant 関連 API のルート
@CrossOrigin(origins = "http://localhost:3000") // フロントエンドからの通信を許可
public class VariantController {

	@Autowired
	private VariantResource variantResource; // 車両バリアントを扱うリソース

	@PostMapping("/add")
	@Operation(summary = "バリアントを追加する API")
	public ResponseEntity<CommonApiResponse> addVariant(VariantAddRequest request) {
		return variantResource.addVariant(request);
	}

	@GetMapping("/fetch/all")
	@Operation(summary = "全ての有効なバリアントを取得する API")
	public ResponseEntity<VariantResponse> fetchAllCompany() {
		return variantResource.fetchAllVariant();
	}

	@GetMapping("/fetch")
	@Operation(summary = "ID でバリアントを取得する API")
	public ResponseEntity<VariantResponse> fetchVariantByID(@RequestParam("variantId") int variantId) {
		return variantResource.fetchVariantByID(variantId);
	}

	@GetMapping("/fetch/company-wise")
	@Operation(summary = "会社ごとのバリアントを取得する API")
	public ResponseEntity<VariantResponse> fetchVariantsByCompany(@RequestParam("companyId") int companyId) {
		return variantResource.fetchVariantsByCompany(companyId);
	}

	@GetMapping("/search")
	@Operation(summary = "バリアント名で検索する API")
	public ResponseEntity<VariantResponse> searchVariants(@RequestParam("variantName") String variantName) {
		return variantResource.searchVariants(variantName);
	}
	
	@GetMapping(value = "/{variantImage}", produces = "image/*")
	@Operation(summary = "バリアント画像を取得する API")
	public void fetchProductImage(@PathVariable("variantImage") String variantImage, HttpServletResponse resp) {
		this.variantResource.fetchVariantImage(variantImage, resp);
	}
	
	@PutMapping("/update")
	@Operation(summary = "バリアントを更新する API")
	public ResponseEntity<CommonApiResponse> updateVariant(VariantAddRequest request) {
		return variantResource.updateVariant(request);
	}
	
	@DeleteMapping("/delete")
	@Operation(summary = "バリアントを削除する API")
	public ResponseEntity<CommonApiResponse> deleteVariant(@RequestParam("variantId") int variantId) {
		return variantResource.deleteVariant(variantId);
	}

}

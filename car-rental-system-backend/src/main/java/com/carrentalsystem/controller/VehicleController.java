package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.dto.AddVehicleRequest;
import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.VehicleResponse;
import com.carrentalsystem.resource.VehicleResource;

import io.swagger.v3.oas.annotations.Operation;

@RestController // REST API コントローラー
@RequestMapping("api/vehicle") // vehicle 関連 API のルート
@CrossOrigin(origins = "http://localhost:3000") // React フロントエンドからの通信を許可
public class VehicleController {

	@Autowired
	private VehicleResource vehicleResource; // 車両関連の処理を扱うリソース

	@PostMapping("/add")
	@Operation(summary = "車両を追加する API")
	public ResponseEntity<CommonApiResponse> addVehicle(@RequestBody AddVehicleRequest request) {
		return vehicleResource.addVehicle(request);
	}

	@GetMapping("/fetch/all")
	@Operation(summary = "全ての車両を取得する API")
	public ResponseEntity<VehicleResponse> fetchAllVehicles() {
		return vehicleResource.fetchAllVehicles();
	}

	@GetMapping("/fetch/variant-wise")
	@Operation(summary = "バリアント別に車両を取得する API")
	public ResponseEntity<VehicleResponse> fetchAllVehiclesByVariant(@RequestParam("variantId") Integer variantId) {
		return vehicleResource.fetchAllVehiclesByVariant(variantId);
	}

	@PutMapping("/udpate")
	@Operation(summary = "車両を更新する API")
	public ResponseEntity<CommonApiResponse> updateVehicle(@RequestBody AddVehicleRequest request) {
		return vehicleResource.updateVehicle(request);
	}

	@DeleteMapping("/delete")
	@Operation(summary = "車両を削除する API")
	public ResponseEntity<CommonApiResponse> deleteVehicle(@RequestParam("vehicleId") Integer vehicleId) {
		return vehicleResource.deleteVehicle(vehicleId);
	}

}

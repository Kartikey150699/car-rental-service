package com.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carrentalsystem.dto.AddDrivingLicenseRequest;
import com.carrentalsystem.dto.CommonApiResponse;
import com.carrentalsystem.dto.RegisterUserRequestDto;
import com.carrentalsystem.dto.UserLoginRequest;
import com.carrentalsystem.dto.UserLoginResponse;
import com.carrentalsystem.dto.UserResponseDto;
import com.carrentalsystem.dto.UserStatusUpdateRequestDto;
import com.carrentalsystem.resource.UserResource;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;

@RestController // REST API コントローラー
@RequestMapping("api/user") // user 関連 API のルート
@CrossOrigin(origins = "http://localhost:3000") // React からのアクセスを許可
public class UserController {

	@Autowired
	private UserResource userResource; // ユーザー関連の処理を担当するリソース

	@PostMapping("/admin/register")
	@Operation(summary = "管理者を登録する API")
	public ResponseEntity<CommonApiResponse> registerAdmin(@RequestBody RegisterUserRequestDto request) {
		return userResource.registerAdmin(request);
	}

	@PostMapping("register")
	@Operation(summary = "顧客または販売者を登録する API")
	public ResponseEntity<CommonApiResponse> registerUser(@RequestBody RegisterUserRequestDto request) {
		return this.userResource.registerUser(request);
	}

	@PostMapping("login")
	@Operation(summary = "ユーザーのログイン API")
	public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
		return userResource.login(userLoginRequest);
	}

	@GetMapping("/fetch/role-wise")
	@Operation(summary = "ロール別にユーザーを取得する API")
	public ResponseEntity<UserResponseDto> fetchAllUsersByRole(@RequestParam("role") String role)
			throws JsonProcessingException {
		return userResource.getUsersByRole(role);
	}

	@PutMapping("update/status")
	@Operation(summary = "ユーザーステータスを更新する API")
	public ResponseEntity<CommonApiResponse> updateUserStatus(@RequestBody UserStatusUpdateRequestDto request) {
		return userResource.updateUserStatus(request);
	}

	@GetMapping("/fetch/user-id")
	@Operation(summary = "ユーザー ID でユーザー詳細を取得する API")
	public ResponseEntity<UserResponseDto> fetchUserById(@RequestParam("userId") int userId) {
		return userResource.getUserById(userId);
	}

	@DeleteMapping("/delete/user-id")
	@Operation(summary = "ユーザー ID でユーザーを削除する API")
	public ResponseEntity<CommonApiResponse> deleteUserById(@RequestParam("userId") int userId) {
		return userResource.deleteUserById(userId);
	}

	@PostMapping("add/driving-licence")
	@Operation(summary = "顧客の運転免許証を追加する API")
	public ResponseEntity<CommonApiResponse> addCustomerDrivingLicense(AddDrivingLicenseRequest request) {
		return userResource.addCustomerDrivingLicense(request);
	}
	
	@GetMapping(value = "/{drivingLicense}", produces = "image/*")
	@Operation(summary = "免許証画像を取得する API")
	public void fetchProductImage(@PathVariable("drivingLicense") String drivingLicense, HttpServletResponse resp) {
		this.userResource.fetchDrivingLicenceImage(drivingLicense, resp);
	}

}

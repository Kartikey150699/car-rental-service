package com.carrentalsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.carrentalsystem.dto.CommonApiResponse;

@RestControllerAdvice // 全コントローラで発生した例外を横断的に処理するクラス
public class GlobalExceptionHandler {

	// --- UserNotFoundException を処理する ---
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<CommonApiResponse> handleUserNotFoundException(UserNotFoundException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage); // エラーメッセージをセット
		apiResponse.setSuccess(false); // 成功フラグを false に設定

		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR); // 500エラーを返却
	}

	// --- UserSaveFailedException を処理する ---
	@ExceptionHandler(UserSaveFailedException.class)
	public ResponseEntity<CommonApiResponse> handleUserRegistrationFailedException(UserSaveFailedException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// --- CompanySaveFailedException を処理する ---
	@ExceptionHandler(CompanySaveFailedException.class)
	public ResponseEntity<CommonApiResponse> handleCompanySaveFailedException(CompanySaveFailedException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// --- VariantSaveFailedException を処理する ---
	@ExceptionHandler(VariantSaveFailedException.class)
	public ResponseEntity<CommonApiResponse> handleVariantSaveFailedException(VariantSaveFailedException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// --- VehicleSaveFailedException を処理する ---
	@ExceptionHandler(VehicleSaveFailedException.class)
	public ResponseEntity<CommonApiResponse> handleVehicleSaveFailedException(VehicleSaveFailedException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// --- BookingSaveFailedException を処理する ---
	@ExceptionHandler(BookingSaveFailedException.class)
	public ResponseEntity<CommonApiResponse> handleBookingSaveFailedException(BookingSaveFailedException ex) {
		String responseMessage = ex.getMessage();

		CommonApiResponse apiResponse = new CommonApiResponse();
		apiResponse.setResponseMessage(responseMessage);
		apiResponse.setSuccess(false);
		return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

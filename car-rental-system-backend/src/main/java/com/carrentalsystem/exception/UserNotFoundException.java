package com.carrentalsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ユーザーがシステム内に存在しない場合にスローされる例外クラス。
 * 発生すると、HTTP 500 Internal Server Error が返されます。
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserNotFoundException extends RuntimeException {

	/**
	 * シリアル化用のバージョンUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * エラーメッセージを指定して例外を生成するコンストラクタ
	 * 
	 * @param message - 詳細なエラーメッセージ
	 */
	public UserNotFoundException(String message) {
		super(message);
	}

}

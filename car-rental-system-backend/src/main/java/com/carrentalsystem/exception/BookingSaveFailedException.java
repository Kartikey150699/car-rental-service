package com.carrentalsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // サーバ内部エラー（500）を返す
public class BookingSaveFailedException extends RuntimeException {

	/**
	 * シリアルバージョンUID（クラスの互換性を保つために必要）
	 */
	private static final long serialVersionUID = 1L;

	// 予約保存に失敗した場合に投げる例外
	public BookingSaveFailedException(String message) {
		super(message); // 親クラスのコンストラクタにメッセージを渡す
	}

}

package com.carrentalsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // サーバ内部エラー（500）を返す
public class CompanySaveFailedException extends RuntimeException {

	/**
	 * シリアルバージョンUID（クラスの互換性を保つために必要）
	 */
	private static final long serialVersionUID = 1L;

	// 会社情報の保存に失敗した場合に投げる例外
	public CompanySaveFailedException(String message) {
		super(message); // 親クラスのRuntimeExceptionにメッセージを渡す
	}

}

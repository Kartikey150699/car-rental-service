package com.carrentalsystem.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestHeaderInterceptor implements HandlerInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(RequestHeaderInterceptor.class);

	// コントローラーのハンドラーメソッドが呼ばれる前に実行される
	// 前処理を行うことができる
	// true を返すと処理が継続され、false を返すとリクエスト処理が中断される
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		LOG.info("preHandle() メソッドが呼び出されました");

		LOG.info("---------------- リクエスト開始 ---------------");
		LOG.info("リクエストURL: " + request.getRequestURI());
		LOG.info("HTTPメソッド: " + request.getMethod());

		return true;
	}

	// コントローラーの処理が完了した後、ビューのレンダリング前に呼ばれる
	// ハンドラーメソッド後に追加処理を行うことができる
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// LOG.info("postHandle() メソッドが呼び出されました");

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// リクエスト処理が完全に終了した後に呼ばれる
	// クリーンアップ処理やログ記録を行うのに適している
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		LOG.info("afterCompletion() メソッドが呼び出されました");

		LOG.info("リクエストURL: " + request.getRequestURI());
		LOG.info("HTTPメソッド: " + request.getMethod());
		LOG.info("レスポンスステータス: " + response.getStatus());
		LOG.info("---------------- リクエスト終了 ---------------");

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}

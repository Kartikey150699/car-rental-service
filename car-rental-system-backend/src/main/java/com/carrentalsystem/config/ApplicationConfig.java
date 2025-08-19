package com.carrentalsystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.carrentalsystem.interceptor.RequestHeaderInterceptor;


// インターセプターを設定するためのクラス
@Configuration // 設定クラスであることを示す
public class ApplicationConfig implements WebMvcConfigurer {
	
	@Autowired
	private RequestHeaderInterceptor requestHeaderInterceptor; 
	// リクエストヘッダーを処理するインターセプターを注入
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// インターセプターをアプリケーションに登録
		registry.addInterceptor(requestHeaderInterceptor);
	}

}

package com.carrentalsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration // 設定クラスであることを示す
public class SwaggerConfig {

	// Swagger UI を利用するためのエンドポイント
	// http://localhost:8080/swagger-ui/index.html

	@Bean
	public OpenAPI springShopOpenAPI() {
		// API ドキュメントの基本情報を定義
		return new OpenAPI()
				.info(new Info().title("Car Rental System Application") // タイトル
				.description("Car Rental Application using Spring Boot 3") // 説明
				.version("v0.0.1") // バージョン
				.license(new License() // ライセンス情報
				.name("Apache 2.0")
				.url("http://springdoc.org")))
				
				// 外部ドキュメントへのリンク
				.externalDocs(new ExternalDocumentation().description("Code With Murad")
				.url("https://codewithmurad.com"));
	}
	
	
}

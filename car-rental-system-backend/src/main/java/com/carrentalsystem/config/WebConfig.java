package com.carrentalsystem.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration // 設定クラスを表す
@EnableWebMvc // Spring MVC を有効化
public class WebConfig {

    private static final Long MAX_AGE = 3600L; // CORS 設定のキャッシュ有効時間（秒）
    private static final int CORS_FILTER_ORDER = -102; // フィルターの実行順序

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        // CORS 設定を行う
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 認証情報を許可
        config.addAllowedOrigin("http://localhost:3000"); // フロントエンドの許可ドメイン

        // 許可するリクエストヘッダー
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.AUTHORIZATION,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT));

        // 許可する HTTP メソッド
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name()));

        config.setMaxAge(MAX_AGE); // プリフライトリクエストの有効期間を設定

        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // Spring Security のフィルターより先に実行されるよう順序を設定
        bean.setOrder(CORS_FILTER_ORDER);
        return bean;
    }
}

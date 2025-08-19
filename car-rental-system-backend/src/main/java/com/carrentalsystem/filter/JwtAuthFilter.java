package com.carrentalsystem.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.carrentalsystem.config.CustomUserDetailsService;
import com.carrentalsystem.utility.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;  
    // JWTユーティリティクラス（トークンの検証やユーザー名抽出に使用）

    @Autowired
    private CustomUserDetailsService userDetailsService;  
    // ユーザー詳細情報を取得するサービス

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");  
        // リクエストヘッダーからAuthorizationを取得

        String token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);  
            // "Bearer " を除去してトークン本体を取得

            username = jwtUtils.extractUsername(token);  
            // トークンからユーザー名（ここではメールアドレス）を抽出
        }

        // 認証がまだ行われていない場合のみ処理
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);  
            // DBなどからユーザー情報を取得

            if (jwtUtils.validateToken(token, userDetails)) {  
                // トークンが有効な場合
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);  
                // Spring Securityに認証情報を設定
            }
        }

        // 次のフィルタに処理を渡す
        filterChain.doFilter(request, response);
    }
    
}

package com.carrentalsystem.utility;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

    // 秘密鍵（Base64 エンコードされた文字列）
    public static final String SECRET = "5aB3r1P8mNqRvKgY7cZxW9jF2hT6fU0eL4dS1aC3bXwVzE6tR8yH0jM5nQ8pZ2k";

    // トークンからユーザー名を抽出
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // トークンから有効期限を抽出
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // トークンから指定したクレームを抽出
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // トークンからすべてのクレームを抽出
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey()) // 署名キーを設定
                .build()
                .parseClaimsJws(token) // トークンを解析
                .getBody();
    }

    // トークンが期限切れかどうかを判定
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // トークンの検証（ユーザー名と有効期限の確認）
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // トークンを生成（ユーザー名を基に作成）
    public String generateToken(String userName){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    // トークン作成処理
    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims) // クレームを設定
                .setSubject(userName) // サブジェクト（ユーザー名）
                .setIssuedAt(new Date(System.currentTimeMillis())) // 発行日時
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 有効期限（30分）
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // HS256 アルゴリズムで署名
                .compact();
    }

    // 秘密鍵を取得（Base64 デコードして HMAC 用のキーを生成）
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

package com.generate.api.security.jwt;


import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.generate.api.security.model.UserEntity;
import com.generate.api.security.utils.UserRole;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtProvider {

	
	public static final String TOKEN_HEADER = "Authorization";
	public static final String TOKEN_PREFIX= "Bearer ";
	public static final String TOKEN_TYPE = "JWT";
	
	@Value("${jwt.secret: fUcKYou*|{}p0_secretJwt_apigenerateapplicationssjdfldsjfdsj84758947ehjrfksdhfkjdshfi37489w}")
	private String secret;
	
	@Value("${jwt.token-expiration:864000}")
	private int durationToken;
	
	public String generateToken(Authentication authetication) {
		UserEntity user = (UserEntity) authetication.getPrincipal();
		
		Date tokenExpirationDate = new Date(System.currentTimeMillis() + (durationToken * 1000));
		
		return Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS512)
				.setHeaderParam("type", TOKEN_TYPE)
				.setSubject(Long.toString(user.getId()))
				.setIssuedAt(new Date())
				.setExpiration(tokenExpirationDate)
				.claim("fullname", user.getUsername())
				.claim("roles", 
								user.getRoles()
								.stream()
								.map(UserRole::name)
								.collect(Collectors.joining(", "))
						)
				.compact();
	}
	
	public Long getUserIdByToken(String token) {
		Claims claims = Jwts.parser()
						.setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
						.parseClaimsJws(token)
						.getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
public boolean validateToken(String authToken) {
		
		try {
			Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException ex) {
			System.out.println("Error en la firma del token JWT: " + ex.getMessage());
		} catch (MalformedJwtException ex) {
			System.out.println("Token malformado: " + ex.getMessage());
		} catch (ExpiredJwtException ex) {
			System.out.println("El token ha expirado: " + ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			System.out.println("Token JWT no soportado: " + ex.getMessage());
		} catch (IllegalArgumentException ex) {
			System.out.println("JWT claims vacío");
		}
        return false;
		
		
		
	}
}

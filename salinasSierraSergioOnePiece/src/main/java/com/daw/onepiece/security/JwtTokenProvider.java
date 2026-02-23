package com.daw.onepiece.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
@Component
public class JwtTokenProvider {
	 @Value("${jwt.secret}")
	 private String jwtSecret;
	 
	 @Value("${jwt.expiration}")
	 private long jwtExpirationMs;

	 public String generateToken(Authentication authentication) {
		UserDetails userPrincipal = (UserDetails)
		authentication.getPrincipal();
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
		SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		return Jwts.builder()
		.subject(userPrincipal.getUsername())  
		.issuedAt(now)  
		.expiration(expiryDate)  
		.signWith(key)  
		.compact(); 
	}
	 
	 public String getUsernameFromToken(String token) {
		SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		Claims claims = Jwts.parser()
		.verifyWith(key)
		.build()
		.parseSignedClaims(token)
		.getPayload();
		return claims.getSubject();
		}
	 public boolean validateToken(String token) {
		 try {
		 SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
		 Jwts.parser()
		 .verifyWith(key)
		 .build()
		 .parseSignedClaims(token);
		 return true;
		 } catch (SecurityException ex) {
		 System.err.println("Firma JWT inválida");
		 } catch (MalformedJwtException ex) {
		 System.err.println("Token JWT inválido");
		 } catch (ExpiredJwtException ex) {
		 System.err.println("Token JWT expirado");
		 } catch (UnsupportedJwtException ex) {
		 System.err.println("Token JWT no soportado");
		 } catch (IllegalArgumentException ex) {
		 System.err.println("JWT claims string está vacío");
		 }
		return false;
		}
}

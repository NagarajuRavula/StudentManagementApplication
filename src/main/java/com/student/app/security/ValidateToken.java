package com.student.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ValidateToken {

	public static Claims parseJWT(String jwt) {

		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey("secret".getBytes()).parseClaimsJws(jwt).getBody();
		} catch (Exception e) {
			System.out.println("unable to read toekn");
		}
		return claims;
	}
}

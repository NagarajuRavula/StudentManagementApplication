package com.student.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ValidateToken {

	// Sample method to validate and read the JWT
	public static Claims parseJWT(String jwt) {

		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey("secret".getBytes()).parseClaimsJws(jwt).getBody();
		} catch (Exception e) {
			System.out.println("unable to read toekn");
		}
		return claims;
	}
}

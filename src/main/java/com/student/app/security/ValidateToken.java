package com.student.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ValidateToken {

	// Sample method to validate and read the JWT
	public Claims parseJWT(String jwt) {

		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey("secret".getBytes()).parseClaimsJws(jwt).getBody();
		} catch (Exception e) {
			System.out.println("unable to read toekn");
		}
		return claims;
	}

	public static void main(String args[]) {

		ValidateToken validate = new ValidateToken();
		Claims claims = validate.parseJWT(
				"eyJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50IjoiYWRtaW5AZ21haWwuY29tIiwicm9sZSI6ImFkbWluIiwic3ViIjoiYWRtaW5AZ21haWwuY29tIiwiaWF0IjoxNTE0OTkzNjU0LCJleHAiOjE1MTQ5OTU0NTR9.Dg-SZbvRjp0GVqWfV4FP-pVDIgfoGbz-DMzh01OFeT4");
		System.out.println(claims.getSubject());
	}
}

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

	public static void main(String args[]) {

		ValidateToken validate = new ValidateToken();
		Claims claims = validate.parseJWT(
				"eyJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50Ijoic3VyYWpAZ21haWwuY29tIiwicm9sZSI6InN0dWRlbnQiLCJzdWIiOiJzdXJhakBnbWFpbC5jb20iLCJpYXQiOjE1MTUwNzIxMjcsImV4cCI6MTUxNTA3MzkyN30.u-zqsUdM9FGoCrVAVxrvan3Pq4LAt30IBsuvGbiDLoY");
		System.out.println(claims.getSubject());
	}
}

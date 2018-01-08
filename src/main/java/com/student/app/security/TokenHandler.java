package com.student.app.security;

import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.TextCodec;

public class TokenHandler {

	/**
	 * here custom claim is a java object and it can contain any type of data here
	 * tokenId is a randomly generated UUID
	 */
	public static String createToken(String user, String role) {
		// Create a claim and put the data in to a claim.

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		long expMillis = 60000 * 30;
		long exp = nowMillis + expMillis;
		Claims claims = new DefaultClaims();
		claims.put("account", user);
		claims.put("role", role);
		// Here secretKey could be any thing.
		return Jwts.builder().setClaims(claims).setSubject(user).setIssuedAt(now).setExpiration(new Date(exp))
				.signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode("secret")).compact();
	}
}
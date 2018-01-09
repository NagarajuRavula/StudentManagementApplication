package com.student.app.security;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

@Aspect
@Component
public class AuthenticationAspect {

	@Around("execution(* com.student.app.restcontroller..*.*(..))")
	public ResponseEntity<Object> authBefore(ProceedingJoinPoint jp) throws Throwable {

		JsonObject jsonObject;
		HttpServletRequest request = null;
		ResponseEntity<Object> response = null;
		HttpHeaders httpHeaders = new HttpHeaders();
		for (int i = 0; i < jp.getArgs().length; i++) {
			if (jp.getArgs()[i].getClass() == RequestFacade.class) {
				request = (HttpServletRequest) jp.getArgs()[i];
				break;
			}
		}
		String jwt = request.getHeader("Authorization");
		Claims claims = ValidateToken.parseJWT(jwt);

		if (jp.getSignature().getName().equals("authenticate")) {
			Object obj = jp.proceed();
			response = (ResponseEntity<Object>) obj;
			return response;

		}

		else if (jp.getSignature().getName().equals("logout")) {

			if (claims == null) {
				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
			} else {
				long nowMillis = System.currentTimeMillis();
				Date now = new Date(nowMillis);
				claims.setExpiration(now);

				return new ResponseEntity<Object>(HttpStatus.OK);
			}
		}

		else if (jp.getSignature().getName().equals("delete")) {
            System.out.println("request for delete:   ------------");
			if (claims == null) {
				return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
			} else {
				String role = (String) claims.get("role");
				if (role.equals("admin")) {
					Object obj = jp.proceed();
					response = (ResponseEntity<Object>) obj;
					return response;
				} else
					return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
			}
		}

		else {

			if (jwt == null || jwt.isEmpty()) {
				System.out.println("toekn is null...............");
				httpHeaders.add("error", "Toekn is Required");
				jsonObject = Json.createObjectBuilder().add("error", "Token is Required").build();

				return new ResponseEntity<Object>(jsonObject, httpHeaders, HttpStatus.UNAUTHORIZED);
			} else {

				if (claims == null) {
					httpHeaders.add("error", "Toekn is Invalid");
					jsonObject = Json.createObjectBuilder().add("error", "Token is Invalid").build();
					return new ResponseEntity<Object>(jsonObject, httpHeaders, HttpStatus.UNAUTHORIZED);
				} else {
					Object obj = jp.proceed();
					response = (ResponseEntity<Object>) obj;
					return response;
				}
			}
		}

	}

}

package com.student.app.security;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.log4j.Logger;
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

	private Logger logger = Logger.getLogger(this.getClass());

	@Around("execution(* com.student.app.restcontroller..*.*(..))")
	public ResponseEntity<Object> authBeforeRestServices(ProceedingJoinPoint jp) throws Throwable {

		logger.info("authBeforeRestServices() entered:");
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
		System.out.println(request.getHeader("Authorization"));
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

	} // rest services

	@Around("execution(* com.student.app.controller..*.*(..))")
	public Object authBeforeServices(ProceedingJoinPoint jp) throws Throwable {
		logger.info("authBeforeServices() entered:");
		System.out.println("method name:---------->" + jp.getSignature().getName());

		if (jp.getSignature().getName().equals("authenticate") || jp.getSignature().getName().equals("login")) {
			return jp.proceed();
		} else if (jp.getSignature().getName().equals("logout")) {
			int i = 0;
			HttpServletRequest request = null;
			HttpServletResponse response = null;
			for (i = 0; i < jp.getArgs().length; i++) {
				if (jp.getArgs()[i].getClass() == RequestFacade.class) {
					request = (HttpServletRequest) jp.getArgs()[i];
				}
				if (jp.getArgs()[i].getClass() == ResponseFacade.class) {
					response = (HttpServletResponse) jp.getArgs()[i];
				}
			}

			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("jwt")) {
						cookie.setValue("");
						cookie.setPath("/");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
						break;
					}
				}
			}
			return jp.proceed();
		}

		else {
			int i = 0;
			HttpServletRequest request = null;
			HttpServletResponse response = null;
			String jwt = null;
			Claims claims = null;
			for (i = 0; i < jp.getArgs().length; i++) {
				if (jp.getArgs()[i].getClass() == RequestFacade.class) {
					request = (HttpServletRequest) jp.getArgs()[i];
				}
				if (jp.getArgs()[i].getClass() == ResponseFacade.class) {
					response = (HttpServletResponse) jp.getArgs()[i];
				}
			}
			Cookie cookies[] = request.getCookies();
			if (cookies == null) {
				System.out.println(request.getContextPath() + "/login");
				response.sendRedirect(request.getContextPath() + "/login");
				return null;
			}
			for (i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("jwt")) {
					jwt = cookies[i].getValue();
					break;
				}
			}
			if (i == cookies.length) {
				System.out.println("jwt cookie is not present-------Un-Authorized ");
				response.sendRedirect(request.getContextPath() + "/login");
				return null;
			}
			claims = ValidateToken.parseJWT(jwt);

			if (claims == null) {
				System.out.println("jwt token is wrong--------Un-Authorized");
				response.sendRedirect(request.getContextPath() + "/login");
				return null;
			}

			System.out.println("auth email:" + claims.getSubject());
			return jp.proceed();
		}

	}
}

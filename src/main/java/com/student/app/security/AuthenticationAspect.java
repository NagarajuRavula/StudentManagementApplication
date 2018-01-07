package com.student.app.security;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.ResponseFacade;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

//import org.json.simple.JSONObject;

@Aspect
@Component
public class AuthenticationAspect {

	@Around("execution(* com.student.app.restcontroller..*.*(..))")
	// @Before("controller() && allMethod() && args(..,request)")
	public ResponseEntity<Object> authBefore(ProceedingJoinPoint jp) throws Throwable {

		System.out.println("logBefore() is running!");
		JsonObject jsonObject;
		System.out.println("******");
		System.out.println("method name : " + jp.getSignature().getName());
		System.out.println("method parameters : " + jp.getArgs().length);
		// System.out.println("header:"+request.getHeader("Authorization"));
		// for(int i=0;i<jp.getArgs().length;i++) {
		// System.out.println("arguemnt: "+(i+1)+" is: "+jp.getArgs()[i]);
		//
		// }
	
		if (!jp.getSignature().getName().equals("authenticate")) {

			System.out.println(jp.getArgs()[0].getClass() == RequestFacade.class);
			System.out.println("argumets: "+jp.getArgs());
			HttpServletRequest request=null;
			for(int i=0;i<jp.getArgs().length;i++) {
				if(jp.getArgs()[i].getClass() == RequestFacade.class) {
					request = (HttpServletRequest) jp.getArgs()[i];
					break;
				}
			}
			System.out.println("header:" + request.getHeader("Authorization"));
			HttpHeaders httpHeaders = new HttpHeaders();
			String jwt = request.getHeader("Authorization");
			if (jwt==null||jwt.isEmpty()) {
				System.out.println("toekn is null...............");
				httpHeaders.add("error", "Toekn is Required");
			//	JSONObject jsonObject = new JSONObject();
			//	jsonObject.put("error", "Token is Required");
				
				jsonObject =
				        Json.createObjectBuilder()
				                .add("error", "Token is Required")
				        .build();
			
				return new ResponseEntity<Object>(jsonObject,httpHeaders,HttpStatus.UNAUTHORIZED);
			}
			else {
				Claims claims= ValidateToken.parseJWT(jwt);
				if(claims==null) {
					httpHeaders.add("error", "Toekn is Invalid");
					jsonObject =
					        Json.createObjectBuilder()
					                .add("error", "Token is Invalid")
					        .build();
					return new ResponseEntity<Object>(jsonObject,httpHeaders,HttpStatus.UNAUTHORIZED);
				}
				else {
					Object obj=jp.proceed();
					System.out.println("------------------");
					return new ResponseEntity<Object>(obj,HttpStatus.OK );
				}
			}
		}
		
		else {
			Object obj=jp.proceed();
			//return new ResponseEntity<Object>("hbh",obj,HttpStatus.ACCEPTED);
		//	System.out.println(obj);
			//return new ResponseEntity<Object>(obj,);
			System.out.println(obj.getClass().getDeclaredFields());
			System.out.println(obj.getClass().getFields().toString());
			return new ResponseEntity<Object>(obj,HttpStatus.OK );
			
			//return null;
		}
	}
}

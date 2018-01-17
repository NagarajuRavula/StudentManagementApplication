package com.student.app.security;

import org.apache.log4j.Logger;

public class Test {

	private Logger logger = Logger.getLogger(this.getClass());
	public static void main(String args[]) {
		
		String name="nagaraju";
		System.out.println("Name: "+name);
		System.out.println("Name Bytes: "+name.getBytes());
	}
}

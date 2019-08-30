package com.student.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


@ImportResource("classpath:spconfig.xml")
@SpringBootApplication
public class StudentManagementApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(StudentManagementApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }
}

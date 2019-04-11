package com.devoxxfr.scdf.demo.child;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.devoxxfr.scdf*")
public class DemoProcessorChildApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoProcessorChildApplication.class, args);
  }
}

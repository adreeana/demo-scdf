package com.devoxxfr.scdf.demo.sink.letter;

import com.devoxxfr.scdf.demo.domain.letter.Letter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.devoxxfr.scdf*")
public class DemoSinkLetterApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSinkLetterApplication.class, args);
  }

  @Bean
  public Letter letter() {
    return new Letter(100);
  }
}

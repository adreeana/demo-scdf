package com.devoxxfr.scdf.demo.task_source.toy;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;

@EnableTask
@EnableBatchProcessing
@SpringBootApplication(scanBasePackages = "com.devoxxfr.scdf*")
public class DemoTaskSourceToyApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoTaskSourceToyApplication.class, args);
  }
}

package com.devoxxfr.scdf.demo.task_source.toy;

import com.devoxxfr.scdf.demo.domain.toy.Toy;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.util.UUID;

@Configuration
public class ToyJobConfiguration {
  @Bean
  public Job toyJob(JobBuilderFactory jobBuilders) {
    return jobBuilders.get("toyJob")
      .incrementer(parameters -> {
        return new JobParametersBuilder()
          .addString("run.id", UUID.randomUUID().toString())
          .toJobParameters();
      })
      .start(toyStep(null))
      .build();
  }

  @Bean
  public Step toyStep(StepBuilderFactory stepBuilders) {
    return stepBuilders.get("toyStep")
      .<ToyInput, ToyInput>chunk(100)
      .faultTolerant()
      .noSkip(FileNotFoundException.class)
      .skip(FlatFileParseException.class)
      .skipLimit(30)
      .reader(toyReader())
      .processor(toyProcessor(null))
      .writer(toyWriter())
      .build();
  }

  @Bean
  public ItemReader<ToyInput> toyReader() {
    return new FlatFileItemReaderBuilder<ToyInput>()
      .name("toyReader")
      .resource(new ClassPathResource("toys.csv"))
      .delimited()
      .delimiter(" ")
      .names(new String[]{"codeBar", "availability"})
      .fieldSetMapper(new BeanWrapperFieldSetMapper<ToyInput>() {{
        setTargetType(ToyInput.class);
      }})
      .build();
  }

  @Bean
  public ItemProcessor<ToyInput, ToyInput> toyProcessor(ToysSource toysSource) {
    return item -> {
      toysSource.send(new Toy(item.getCodeBar()), item.getAvailability());
      return item;
    };
  }

  @Bean
  public ItemWriter<ToyInput> toyWriter() {
    return item -> {
    };
  }

  public static class ToyInput {
    private String codeBar;
    private Boolean availability;

    public ToyInput() {
    }

    public ToyInput(final String codeBar, final Boolean availability) {
      this.codeBar = codeBar;
      this.availability = availability;
    }

    public String getCodeBar() {
      return codeBar;
    }

    public void setCodeBar(final String codeBar) {
      this.codeBar = codeBar;
    }

    public Boolean getAvailability() {
      return availability;
    }

    public void setAvailability(final Boolean availability) {
      this.availability = availability;
    }
  }
}
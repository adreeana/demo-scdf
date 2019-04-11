package com.devoxxfr.scdf.demo.child;

import com.devoxxfr.scdf.demo.domain.child.ChildService;
import com.devoxxfr.scdf.demo.domain.child.Wish;
import com.devoxxfr.scdf.demo.domain.child.WishEvent;
import com.devoxxfr.scdf.demo.domain.toy.ToyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Processor.class)
public class ChildProcessor {
  private static final Logger log = LoggerFactory.getLogger(ChildProcessor.class);

  @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
  public Object wish(ToyEvent event) {
    log.info("Processing event {}", event);

    if (event.getAvailability()) {
      final Wish wish = childService().makeAWish(event.getToy());
      log.info("The child made a wish {}.", wish);

      return new WishEvent(wish);
    }
    return WishEvent.NO_WISH;
  }

  @Bean
  public ChildService childService() {
    return new ChildService();
  }
}

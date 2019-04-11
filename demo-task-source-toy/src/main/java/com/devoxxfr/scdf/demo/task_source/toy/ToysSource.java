package com.devoxxfr.scdf.demo.task_source.toy;

import com.devoxxfr.scdf.demo.domain.toy.Toy;
import com.devoxxfr.scdf.demo.domain.toy.ToyEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class ToysSource {
  @Autowired
  private Source source;

  public void send(final Toy toy, final Boolean available) {
    final ToyEvent event = new ToyEvent(toy, available);
    source.output().send(MessageBuilder.withPayload(event).build());
  }
}

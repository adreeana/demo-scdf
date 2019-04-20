package com.devoxxfr.scdf.demo.sink.letter;

import com.devoxxfr.scdf.demo.domain.child.WishEvent;
import com.devoxxfr.scdf.demo.domain.letter.Letter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
public class LettersSink {

  @Autowired
  private Letter letter;

  @StreamListener(Sink.INPUT)
  public void writeLetter(WishEvent event) {
    if (event.wishMade()) {
      letter.addWish(event.getWish());
    }
  }
}
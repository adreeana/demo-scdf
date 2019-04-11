package com.devoxxfr.scdf.demo.sink.letter;

import com.devoxxfr.scdf.demo.domain.child.WishEvent;
import com.devoxxfr.scdf.demo.domain.letter.Letter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class LettersSink {
  private static final Logger log = LoggerFactory.getLogger(LettersSink.class);

  @Autowired
  private Letter letter;

  @StreamListener(Sink.INPUT)
  public void wish(WishEvent event) {

    if (event.wishMade()) {
      letter.addWish(event.getWish());

      log.info("{}", letter);
    }
  }
}
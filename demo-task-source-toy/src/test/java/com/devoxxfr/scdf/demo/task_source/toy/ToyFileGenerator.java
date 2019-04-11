package com.devoxxfr.scdf.demo.task_source.toy;

import java.io.FileWriter;
import java.io.IOException;

public class ToyFileGenerator {

  public static void main(String[] args) throws IOException {

    try(FileWriter ff = new FileWriter("toys.csv")) {
      for (int ii = 1; ii < 10001; ii++) {
        ff.write(String.valueOf(ii));
        ff.write(' ');
        ff.write(bool(ii));
        ff.write(System.lineSeparator());
      }
    }
  }

  private static String bool(int ii) {
    if ((ii % 25 == 0)) {
      return "1";
    }
    return "0";
  }
}

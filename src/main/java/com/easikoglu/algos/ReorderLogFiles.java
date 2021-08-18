package com.easikoglu.algos;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

  public static void main(String[] args) {
    ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
    String[] input = {
            "j je", "b fjt", "7 zbr", "m le", "o 33"
    };
    reorderLogFiles.reorderLogFiles(input);
  }

  public String[] reorderLogFiles(String[] logs) {

    String regexDigit = "\\d+";

    Arrays.sort(
        logs,
        new Comparator<String>() {
          @Override
          public int compare(String o1, String o2) {

            String firstKey = o1.substring(0,o1.indexOf(" "));
            String value1 = o1.substring(firstKey.length()+1);
            String secondKey = o2.substring(0,o2.indexOf(" "));
            String value2 = o2.substring(secondKey.length()+1);
            boolean isDigit1 = value1.substring(0,1).matches(regexDigit);
            boolean isDigit2 = value2.substring(0,1).matches(regexDigit);
            // non digit strings
            if (!isDigit1 && !isDigit2) {
              int comparator = value1.compareTo(value2);
              if (comparator != 0) {
                return comparator;
              } else {
                return firstKey.compareTo(secondKey);
              }
            }
            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2)
              // the letter-log comes before digit-logs
              return -1;
            else if (isDigit1 && !isDigit2) return 1;
            else
              // case 3). both logs are digit-log
              return 0;
          }
        });

    return logs;
  }
}

package Utilities;

/*
 this class is a ustility class where all random datas are generated

 */

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;


public class RestUtils {

    // this classes varies based on what we want to generate
      public static String  empName() {
          String genaratedString = RandomStringUtils.randomAlphabetic(1);
          return ("John" + genaratedString);
      }

      public static String Salary(){
          String generatedSal = RandomStringUtils.randomNumeric(5);
          return (generatedSal);
      }

      public static String empAge(){
          String generatedAge = RandomStringUtils.randomNumeric(1);
          return(generatedAge);
      }

}

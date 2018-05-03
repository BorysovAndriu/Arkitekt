package io.arkitekt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {

  public static void main(String[] args) {

    String[] langs = {"Java", "C#", "Python", "PhP"};

    List<String> lan = Arrays.asList("Java", "C#", "PhP");

    for (String l: lan) {
      System.out.println("I am " + l);
    }


  }
}

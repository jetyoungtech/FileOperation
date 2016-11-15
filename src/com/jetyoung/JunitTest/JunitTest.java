package com.jetyoung.JunitTest;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest {

  class MyMath {
    public int add(int a, int b) {
      return a + b;
    }

    public int divide(int a, int b) {
      return a / b;
    }
  }

  MyMath mm = null;

  @Before
  public void init() {
    mm = new MyMath();
    System.out.println("Running init");
  }

  @After
  public void destroy() {
    mm = null;
    System.out.println("Running destroy");
  }

  @Test(timeout = 100)
  public void test1() {

    int result = mm.add(10, 20);
    System.out.println("add destroy");
    Assert.assertEquals(30, result);
  }

}

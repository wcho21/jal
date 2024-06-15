package org.jal.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EuclidTest {
  @Test
  public void testLargeNums() {
    int m = 200000000;
    int n = 100000000;
    int gcd = Euclid.getGCD(m, n);

    assertEquals(100000000, gcd);
  }

  @Test
  public void testZeroNum() {
    int gcd = Euclid.getGCD(1, 0);

    assertEquals(0, gcd);
  }

  @Test
  public void testNegativeNum1() {
    int gcd = Euclid.getGCD(1, -1);

    assertEquals(0, gcd);
  }

  @Test
  public void testNegativeNum2() {
    int gcd = Euclid.getGCD(-1, 1);

    assertEquals(0, gcd);
  }
}

package org.jal.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EuclidTest {
  @DisplayName("getGCD() should get the GCD for large numbers")
  @Test
  public void testLargeNums() {
    int m = 200000000;
    int n = 100000000;
    int gcd = Euclid.getGCD(m, n);

    assertEquals(100000000, gcd);
  }

  @DisplayName("getGCD() should get the GCD as zero if the first is zero")
  @Test
  public void testZeroNum1() {
    int gcd = Euclid.getGCD(1, 0);

    assertEquals(0, gcd);
  }

  @DisplayName("getGCD() should get the GCD as zero if the second is zero")
  @Test
  public void testZeroNum2() {
    int gcd = Euclid.getGCD(1, 0);

    assertEquals(0, gcd);
  }

  @DisplayName("getGCD() should get the GCD as zero if the first is negative")
  @Test
  public void testNegativeNum1() {
    int gcd = Euclid.getGCD(1, -1);

    assertEquals(0, gcd);
  }

  @DisplayName("getGCD() should get the GCD as zero if the second is negative")
  @Test
  public void testNegativeNum2() {
    int gcd = Euclid.getGCD(-1, 1);

    assertEquals(0, gcd);
  }
}

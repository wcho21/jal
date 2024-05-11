package org.jal.math;

public class Euclid {
  static public int getGCD(int m, int n) {
    // handle bad inputs
    if (m <= 0 || n <= 0) {
      return 0;
    }

    int r = m % n;
    if (r == 0) {
      return n;
    }

    return Euclid.getGCD(n, r);
  }
}

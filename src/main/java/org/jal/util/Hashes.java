package org.jal.util;

public class Hashes {
  static public <T> int multShiftHash(T toHash, int bound) {
    int num = toHash.hashCode();
    int pow = getPowerOfTwo(bound);

    int hash = (((num * 1327217885) & 0x7FFFFFFF) >> (31 - pow));
    return hash;
  }

  static private int getPowerOfTwo(int num) {
    int power = 0;
    while ((num & 1) == 0) {
      power++;
      num >>>= 1;
    }
    return power;
  }
}

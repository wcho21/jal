package org.jal.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArraysTest {
  @Test
  public void testSwap() {
    Integer[] arr = { 1, 2 };

    Arrays.swap(arr, 0, 1);

    assertEquals(2, arr[0]);
    assertEquals(1, arr[1]);
  }
}

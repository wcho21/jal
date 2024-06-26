package org.jal.search;

import static org.jal.search.BinarySearchIntArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchIntArrayTest {
  static int[] SORTED = { 10, 20, 30, 40, 50, 60, 70 };
  static int BAD_VALUE = 0;

  @DisplayName("search() should find data if there is")
  @Test
  public void testFound() {
    int[] arr = SORTED;
    int valueAt2 = arr[2];

    int index = search(arr, valueAt2);

    assertEquals(2, index);
  }

  @DisplayName("search() should get -1 if there is not")
  @Test
  public void testNotFound() {
    int[] arr = SORTED;
    int badValue = BAD_VALUE;

    int index = search(arr, badValue);

    assertEquals(-1, index);
  }
}

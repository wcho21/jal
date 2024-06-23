package org.jal.search;

import static org.jal.search.BinarySearchArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BinarySearchArrayTest {
  static Integer[] SORTED = { 9, 26, 43, 84, 93, 110 };
  static Comparator<Integer> REM8 = Comparator.comparing(v -> v % 8);

  @DisplayName("without a comparator")
  @Nested
  class WithoutComparator {
    @DisplayName("search() should find data if there is")
    @Test
    public void testFound() {
      Integer[] arr = SORTED;
      Integer valueAt2 = arr[2];

      int index = search(arr, valueAt2);

      assertEquals(2, index);
    }

    @DisplayName("search() should get -1 if there is not")
    @Test
    public void testNotFound() {
      Integer[] arr = SORTED;
      Integer badValue = 0;

      int index = search(arr, badValue);

      assertEquals(-1, index);
    }
  }

  @DisplayName("with a custom comparator")
  @Nested
  class WithRem8Ordering {
    @DisplayName("search() should find data if there is")
    @Test
    public void testFound() {
      Integer[] arr = SORTED;
      Integer valueAt2 = arr[2];

      int index = search(arr, valueAt2, REM8);

      assertEquals(2, index);
    }

    @DisplayName("search() should get -1 if there is not")
    @Test
    public void testNotFound() {
      Integer[] arr = SORTED;
      Integer badValue = 0;

      int index = search(arr, badValue, REM8);

      assertEquals(-1, index);
    }
  }
}

package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.Test;

public class TopDownMergeStrategyTestExample {
  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };
    ArraySortStrategy<Integer> strat = new TopDownMergeStrategy<>();

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }
}

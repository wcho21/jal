package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Comparator;
import java.util.stream.Stream;

import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BottomUpMergeStrategyTest {
  @DisplayName("sortArray() should sort an array")
  @Test
  public void testSort() {
    Integer[] unsorted = { 2, 3, 1, 6, 4, 5 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6 };
    ArraySortStrategy<Integer> strat = new BottomUpMergeStrategy<>();

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should be stable")
  @Test
  public void testStability() {
    Integer[] unsorted = { 1, 2, 3, 4, 5, 6 };
    Integer[] expected = { 2, 4, 6, 1, 3, 5 };
    ArraySortStrategy<Integer> strat = new BottomUpMergeStrategy<>();
    Comparator<Integer> rem2 = Comparator.comparing(v -> v % 2);

    ArraySorter.sortArray(unsorted, strat, rem2);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort an array for an interval")
  @Test
  public void testSortInterval() {
    Integer[] unsorted = { -1, -2, 20, 30, 10, 40, -3, -4 };
    int begin = 2;
    int end = unsorted.length-2;
    Integer[] expected = { -1, -2, 10, 20, 30, 40, -3, -4 };
    ArraySortStrategy<Integer> strat = new BottomUpMergeStrategy<>();

    ArraySorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort a large array")
  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = new BottomUpMergeStrategy<>();

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }
}

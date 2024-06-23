package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.jal.partition.RandThreeWayStrategy;
import org.jal.partition.ThreePartitionStrategy;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreeWayQuickStrategyTest {
  ThreePartitionStrategy<Integer> STRAT = new RandThreeWayStrategy<>(new Random()::nextInt);

  @DisplayName("sortArray() should sort an array")
  @Test
  public void testSort() {
    Integer[] unsorted = { 2, 2, 1, 1, 3, 3 };
    Integer[] expected = { 1, 1, 2, 2, 3, 3 };

    IntBinaryOperator chooseEnd = (begin, end) -> end-1;
    ThreePartitionStrategy<Integer> partStrat = new RandThreeWayStrategy<>(chooseEnd);
    ArraySortStrategy<Integer> sortStrat = new ThreeWayQuickStrategy<>(partStrat);

    ArraySorter.sortArray(unsorted, sortStrat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort an array for an interval")
  @Test
  public void testSortInterval() {
    Integer[] unsorted = { -1, -2, 20, 30, 10, 40, -3, -4 };
    int begin = 2;
    int end = unsorted.length-2;
    Integer[] expected = { -1, -2, 10, 20, 30, 40, -3, -4 };
    ArraySortStrategy<Integer> strat = new ThreeWayQuickStrategy<>(STRAT);

    ArraySorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort a large array")
  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = new ThreeWayQuickStrategy<>(STRAT);

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort a large array of duplicates")
  @Test
  public void testSortDuplicateLarge() {
    Integer[] unsorted = Stream.generate(() -> 0).limit(1000).toArray(Integer[]::new);
    Integer[] expected = unsorted.clone();
    ArraySortStrategy<Integer> strat = new ThreeWayQuickStrategy<>(STRAT);

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }
}

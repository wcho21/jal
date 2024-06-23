package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickStrategyTest {
  PartitionStrategy<Integer> STRAT = new RandTwoWayStrategy<>(new Random()::nextInt);

  @DisplayName("sortArray() should sort an array")
  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };

    IntBinaryOperator chooseEnd = (begin, end) -> end-1;
    PartitionStrategy<Integer> partStrat = new RandTwoWayStrategy<>(chooseEnd);
    ArraySortStrategy<Integer> sortStrat = new QuickStrategy<>(partStrat);

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
    ArraySortStrategy<Integer> strat = new QuickStrategy<>(STRAT);

    ArraySorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @DisplayName("sortArray() should sort a large array")
  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = new QuickStrategy<>(STRAT);

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }
}

package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.function.IntBinaryOperator;

import org.jal.partition.RandThreeWayStrategy;
import org.jal.partition.ThreePartitionStrategy;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.Test;

public class ThreeWayQuickStrategyTestExample {
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
}

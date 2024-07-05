package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.function.IntBinaryOperator;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.Test;

public class QuickStrategyTestExample {
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
}

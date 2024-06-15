package org.jal.util.partition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;

import org.jal.util.IntPair;
import org.junit.jupiter.api.Test;

public class RandThreeWayStrategyTest {
  @Test
  public void testSuccess() {
    Integer[] arr = new Integer[] { 2, 0, 1, 2, 2, 3, 4 };
    Comparator<Integer> identity = Comparator.comparing(v -> v);

    IntBinaryOperator chooseBegin = (a, b) -> a;
    ThreePartitionStrategy<Integer> strat = new RandThreeWayStrategy<>(chooseBegin);

    IntPair pivot = strat.partition(arr, 0, arr.length, identity);
    int pivotBegin = pivot.first();
    int pivotEnd = pivot.second();
    int pivotVal = arr[pivotBegin];

    assertEquals(2, pivotVal);
    assertTrue(Arrays.stream(arr, 0, pivotBegin).allMatch(v -> v < pivotVal));
    assertTrue(Arrays.stream(arr, pivotBegin, pivotEnd).allMatch(v -> v == pivotVal));
    assertTrue(Arrays.stream(arr, pivotEnd, arr.length).allMatch(v -> v > pivotVal));
  }
}

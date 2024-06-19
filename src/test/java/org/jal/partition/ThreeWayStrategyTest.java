package org.jal.partition;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.jal.util.IntPair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ThreeWayStrategyTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  static int ARR_SIZE = 64;
  static Integer[] DUPLICATE_ARR = new Integer[] { 1, 1, 1, 1, 1, 1, 1 };
  static Integer[] THREE_KINDS_ARR = new Integer[] { 1, 0, 0, 1, 1, 2, 2 };

  @ParameterizedTest
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int begin, int end) {

    ThreePartitionStrategy<Integer> strat = new ThreeWayStrategy<>();

    IntPair pivot = strat.partition(arr, begin, end, INC);
    int pivotBegin = pivot.first();
    int pivotEnd = pivot.second();
    int pivotVal = arr[pivotBegin];

    assertTrue(Arrays.stream(arr, 0, pivotBegin).allMatch(v -> v < pivotVal));
    assertTrue(Arrays.stream(arr, pivotBegin, pivotEnd).allMatch(v -> v == pivotVal));
    assertTrue(Arrays.stream(arr, pivotEnd, arr.length).allMatch(v -> v > pivotVal));
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(DUPLICATE_ARR, 0, DUPLICATE_ARR.length),
      arguments(THREE_KINDS_ARR, 0, THREE_KINDS_ARR.length)
    );
  }
}

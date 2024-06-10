package org.jal.util.partition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RandTwoWayStrategyTest {
  @Test
  public void testSuccess() {
    Integer[] arr = new Integer[] { 4, 5, 6, 2, 3 };
    Comparator<Integer> identity = Comparator.comparing(v -> v);

    IntBinaryOperator chooseBegin = (a, b) -> a;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<>(chooseBegin);

    int pivot = strat.partition(arr, 0, arr.length, identity);
    int pivotVal = arr[pivot];

    assertEquals(4, pivotVal);
    assertTrue(Arrays.stream(arr, 0, pivot).allMatch(v -> v <= pivotVal));
    assertTrue(Arrays.stream(arr, pivot+1, arr.length).allMatch(v -> v >= pivotVal));
  }

  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  static int ARR_SIZE = 64;
  static Integer[] INC_ARR = Stream.iterate(0, i -> i+1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] DEC_ARR = Stream.iterate(ARR_SIZE-1, i -> i-1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] ONE_ARR = Stream.generate(() -> 1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] ALT_ARR = Stream.iterate(0, i -> i == 0 ? 1 : 0).limit(ARR_SIZE).toArray(Integer[]::new);

  @ParameterizedTest
  @MethodSource("successProvider")
  public void testSuccesses(Integer[] arr, int begin, int end) {
    IntBinaryOperator beginChooser = (a, b) -> a;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<>(beginChooser);

    int pivot = strat.partition(arr, begin, end, INC);
    int pivotVal = arr[pivot];

    assertTrue(Arrays.stream(arr, begin, pivot).allMatch(v -> v <= pivotVal));
    assertTrue(Arrays.stream(arr, pivot+1, end).allMatch(v -> v >= pivotVal));
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(INC_ARR, 0, INC_ARR.length),
      arguments(DEC_ARR, 0, INC_ARR.length),
      arguments(ONE_ARR, 0, INC_ARR.length),
      arguments(ALT_ARR, 0, INC_ARR.length)
    );
  }
}

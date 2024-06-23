package org.jal.partition;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TwoWayStrategyTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  static int ARR_SIZE = 64;
  static Integer[] INC_ARR = Stream.iterate(0, i -> i+1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] DEC_ARR = Stream.iterate(ARR_SIZE-1, i -> i-1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] ONE_ARR = Stream.generate(() -> 1).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] ALT_ARR = Stream.iterate(0, i -> i == 0 ? 1 : 0).limit(ARR_SIZE).toArray(Integer[]::new);
  static Integer[] STEP_ARR = new Integer[] { 1, 0, 0, 0, 2, 2, 2 };
  static Integer[] TWO_STEP_ARR = new Integer[] { 1, 0, 0, 0, 1, 2, 2, 2 };

  @DisplayName("partition() should partition")
  @ParameterizedTest(name = "{0}")
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int begin, int end) {
    PartitionStrategy<Integer> strat = new TwoWayStrategy<>();

    int pivot = strat.partition(arr, begin, end, INC);
    int pivotVal = arr[pivot];

    assertTrue(Arrays.stream(arr, begin, pivot).allMatch(v -> v <= pivotVal));
    assertTrue(Arrays.stream(arr, pivot+1, end).allMatch(v -> v >= pivotVal));
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(named("a sorted array", INC_ARR), 0, INC_ARR.length),
      arguments(named("a reversed array", DEC_ARR), 0, DEC_ARR.length),
      arguments(named("a one's array", ONE_ARR), 0, ONE_ARR.length),
      arguments(named("an alternating zero and one's array", ALT_ARR), 0, ALT_ARR.length),
      arguments(named("a step array", STEP_ARR), 0, STEP_ARR.length),
      arguments(named("a two-step array", TWO_STEP_ARR), 0, TWO_STEP_ARR.length)
    );
  }
}

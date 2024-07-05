package org.jal.partition;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class CommonTwoWayTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  abstract protected <T> PartitionStrategy<T> createStrategy();

  @DisplayName("should partition")
  @ParameterizedTest(name = "{0}")
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int begin, int end) {
    PartitionStrategy<Integer> strat = this.createStrategy();

    int pivot = strat.partition(arr, begin, end, INC);
    int pivotVal = arr[pivot];

    assertTrue(Arrays.stream(arr, begin, pivot).allMatch(v -> v <= pivotVal));
    assertTrue(Arrays.stream(arr, pivot+1, end).allMatch(v -> v >= pivotVal));
  }

  static Stream<Arguments> successProvider() {
    int size = 64;
    Integer[] sorted = Stream.iterate(0, i -> i+1).limit(size).toArray(Integer[]::new);
    Integer[] reversed = Stream.iterate(size-1, i -> i-1).limit(size).toArray(Integer[]::new);
    Integer[] ones = Stream.generate(() -> 1).limit(size).toArray(Integer[]::new);
    Integer[] alt = Stream.iterate(0, i -> i == 0 ? 1 : 0).limit(size).toArray(Integer[]::new);
    Integer[] step = new Integer[] { 1, 0, 0, 0, 2, 2, 2 };
    Integer[] twoSteps = new Integer[] { 1, 0, 0, 0, 1, 2, 2, 2 };

    return Stream.of(
      arguments(named("a sorted array", sorted), 0, sorted.length),
      arguments(named("a reversed array", reversed), 0, reversed.length),
      arguments(named("a one's array", ones), 0, ones.length),
      arguments(named("an alternating zero and one's array", alt), 0, alt.length),
      arguments(named("a step array", step), 0, step.length),
      arguments(named("a two-step array", twoSteps), 0, twoSteps.length)
    );
  }
}

public class TwoWayStrategyTest {
  @DisplayName("Two-way")
  @Nested
  class TwoWayTest extends CommonTwoWayTest {
    @Override
    protected <T> PartitionStrategy<T> createStrategy() {
      return new TwoWayStrategy<>();
    }
  }

  @DisplayName("Randomized Two-way")
  @Nested
  class RandTwoWayTest extends CommonTwoWayTest {
    @Override
    protected <T> PartitionStrategy<T> createStrategy() {
      return new RandTwoWayStrategy<>((begin, end) -> begin + (end-begin)/2);
    }
  }
}

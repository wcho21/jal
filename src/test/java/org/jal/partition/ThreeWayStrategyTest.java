package org.jal.partition;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.jal.util.IntPair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class CommonThreeWayTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  abstract protected <T> ThreePartitionStrategy<T> createStrategy();

  @DisplayName("should partition")
  @ParameterizedTest(name = "{0}")
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int begin, int end) {
    ThreePartitionStrategy<Integer> strat = this.createStrategy();

    IntPair pivot = strat.partition(arr, begin, end, INC);
    int pivotBegin = pivot.first();
    int pivotEnd = pivot.second();
    int pivotVal = arr[pivotBegin];

    assertTrue(Arrays.stream(arr, 0, pivotBegin).allMatch(v -> v < pivotVal));
    assertTrue(Arrays.stream(arr, pivotBegin, pivotEnd).allMatch(v -> v == pivotVal));
    assertTrue(Arrays.stream(arr, pivotEnd, arr.length).allMatch(v -> v > pivotVal));
  }

  static Stream<Arguments> successProvider() {
    int size = 64;
    Integer[] sorted = Stream.iterate(0, i -> i+1).limit(size).toArray(Integer[]::new);
    Integer[] reversed = Stream.iterate(size-1, i -> i-1).limit(size).toArray(Integer[]::new);
    Integer[] ones = Stream.generate(() -> 1).limit(size).toArray(Integer[]::new);
    Integer[] alt = Stream.iterate(0, i -> i == 0 ? 1 : 0).limit(size).toArray(Integer[]::new);
    Integer[] threeKinds = new Integer[] { 1, 0, 0, 1, 1, 2, 2 };

    return Stream.of(
      arguments(named("a sorted array", sorted), 0, sorted.length),
      arguments(named("a reversed array", reversed), 0, reversed.length),
      arguments(named("a one's array", ones), 0, ones.length),
      arguments(named("an alternating zero and one's array", alt), 0, alt.length),
      arguments(named("a three-kind array", threeKinds), 0, threeKinds.length)
    );
  }
}

public class ThreeWayStrategyTest {
  @DisplayName("Three-way")
  @Nested
  class ThreeWayTest extends CommonThreeWayTest {
    @Override
    protected <T> ThreePartitionStrategy<T> createStrategy() {
      return new ThreeWayStrategy<>();
    }
  }

  @DisplayName("Randomized Two-way")
  @Nested
  class RandThreeWayTest extends CommonThreeWayTest {
    @Override
    protected <T> ThreePartitionStrategy<T> createStrategy() {
      return new RandThreeWayStrategy<>((begin, end) -> begin + (end-begin)/2);
    }
  }
}

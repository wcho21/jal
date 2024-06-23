package org.jal.search;

import static org.jal.search.QuickSelectArray.select;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class QuickSelectArrayTest {
  static Integer[] ARR = Stream.iterate(1, i -> (i % 2 == 1) ? i-1 : i+3).limit(20).toArray(Integer[]::new);

  @DisplayName("select() should find data if there is")
  @Test
  public void testSuccess() {
    Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };

    IntBinaryOperator chooseMid = (begin, end) -> begin + (end-begin)/2;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(chooseMid);

    int selected = select(arr, 1, strat);

    assertEquals(2, selected);
  }

  @DisplayName("select() should find")
  @ParameterizedTest(name = "{0}")
  @MethodSource("successProvider")
  public void testSuccesses(Integer[] arr, int target, int expected) {
    IntBinaryOperator beginChooser = (begin, end) -> begin;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(beginChooser);

    int selected = select(arr, target, strat);

    assertEquals(expected, selected);
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(named("the 0th data", ARR.clone()), 0, 0),
      arguments(named("the 1st data", ARR.clone()), 1, 1),
      arguments(named("the 4th data", ARR.clone()), 4, 4),
      arguments(named("the 9th data", ARR.clone()), 9, 9),
      arguments(named("the 14th data", ARR.clone()), 14, 14),
      arguments(named("the 19th data", ARR.clone()), 19, 19)
    );
  }
}

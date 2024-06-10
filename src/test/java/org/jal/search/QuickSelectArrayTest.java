package org.jal.search;

import static org.jal.search.QuickSelectArray.select;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.jal.util.partition.PartitionStrategy;
import org.jal.util.partition.RandTwoWayStrategy;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class QuickSelectArrayTest {
  static Integer[] ARR = Stream.iterate(1, i -> (i % 2 == 1) ? i-1 : i+3).limit(20).toArray(Integer[]::new);

  @Test
  public void testSuccess() {
    Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };

    IntBinaryOperator chooseMid = (begin, end) -> begin + (end-begin)/2;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(chooseMid);

    int selected = select(arr, 1, strat);

    assertEquals(2, selected);
  }

  @ParameterizedTest
  @MethodSource("successProvider")
  public void testSuccesses(Integer[] arr, int target, int expected) {
    IntBinaryOperator beginChooser = (begin, end) -> begin;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(beginChooser);

    int selected = select(arr, target, strat);

    assertEquals(expected, selected);
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(ARR.clone(), 0, 0),
      arguments(ARR.clone(), 1, 1),
      arguments(ARR.clone(), 4, 4),
      arguments(ARR.clone(), 9, 9),
      arguments(ARR.clone(), 14, 14),
      arguments(ARR.clone(), 19, 19)
    );
  }
}

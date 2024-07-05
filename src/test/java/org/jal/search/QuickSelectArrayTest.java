package org.jal.search;

import static org.jal.search.QuickSelectArray.select;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class QuickSelectArrayTest {
  static Integer[] ARR = Stream.iterate(1, i -> (i % 2 == 1) ? i-1 : i+3).limit(20).toArray(Integer[]::new);

  @DisplayName("select() should find")
  @ParameterizedTest(name = "{0}")
  @MethodSource("successProvider")
  public void testSuccesses(int target) {
    IntBinaryOperator beginChooser = (begin, end) -> begin;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(beginChooser);

    int selected = select(ARR.clone(), target, strat);

    assertEquals(target, selected);
  }

  static Stream<Arguments> successProvider() {
    return Stream.iterate(0, i->i+1).limit(ARR.length).map(i -> arguments(i));
  }
}

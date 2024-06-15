package org.jal.sorting.util;

import static org.jal.sorting.util.Merge.isLessOrEqualLowerBegin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MergeTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  @ParameterizedTest
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int lowerBegin, int lowerEnd, int upperBegin, int upperEnd, boolean expected) {
    boolean lessOrEqual = isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, INC);

    assertEquals(expected, lessOrEqual);
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(new Integer[] { 1, 2, 3, 4 }, 0, 2, 2, 4, true),
      arguments(new Integer[] { 1, 2, 3, 4 }, 1, 2, 3, 4, true),
      arguments(new Integer[] { 3, 4, 1, 2 }, 0, 2, 2, 4, false),
      arguments(new Integer[] { 3, 4, 1, 2 }, 1, 2, 3, 4, false),
      arguments(new Integer[] { 1, 2 }, 0, 0, 0, 1, false), // lower is greater if empty
      arguments(new Integer[] { 1, 2 }, 0, 1, 1, 1, true) // upper is greater if empty
    );
  }

  @ParameterizedTest
  @MethodSource("failProvider")
  public void testFail(Integer[] arr, int lowerBegin, int lowerEnd, int upperBegin, int upperEnd, Class<Throwable> expected) {
    assertThrows(expected, () -> isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, INC));
  }

  static Stream<Arguments> failProvider() {
    return Stream.of(
      arguments(new Integer[] { 1, 2, 3, 4 }, 0, 0, 0, 0, AssertionError.class),
      arguments(new Integer[] { 1, 2, 3, 4 }, 0, 0, 0, 0, AssertionError.class)
    );
  }
}

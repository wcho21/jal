package org.jal.sorting.util;

import static org.jal.sorting.util.Merge.isLessOrEqualLowerBegin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MergeTest {
  static Comparator<Integer> INC = Comparator.comparing(v -> v);

  @DisplayName("isLessOrEqualLowerBegin() should")
  @ParameterizedTest(name = "be {0}")
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int lowerBegin, int lowerEnd, int upperBegin, int upperEnd, boolean expected) {
    boolean lessOrEqual = isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, INC);

    assertEquals(expected, lessOrEqual);
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(named("true if lower begin is less", new Integer[] { 1, 2, 3, 4 }),
        0, 2, 2, 4, true),
      arguments(named("true if lower begin is equal", new Integer[] { 1, 2, 1, 4 }),
        0, 2, 2, 4, true),
      arguments(named("true if lower begin is less for shorten intervals", new Integer[] { 1, 2, 3, 4 }),
        1, 2, 3, 4, true),
      arguments(named("false if upper begin is less", new Integer[] { 3, 4, 1, 2 }),
        0, 2, 2, 4, false),
      arguments(named("false if upper begin is less for shorten intervals",new Integer[] { 3, 4, 1, 2 }),
        1, 2, 3, 4, false),
      arguments(named("false if lower is empty", new Integer[] { 1, 2 }),
        0, 0, 0, 1, false),
      arguments(named("true if upper is empty", new Integer[] { 1, 2 }),
        0, 1, 1, 1, true)
    );
  }

  @DisplayName("isLessOrEqualLowerBegin() should throw")
  @ParameterizedTest(name = "if {0}")
  @MethodSource("failProvider")
  public void testFail(Integer[] arr, int lowerBegin, int lowerEnd, int upperBegin, int upperEnd, Class<Throwable> expected) {
    assertThrows(expected, () -> isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, INC));
  }

  static Stream<Arguments> failProvider() {
    return Stream.of(
      arguments(named("a bad interval", new Integer[] { 1, 2, 3, 4 }), 0, 0, 0, 0, AssertionError.class)
    );
  }
}

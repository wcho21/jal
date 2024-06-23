package org.jal.sorting.util;

import static org.jal.sorting.util.Inversion.count;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InversionTest {
  @DisplayName("count() should count")
  @ParameterizedTest(name = "{1} inversions")
  @MethodSource("successProvider")
  public void testSuccess(Integer[] arr, int expected) {
    int numInversions = count(arr);

    assertEquals(expected, numInversions);
  }

  static Stream<Arguments> successProvider() {
    return Stream.of(
      arguments(new Integer[] {}, 0),
      arguments(new Integer[] { 1 }, 0),
      arguments(new Integer[] { 1, 2 }, 0),
      arguments(new Integer[] { 2, 1 }, 1),
      arguments(new Integer[] { 1, 2, 3, 4, 5 }, 0),
      arguments(new Integer[] { 5, 4, 3, 2, 1 }, 5 * 4 / 2)
    );
  }
}

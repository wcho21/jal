package org.jal.search;

import static org.jal.search.BinarySearchIntArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BinarySearchIntArrayTest {
  static int[] SORTED = { 10, 20, 30, 40, 50, 60, 70 };

  @DisplayName("search() should find data")
  @ParameterizedTest(name = "{1}")
  @MethodSource("successProvider")
  public void testSuccess(int expected, int target) {
    int[] arr = SORTED;

    int index = search(arr, target);

    assertEquals(expected, index);
  }

  static Stream<Arguments> successProvider() {
    return Stream.iterate(0, i->i+1).limit(SORTED.length).map(i -> {
      return arguments(i, SORTED[i]); // expected (index), target
    });
  }

  @DisplayName("search() should fail if target not in array")
  @ParameterizedTest(name = "{0}")
  @MethodSource("failProvider")
  public void testFail(int target) {
    int[] arr = SORTED;

    int index = search(arr, target);

    assertEquals(-1, index);
  }

  static Stream<Arguments> failProvider() {
    return Stream.of(
      // target
      arguments(SORTED[0]-1),
      arguments(SORTED[SORTED.length-1]+1)
    );
  }
}

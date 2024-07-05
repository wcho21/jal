package org.jal.search;

import static org.jal.search.BinarySearchArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class BinarySearchArrayTest {
  static Integer[] SORTED = { 9, 26, 43, 84, 93, 110 };
  static Comparator<Integer> REM8 = Comparator.comparing(v -> v % 8);

  @DisplayName("Custom comparator")
  @Nested
  class Rem8Ordering {
    @DisplayName("search() should find data")
    @ParameterizedTest(name = "{1}")
    @MethodSource("org.jal.search.BinarySearchArrayTest#successProvider")
    public void testSuccess(int expected, int target) {
      Integer[] arr = SORTED;

      int index = search(arr, target, REM8);

      assertEquals(expected, index);
    }

    @DisplayName("search() should fail if target not in array")
    @ParameterizedTest(name = "{0}")
    @MethodSource("org.jal.search.BinarySearchArrayTest#failProvider")
    public void testFail(int target) {
      Integer[] arr = SORTED;

      int index = search(arr, target, REM8);

      assertEquals(-1, index);
    }
  }

  @DisplayName("Default comparator")
  @Nested
  class DefaultOrdering {
    @DisplayName("search() should find data")
    @ParameterizedTest(name = "{1}")
    @MethodSource("org.jal.search.BinarySearchArrayTest#successProvider")
    public void testSuccess(int expected, int target) {
      Integer[] arr = SORTED;

      int index = search(arr, target);

      assertEquals(expected, index);
    }

    @DisplayName("search() should fail if target not in array")
    @ParameterizedTest(name = "{0}")
    @MethodSource("org.jal.search.BinarySearchArrayTest#failProvider")
    public void testFail(int target) {
      Integer[] arr = SORTED;

      int index = search(arr, target, REM8);

      assertEquals(-1, index);
    }
  }

  static Stream<Arguments> successProvider() {
    return Stream.iterate(0, i->i+1).limit(SORTED.length).map(i -> {
      return arguments(i, SORTED[i]); // expected (index), target
    });
  }

  static Stream<Arguments> failProvider() {
    Integer[] sorted = SORTED;

    return Stream.of(
      // target
      arguments(sorted[0]-1),
      arguments(sorted[sorted.length-1]+1)
    );
  }
}

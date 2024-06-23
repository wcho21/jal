package org.jal.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComparatorsTest {
  @DisplayName("isLessThan()")
  @ParameterizedTest(name = "should be {2} for {0} and {1}")
  @CsvSource({
    "0,1,true",
    "1,1,false",
    "1,0,false",
  })
  public void testIsLessThan(int source, int target, boolean expected) {
    boolean greater = Comparators.isLessThan(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @DisplayName("isLessThanOrEqualTo()")
  @ParameterizedTest(name = "should be {2} for {0} and {1}")
  @CsvSource({
    "0,1,true",
    "1,1,true",
    "1,0,false",
  })
  public void testIsLessThanOrEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isLessThanOrEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @DisplayName("isEqualTo()")
  @ParameterizedTest(name = "should be {2} for {0} and {1}")
  @CsvSource({
    "0,1,false",
    "1,1,true",
    "1,0,false",
  })
  public void testIsEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @DisplayName("isGreaterThanOrEqualTo()")
  @ParameterizedTest(name = "should be {2} for {0} and {1}")
  @CsvSource({
    "0,1,false",
    "1,1,true",
    "1,0,true",
  })
  public void testIsGreaterThanOrEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isGreaterThanOrEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @DisplayName("isGreaterThan()")
  @ParameterizedTest(name = "should be {2} for {0} and {1}")
  @CsvSource({
    "0,1,false",
    "1,1,false",
    "1,0,true",
  })
  public void testIsGreaterThan(int source, int target, boolean expected) {
    boolean greater = Comparators.isGreaterThan(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }
}

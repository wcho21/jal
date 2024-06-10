package org.jal.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Comparator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ComparatorsTest {
  @ParameterizedTest
  @CsvSource({
    "0,1,true",
    "1,1,false",
    "1,0,false",
  })
  public void testIsLessThan(int source, int target, boolean expected) {
    boolean greater = Comparators.isLessThan(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @ParameterizedTest
  @CsvSource({
    "0,1,true",
    "1,1,true",
    "1,0,false",
  })
  public void testIsLessThanOrEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isLessThanOrEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @ParameterizedTest
  @CsvSource({
    "0,1,false",
    "1,1,true",
    "1,0,false",
  })
  public void testIsEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @ParameterizedTest
  @CsvSource({
    "0,1,false",
    "1,1,true",
    "1,0,true",
  })
  public void testIsGreaterThanOrEqualTo(int source, int target, boolean expected) {
    boolean greater = Comparators.isGreaterThanOrEqualTo(source, target, Comparator.comparing(v -> v));

    assertEquals(expected, greater);
  }

  @ParameterizedTest
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

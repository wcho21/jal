package org.jal.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class HashesTest {
  @DisplayName("multiplyShiftHash() should be less than the bound")
  @CsvSource({"1", "10", "100", "1000000000"})
  @ParameterizedTest(name = "{0}")
  public void testSwap(int bound) {

    assertTrue(Hashes.multShiftHash(0, bound) < bound);
    assertTrue(Hashes.multShiftHash(bound-1, bound) < bound);
  }
}

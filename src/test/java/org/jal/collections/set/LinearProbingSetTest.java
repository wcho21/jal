package org.jal.collections.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LinearProbingSetTest {
  @DisplayName("string")
  @Nested
  class PlainStringTest {
    @DisplayName("has() should be true if found")
    @Test
    public void testSetAndHas() {
      Set<String> set = new LinearProbingSet<>();

      set.set("Jane");

      assertEquals(false, set.has("John"));
      assertEquals(true, set.has("Jane"));
      assertEquals(false, set.has("Tom"));

      set.set("John");

      assertEquals(true, set.has("John"));
      assertEquals(true, set.has("Jane"));
      assertEquals(false, set.has("Tom"));

      set.remove("John");

      assertEquals(false, set.has("John"));
      assertEquals(true, set.has("Jane"));
      assertEquals(false, set.has("Tom"));
    }
  }
}

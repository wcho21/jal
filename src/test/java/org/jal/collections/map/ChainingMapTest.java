package org.jal.collections.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ChainingMapTest {
  @DisplayName("string")
  @Nested
  class PlainStringTest {
    @DisplayName("get() should get the item if found")
    @Test
    public void testSetAndGets() {
      Map<String, Boolean> map = new ChainingMap<>();

      map.set("John", false);
      map.set("Jane", true);
      map.set("Tom", false);

      assertEquals(false, map.get("John"));
      assertEquals(true, map.get("Jane"));
      assertEquals(false, map.get("Tom"));

      map.set("John", true);

      assertEquals(true, map.get("John"));
      assertEquals(true, map.get("Jane"));
      assertEquals(false, map.get("Tom"));

      map.remove("John");

      assertEquals(null, map.get("John"));
      assertEquals(true, map.get("Jane"));
      assertEquals(false, map.get("Tom"));
    }
  }
}

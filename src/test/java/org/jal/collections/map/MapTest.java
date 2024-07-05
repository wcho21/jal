package org.jal.collections.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract class CommonTest {
  abstract protected Map<Integer, Boolean> createMap();

  static int SIZE = 1000;

  @DisplayName("get() should get values")
  @Test
  public void testSetAndGets() {
    Map<Integer, Boolean> map = this.createMap();

    for (int i = 0; i < SIZE; ++i) {
      boolean odd = i % 2 == 1 ? true : false;
      map.set(i, odd);
    }

    for (int i = 0; i < SIZE; ++i) {
      boolean expected = i % 2 == 1 ? true : false;
      assertEquals(expected, map.get(i));
    }
  }

  @DisplayName("get() should get null if not found")
  @Test
  public void testGetNull() {
    Map<Integer, Boolean> map = this.createMap();

    assertEquals(null, map.get(0));
  }
}

public class MapTest {
  @DisplayName("ChainingMap class")
  @Nested
  class ChainingTest extends CommonTest {
    @Override
    protected Map<Integer, Boolean> createMap() {
      return new ChainingMap<>();
    }
  }

  @DisplayName("LinearProbingMap class")
  @Nested
  class LinearProbingTest extends CommonTest {
    @Override
    protected Map<Integer, Boolean> createMap() {
      return new LinearProbingMap<>();
    }
  }

  @DisplayName("DoubleHashingMap class")
  @Nested
  class DoubleHashingTest extends CommonTest {
    @Override
    protected Map<Integer, Boolean> createMap() {
      return new DoubleHashingMap<>();
    }
  }
}

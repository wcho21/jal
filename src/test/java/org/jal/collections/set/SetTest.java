package org.jal.collections.set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract class CommonTest {
  abstract protected Set<Integer> createSet();

  static int SIZE = 1000;

  @DisplayName("has() should be true if found")
  @Test
  public void testSetAndGets() {
    Set<Integer> map = this.createSet();

    for (int i = 0; i < SIZE; ++i) {
      map.set(i);
    }

    for (int i = 0; i < SIZE; ++i) {
      assertEquals(true, map.has(i));
    }
  }

  @DisplayName("get() should be false if not found")
  @Test
  public void testGetNull() {
    Set<Integer> map = this.createSet();

    assertEquals(false, map.has(0));
  }
}

public class SetTest {
  @DisplayName("ChainingSet class")
  @Nested
  class ChainingTest extends CommonTest {
    @Override
    protected Set<Integer> createSet() {
      return new ChainingSet<>();
    }
  }

  @DisplayName("LinearProbingSet class")
  @Nested
  class LinearProbingTest extends CommonTest {
    @Override
    protected Set<Integer> createSet() {
      return new LinearProbingSet<>();
    }
  }

  @DisplayName("DoubleHashingSet class")
  @Nested
  class DoubleHashingTest extends CommonTest {
    @Override
    protected Set<Integer> createSet() {
      return new DoubleHashingSet<>();
    }
  }
}

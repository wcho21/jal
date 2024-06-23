package org.jal.collections.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
  @DisplayName("append() should append data")
  @Test
  public void testAppend() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(42, arr.get(0));
    assertEquals(43, arr.get(1));
  }

  @DisplayName("append() should append a large number of data")
  @Test
  public void testAppendLarge() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    for (int i = 0; i < 100; ++i) {
      arr.append(i);
    }

    assertEquals(99, arr.get(99));
  }

  @DisplayName("get() should throw for bad indices")
  @Test
  public void testGetOutOfRange() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(2));
  }

  @DisplayName("set() should set data with an index")
  @Test
  public void testSet() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.set(1, 9);

    assertEquals(42, arr.get(0));
    assertEquals(9, arr.get(1));
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSize() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(2, arr.getSize());
  }

  @DisplayName("remove() should remove the first data")
  @Test
  public void testRemove() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.remove();

    assertEquals(42, arr.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
  }

  @DisplayName("remove() should remove a large number of data")
  @Test
  public void testAppendAndRemoveLarge() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    for (int i = 0; i < 100; ++i) {
      arr.append(i);
    }
    for (int i = 0; i < 99; ++i) {
      arr.remove();
    }

    assertEquals(0, arr.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
  }
}

package org.jal.collections.array;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
  @Test
  public void testInitWithEmptyArgs() {
    DynamicArray<Integer> initWithEmptyArgs = new DynamicArray<>();

    assertEquals(0, initWithEmptyArgs.getSize());
  }

  @Test
  public void testInitWithSize() {
    int size = 4;
    DynamicArray<Integer> initWithSize = new DynamicArray<>(size);

    assertEquals(size, initWithSize.getSize());
  }

  @Test
  public void testInitWithArray() {
    Integer[] arr = new Integer[] { 1, 3, 2, 5, 4 };
    int begin = 1;
    int end = 4;
    DynamicArray<Integer> initWithArray = new DynamicArray<>(arr, begin, end);

    assertEquals(end-begin, initWithArray.getSize());
    Stream<Integer> indices = Stream.iterate(0, i -> i+1).limit(end-begin);
    assertTrue(indices.allMatch(i -> initWithArray.get(i) == arr[begin+i]));
  }

  @Test
  public void testAppend() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(42, arr.get(0));
    assertEquals(43, arr.get(1));
  }

  @Test
  public void testAppendLarge() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    for (int i = 0; i < 100; ++i) {
      arr.append(i);
    }

    assertEquals(99, arr.get(99));
  }

  @Test
  public void testGetOutOfRange() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(2));
  }

  @Test
  public void testSet() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.set(1, 9);

    assertEquals(42, arr.get(0));
    assertEquals(9, arr.get(1));
  }

  @Test
  public void testGetSize() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(2, arr.getSize());
  }

  @Test
  public void testRemove() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.remove();

    assertEquals(42, arr.get(0));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
  }

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

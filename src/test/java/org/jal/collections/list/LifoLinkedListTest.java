package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LifoLinkedListTest {
  @DisplayName("getFirst() should throw if empty")
  @Test
  public void testGetLastForEmptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.getFirst());
  }

  @DisplayName("getFirst() should get the last data")
  @Test
  public void testGetLastForNonemptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);

    assertEquals(44, list.getFirst());
  }

  @DisplayName("remove() should throw if empty")
  @Test
  public void testRemoveForEmptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.remove());
  }

  @DisplayName("remove() should remove the last data")
  @Test
  public void testRemoveForNonemptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);
    list.remove();

    assertEquals(43, list.getFirst());
  }

  @DisplayName("getSize() should get zero if empty")
  @Test
  public void testGetSizeForEmptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();

    assertEquals(0, list.getSize());
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSizeForNonemptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);

    assertEquals(3, list.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyForEmptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();

    assertEquals(true, list.isEmpty());
  }

  @DisplayName("isEmpty() should be false if nonempty")
  @Test
  public void testIsEmptyForNonemptyList() {
    LifoLinkedList<Integer> list = new LifoLinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(false, list.isEmpty());
  }
}

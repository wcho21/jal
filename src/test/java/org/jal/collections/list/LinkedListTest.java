package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
  @DisplayName("getData() should throw if empty")
  @Test
  public void testGetHeadForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.getData());
  }

  @DisplayName("getData() should get the head")
  @Test
  public void testGetHeadForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(43, list.getData());
  }

  @DisplayName("remove() should throw if empty")
  @Test
  public void testRemoveForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.remove());
  }

  @DisplayName("remove() should remove the head")
  @Test
  public void testRemoveForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.remove();

    assertEquals(42, list.getData());
  }

  @DisplayName("getSize() should get the size as zero if empty")
  @Test
  public void testGetSizeForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(0, list.getSize());
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSizeForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);

    assertEquals(3, list.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(true, list.isEmpty());
  }

  @DisplayName("isEmpty() should be false if nonempty")
  @Test
  public void testIsEmptyForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(false, list.isEmpty());
  }
}

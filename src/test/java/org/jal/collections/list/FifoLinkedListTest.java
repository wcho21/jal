package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FifoLinkedListTest {
  @DisplayName("getFirst() should throw if empty")
  @Test
  public void testGetFirstForEmptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.getFirst());
  }

  @DisplayName("getFirst() should get the first data")
  @Test
  public void testGetHeadForNonemptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();
    list.append(42);
    list.append(43);
    list.append(44);

    assertEquals(42, list.getFirst());
  }

  @DisplayName("remove() should throw if empty")
  @Test
  public void testRemoveForEmptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.remove());
  }

  @DisplayName("remove() should remove the first data")
  @Test
  public void testRemoveForNonemptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();
    list.append(42);
    list.append(43);
    list.append(44);
    list.remove();

    assertEquals(43, list.getFirst());
  }

  @DisplayName("getSize() should get zero if empty")
  @Test
  public void testGetSizeForEmptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();

    assertEquals(0, list.getSize());
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSizeForNonemptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();
    list.append(42);
    list.append(43);
    list.append(44);

    assertEquals(3, list.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyForEmptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();

    assertEquals(true, list.isEmpty());
  }

  @DisplayName("isEmpty() should be false if nonempty")
  @Test
  public void testIsEmptyForNonemptyList() {
    FifoLinkedList<Integer> list = new FifoLinkedList<>();
    list.append(42);

    assertEquals(false, list.isEmpty());
  }
}

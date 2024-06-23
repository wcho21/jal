package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedNodeTest {
  @DisplayName("should initialize without arguments")
  @Test
  public void testInitWithoutArguments() {
    LinkedNode<Integer> node = new LinkedNode<>();

    assertEquals(null, node.getData());
    assertEquals(null, node.getNext());
  }

  @DisplayName("should initialize with arguments")
  @Test
  public void testInitWithArguments() {
    LinkedNode<Integer> next, node;
    next = new LinkedNode<>(42, null);
    node = new LinkedNode<>(43, next);

    assertEquals(43, node.getData());
    assertEquals(next, node.getNext());
  }
}

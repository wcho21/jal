package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListNodeTest {
  @DisplayName("should initialize without arguments")
  @Test
  public void testInitWithoutArguments() {
    LinkedListNode<Integer> node = new LinkedListNode<>();

    assertEquals(null, node.data);
    assertEquals(null, node.next);
  }

  @DisplayName("should initialize with arguments")
  @Test
  public void testInitWithArguments() {
    LinkedListNode<Integer> next, node;
    next = new LinkedListNode<>(42, null);
    node = new LinkedListNode<>(43, next);

    assertEquals(43, node.data);
    assertEquals(next, node.next);
  }
}

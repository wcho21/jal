package org.jal.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ListStackTest {
  @Test
  public void testPushAndPeek() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.peek());
  }

  @Test
  public void testPushAndPop() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.pop());
  }

  @Test
  public void testPopForEmptyStack() {
    ListStack<Integer> stack = new ListStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @Test
  public void testGetSize() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(2, stack.getSize());
  }

  @Test
  public void testIsEmptyForEmptyStack() {
    ListStack<Integer> stack = new ListStack<>();

    assertEquals(true, stack.isEmpty());
  }

  @Test
  public void testIsEmptyForNonemptyStack() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);

    assertEquals(false, stack.isEmpty());
  }
}

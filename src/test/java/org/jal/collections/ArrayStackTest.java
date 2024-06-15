package org.jal.collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ArrayStackTest {
  @Test
  public void testPushAndPeek() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.peek());
  }

  @Test
  public void testPushAndPop() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.pop());
  }

  @Test
  public void testPopForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @Test
  public void testGetSize() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(2, stack.getSize());
  }

  @Test
  public void testIsEmptyForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertEquals(true, stack.isEmpty());
  }

  @Test
  public void testIsEmptyForNonemptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);

    assertEquals(false, stack.isEmpty());
  }
}

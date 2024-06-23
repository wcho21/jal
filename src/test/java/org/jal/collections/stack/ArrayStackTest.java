package org.jal.collections.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {
  @DisplayName("peek() should be top")
  @Test
  public void testPushAndPeek() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.peek());
  }

  @DisplayName("pop() should be top")
  @Test
  public void testPushAndPop() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.pop());
  }

  @DisplayName("pop() should throw if empty")
  @Test
  public void testPopForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSize() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(2, stack.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertEquals(true, stack.isEmpty());
  }

  @DisplayName("isEmpty() should be false if nonempty")
  @Test
  public void testIsEmptyForNonemptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);

    assertEquals(false, stack.isEmpty());
  }
}

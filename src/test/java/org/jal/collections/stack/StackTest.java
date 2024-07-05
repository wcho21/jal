package org.jal.collections.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract class CommonTest {
  abstract protected Stack<Integer> createStack();

  @DisplayName("peek() should be top")
  @Test
  public void testPushAndPeek() {
    Stack<Integer> stack = createStack();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.peek());
  }

  @DisplayName("pop() should be top")
  @Test
  public void testPushAndPop() {
    Stack<Integer> stack = this.createStack();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.pop());
  }

  @DisplayName("pop() should throw if empty")
  @Test
  public void testPopForEmptyStack() {
    Stack<Integer> stack = this.createStack();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSize() {
    Stack<Integer> stack = this.createStack();
    stack.push(42);
    stack.push(43);

    assertEquals(2, stack.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyForEmptyStack() {
    Stack<Integer> stack = this.createStack();

    assertEquals(true, stack.isEmpty());
  }

  @DisplayName("isEmpty() should be false if nonempty")
  @Test
  public void testIsEmptyForNonemptyStack() {
    Stack<Integer> stack = this.createStack();
    stack.push(42);

    assertEquals(false, stack.isEmpty());
  }
}

public class StackTest {
  @DisplayName("ArrayStack class")
  @Nested
  class ArrayStackTest extends CommonTest {
    @Override
    protected Stack<Integer> createStack() {
      return new ArrayStack<Integer>();
    }
  };

  @DisplayName("ListStack class")
  @Nested
  class ListStackTest extends CommonTest {
    @Override
    protected Stack<Integer> createStack() {
      return new ListStack<Integer>();
    }
  };
}

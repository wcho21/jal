package org.jal.collections.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ListStackTestExample {
  @Test
  public void testPushAndPop() {
    Stack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(43, stack.pop());
  }

  @Test
  public void testPopForEmptyStack() {
    Stack<Integer> stack = new ListStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }
}

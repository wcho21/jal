package org.jal.collections.queue;

import org.jal.collections.stack.ListStack;

public class LifoQueue<T> implements Queue<T> {
  private ListStack<T> stack;

  public LifoQueue() {
    this.stack = new ListStack<>();
  }

  public void add(T value) {
    stack.push(value);
  }

  public T poll() {
    return stack.pop();
  }

  public T peek() {
    return stack.peek();
  }

  public int getSize() {
    return stack.getSize();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }
}

package org.jal.collections.stack;

import org.jal.collections.list.LifoLinkedList;

public class ListStack<T> implements Stack<T> {
  private LifoLinkedList<T> list;

  public ListStack() {
    this.list = new LifoLinkedList<>();
  }

  public void push(T data) {
    this.list.prepend(data);
  }

  public T pop() {
    T data = this.list.getFirst();
    this.list.remove();

    return data;
  }

  public T peek() {
    return this.list.getFirst();
  }

  public int getSize() {
    return this.list.getSize();
  }

  public boolean isEmpty() {
    return this.list.isEmpty();
  }
}

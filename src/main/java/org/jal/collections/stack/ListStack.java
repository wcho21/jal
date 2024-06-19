package org.jal.collections.stack;

import org.jal.collections.list.LinkedList;

public class ListStack<T> implements Stack<T> {
  private LinkedList<T> list;

  public ListStack() {
    this.list = new LinkedList<>();
  }

  public void push(T data) {
    this.list.prepend(data);
  }

  public T pop() {
    T data = this.list.getData();
    this.list.remove();

    return data;
  }

  public T peek() {
    return this.list.getData();
  }

  public int getSize() {
    return this.list.getSize();
  }

  public boolean isEmpty() {
    return this.list.isEmpty();
  }
}

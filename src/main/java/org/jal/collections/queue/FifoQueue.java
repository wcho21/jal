package org.jal.collections.queue;

import org.jal.collections.list.FifoLinkedList;

public class FifoQueue<T> implements Queue<T> {
  private FifoLinkedList<T> list;

  public FifoQueue() {
    this.list = new FifoLinkedList<>();
  }

  public void add(T value) {
    list.append(value);
  }

  public T poll() {
    T polled = list.getFirst();

    list.remove();

    return polled;
  }

  public T peek() {
    return list.getFirst();
  }

  public int getSize() {
    return list.getSize();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}

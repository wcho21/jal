package org.jal.collections.list;

import java.util.NoSuchElementException;

public class LifoLinkedList<T> {
  private LinkedNode<T> head;
  private int size;

  public LifoLinkedList() {
    this.head = new LinkedNode<>(); // sentinel
    this.size = 0;
  }

  public T getFirst() {
    this.throwIfEmpty();

    return this.head.getData();
  }

  public void prepend(T data) {
    LinkedNode<T> node = new LinkedNode<>(data, head);
    this.head = node;

    this.size++;
  }

  public void remove() {
    this.throwIfEmpty();

    this.head = this.head.getNext();

    this.size--;
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  private void throwIfEmpty() {
    if (this.size == 0) {
      throw new NoSuchElementException();
    }
  }
}

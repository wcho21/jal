package org.jal.collections.list;

import java.util.NoSuchElementException;

public class LinkedList<T> {
  private LinkedNode<T> head;
  private int size;

  public LinkedList() {
    this.head = new LinkedNode<>(); // sentinel
    this.size = 0;
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

  public T getData() {
    this.throwIfEmpty();

    return this.head.getData();
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

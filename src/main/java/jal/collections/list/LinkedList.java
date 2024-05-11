package org.jal.collections.list;

import java.util.NoSuchElementException;

public class LinkedList<T> {
  private LinkedListNode<T> head;
  private int size;

  public LinkedList() {
    this.head = new LinkedListNode<>(); // sentinel
    this.size = 0;
  }

  public void prepend(T data) {
    LinkedListNode<T> node = new LinkedListNode<>(data, head);
    this.head = node;

    this.size++;
  }

  public void remove() {
    this.throwIfEmpty();

    this.head = this.head.next;

    this.size--;
  }

  public T getData() {
    this.throwIfEmpty();

    return this.head.data;
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

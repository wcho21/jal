package org.jal.collections.list;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
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

  private class ListIterator<U> implements Iterator<U> {
    private LinkedListNode<U> current;

    public ListIterator(LinkedListNode<U> head) {
      this.current = head;
    }

    public boolean hasNext() {
      return this.current.next != null;
    }

    public U next() {
      U data = this.current.data;

      this.current = this.current.next;

      return data;
    }
  }

  public Iterator<T> iterator() {
    return new ListIterator<T>(this.head);
  }

  private void throwIfEmpty() {
    if (this.size == 0) {
      throw new NoSuchElementException();
    }
  }
}

package org.jal.collections.list;

class LinkedNode<T> {
  private T data;
  private LinkedNode<T> next;

  public LinkedNode(T data, LinkedNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public LinkedNode() {
    this(null, null);
  }

  public T getData() {
    return this.data;
  }

  public LinkedNode<T> getNext() {
    return this.next;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setNext(LinkedNode<T> next) {
    this.next = next;
  }
}

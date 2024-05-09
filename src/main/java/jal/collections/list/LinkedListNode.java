package jal.collections.list;

public class LinkedListNode<T> {
  public T data;
  public LinkedListNode<T> next;

  public LinkedListNode(T data, LinkedListNode<T> next) {
    this.data = data;
    this.next = next;
  }

  public LinkedListNode() {
    this(null, null);
  }
}

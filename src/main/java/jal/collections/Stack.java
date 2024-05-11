package org.jal.collections;

public interface Stack<T> {
  public void push(T data);
  public T pop();
  public T peek();
  public int getSize();
  public boolean isEmpty();
}

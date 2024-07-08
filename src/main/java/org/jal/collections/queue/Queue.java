package org.jal.collections.queue;

public interface Queue<T> {
  public void add(T data);
  public T poll();
  public T peek();
  public int getSize();
  public boolean isEmpty();
}

package org.jal.collections.stack;

import java.util.NoSuchElementException;

import org.jal.collections.array.DynamicArray;

public class ArrayStack<T> implements Stack<T> {
  private DynamicArray<T> arr;

  public ArrayStack() {
    this.arr = new DynamicArray<>();
  }

  public void push(T data) {
    this.arr.append(data);
  }

  public T pop() {
    T data = this.getLast();
    this.arr.remove();

    return data;
  }

  public T peek() {
    return this.getLast();
  }

  public int getSize() {
    return this.arr.getSize();
  }

  public boolean isEmpty() {
    return this.arr.getSize() == 0;
  }

  private T getLast() {
    try {
      return this.arr.get(this.arr.getSize()-1);
    } catch (IndexOutOfBoundsException e) {
      throw new NoSuchElementException();
    } catch (RuntimeException e) {
      throw e;
    }
  }
}

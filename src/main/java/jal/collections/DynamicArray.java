package jal.collections;

import java.util.Arrays;

public class DynamicArray<T> {
  final static private int initCapacity = 4;
  final static private double growthFactor = 2.0;
  final static private double minLoadFactor = 0.25;

  private T[] arr;
  private int size;
  private int capacity;

  public DynamicArray() {
    @SuppressWarnings("unchecked")
    T[] initArr = (T[]) new Object[DynamicArray.initCapacity];

    this.arr = initArr;
    this.size = 0;
    this.capacity = DynamicArray.initCapacity;
  }

  public void append(T data) {
    if (this.isOutOfCapacity(this.size)) {
      int newCapacity = (int)(DynamicArray.growthFactor * this.capacity);
      this.resizeCapacity(newCapacity);
    }

    this.arr[this.size++] = data;
  }

  public void remove() {
    if (this.isTooFewLoaded()) {
      int newCapacity = (int)(this.capacity / DynamicArray.growthFactor);
      this.resizeCapacity(newCapacity);
    }

    this.arr[--this.size] = null; // avoid memory leak
  }

  public T get(int index) {
    throwIfOutOfSize(index);

    return this.arr[index];
  }

  public void set(int index, T data) {
    throwIfOutOfSize(index);

    this.arr[index] = data;
  }

  public int getSize() {
    return this.size;
  }

  private void throwIfOutOfSize(int index) {
    if (this.isOutOfSize(index)) {
      throw new IndexOutOfBoundsException();
    }
  }

  private boolean isTooFewLoaded() {
    if (this.capacity <= DynamicArray.initCapacity) {
      return false;
    }

    double loadFactor = (double)this.size / (double)this.capacity;
    return loadFactor <= DynamicArray.minLoadFactor;
  }

  private boolean isOutOfSize(int index) {
    return index < 0 || index >= this.size;
  }

  private boolean isOutOfCapacity(int index) {
    return index < 0 || index >= this.capacity;
  }

  private void resizeCapacity(int newCapacity) {
    this.arr = Arrays.copyOf(this.arr, newCapacity);
    this.capacity = newCapacity;
  }
}

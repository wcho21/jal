package org.jal.collections.dictionary;

class Slot<T> {
  T value;
  boolean removed;

  public Slot(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public void remove() {
    this.value = null;
    this.removed = true;
  }

  public boolean isRemoved() {
    return this.removed;
  }
}

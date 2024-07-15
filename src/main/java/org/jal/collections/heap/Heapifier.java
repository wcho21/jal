package org.jal.collections.heap;

import static org.jal.collections.heap.ArrayTree.getLastInternalNode;
import static org.jal.collections.heap.ArrayTree.getLeftChild;
import static org.jal.collections.heap.ArrayTree.getParent;
import static org.jal.collections.heap.ArrayTree.getRightChild;
import static org.jal.util.Comparators.isGreaterThanOrEqualTo;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Heapifier<T> {
  private Function<Integer, T> get;
  private BiConsumer<Integer, T> set;
  private Comparator<T> comp;

  public Heapifier(Function<Integer, T> get, BiConsumer<Integer, T> set, Comparator<T> comp) {
    this.get = get;
    this.set = set;
    this.comp = comp;
  }

  public void heapify(int root, int last) {
    int lastInternalNode = getLastInternalNode(last, root);

    for (int i = lastInternalNode; i >= root; --i) {
      this.siftDown(i, root, last);
    }
  }

  public void siftUp(int index, int root) {
    while (index > root) {
      int parent = getParent(index, root);
      if (isHeapOrdered(parent, index)) {
        break;
      }

      this.swap(index, parent);
      index = parent;
    }
  }

  public void siftDown(int index, int root, int last) {
    while (getLeftChild(index, root) <= last) {
      int largerChild = this.getLargerChildIndex(index, root, last);
      if (isHeapOrdered(index, largerChild)) {
        break;
      }

      this.swap(index, largerChild);
      index = largerChild;
    }
  }

  private int getLargerChildIndex(int index, int root, int last) {
    int left = getLeftChild(index, root);
    assert left <= last;

    // return left child if no right one
    int right = getRightChild(index, root);
    if (right > last) {
      return left;
    }

    T leftValue = this.get.apply(left);
    T rightValue = this.get.apply(right);
    if (isGreaterThanOrEqualTo(leftValue, rightValue, this.comp)) {
      return left;
    } else {
      return right;
    }
  }

  private boolean isHeapOrdered(int parentIndex, int childIndex) {
    T parent = this.get.apply(parentIndex);
    T child = this.get.apply(childIndex);
    return isGreaterThanOrEqualTo(parent, child, this.comp);
  }

  private void swap(int i, int j) {
    T temp = this.get.apply(i);
    this.set.accept(i, this.get.apply(j));
    this.set.accept(j, temp);
  }
}

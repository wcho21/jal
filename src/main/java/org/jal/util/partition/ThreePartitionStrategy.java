package org.jal.util.partition;

import java.util.Comparator;

import org.jal.util.IntPair;

public interface ThreePartitionStrategy<T> {
  public IntPair partition(T[] arr, int begin, int end, Comparator<T> comp);
}

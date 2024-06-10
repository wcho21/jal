package org.jal.util.partition;

import java.util.Comparator;

public interface PartitionStrategy<T> {
  public int partition(T[] arr, int begin, int end, Comparator<T> comp);
}

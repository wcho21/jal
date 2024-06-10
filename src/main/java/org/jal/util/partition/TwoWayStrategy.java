package org.jal.util.partition;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isLessThan;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class TwoWayStrategy<T> implements PartitionStrategy<T> {
  public int partition(T[] arr, int begin, int end, Comparator<T> comp) {
    assert begin >= 0;
    assert end > begin;
    assert arr.length >= end;

    T pivot = arr[begin];
    int l = begin+1;
    int u = end;

    while (true) {
      while (l < end && isLessThan(arr[l], pivot, comp)) {
        l++;
      }
      while (isGreaterThan(arr[u-1], pivot, comp)) {
        u--;
      }

      if (l < u) {
        swap(arr, l, u-1);
        l++;
        u--;
      } else {
        // move pivot (at `begin`) to `u-1` and return it
        swap(arr, begin, u-1);
        return u-1;
      }
    }
  }
}

package org.jal.util.partition;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import static org.jal.util.Comparators.isLessThan;

import java.util.Comparator;

import org.jal.util.IntPair;

public class ThreeWayStrategy<T> implements ThreePartitionStrategy<T> {
  public IntPair partition(T[] arr, int begin, int end, Comparator<T> comp) {
    assert begin >= 0;
    assert end > begin;
    assert arr.length >= end;

    T pivot = arr[begin];
    int l = begin+1;
    int m = l;
    int u = end;

    while (m < u) {
      if (isLessThan(arr[m], pivot, comp)) {
        swap(arr, l, m);
        l++;
        m++;
      } else if (isGreaterThan(arr[m], pivot, comp)) {
        u--;
        swap(arr, m, u);
      } else { // equal
        m++;
      }
    }

    l--;
    swap(arr, begin, l);

    return new IntPair(l, m);
  }
}

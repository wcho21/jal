package org.jal.search;

import java.util.Comparator;
import org.jal.util.partition.PartitionStrategy;

public class QuickSelectArray {
  public static <T> T select(T[] arr, int target, PartitionStrategy<T> strat, Comparator<T> comp) {
    int begin = 0;
    int end = arr.length;

    while (begin < end) {
      int pivot = strat.partition(arr, begin, end, comp);

      if (pivot == target) {
        break;
      }

      if (pivot < target) {
        begin = pivot + 1;
      } else {
        end = pivot;
      }
    }

    return arr[target];
  }

  public static <T extends Comparable<? super T>> T select(T[] arr, int target, PartitionStrategy<T> strat) {
    Comparator<T> identityComp = Comparator.comparing(v -> v);

    return QuickSelectArray.select(arr, target, strat, identityComp);
  }
}

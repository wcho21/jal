package org.jal.sorting.strategy.arrays;

import java.util.Comparator;
import org.jal.util.partition.PartitionStrategy;

public class QuickStrategy<T> implements ArraySortStrategy<T> {
  private PartitionStrategy<T> strat;

  public QuickStrategy(PartitionStrategy<T> strat) {
    this.strat = strat;
  }

  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    if (begin >= end) {
      return arr;
    }

    int i = this.strat.partition(arr, begin, end, comp);
    this.sortArray(arr, begin, i, comp);
    this.sortArray(arr, i+1, end, comp);

    return arr;
  }
}

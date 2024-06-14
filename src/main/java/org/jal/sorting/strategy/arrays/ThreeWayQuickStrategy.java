package org.jal.sorting.strategy.arrays;

import java.util.Comparator;
import org.jal.util.partition.ThreePartitionStrategy;
import org.jal.util.IntPair;

public class ThreeWayQuickStrategy<T> implements ArraySortStrategy<T> {
  private ThreePartitionStrategy<T> strat;

  public ThreeWayQuickStrategy(ThreePartitionStrategy<T> strat) {
    this.strat = strat;
  }

  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    if (begin >= end) {
      return arr;
    }

    IntPair pivot = this.strat.partition(arr, begin, end, comp);
    this.sortArray(arr, begin, pivot.first(), comp);
    this.sortArray(arr, pivot.second(), end, comp);

    return arr;
  }
}

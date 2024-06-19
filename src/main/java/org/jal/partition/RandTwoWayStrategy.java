package org.jal.partition;

import static org.jal.util.Arrays.swap;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

public class RandTwoWayStrategy<T> implements PartitionStrategy<T> {
  IntBinaryOperator rand;

  public RandTwoWayStrategy(IntBinaryOperator rand) {
    this.rand = rand;
  }

  public int partition(T[] arr, int begin, int end, Comparator<T> comp) {
    // select a random number
    int pivotIndex = this.rand.applyAsInt(begin, end);

    swap(arr, begin, pivotIndex);

    PartitionStrategy<T> strat = new TwoWayStrategy<>();
    return strat.partition(arr, begin, end, comp);
  }
}

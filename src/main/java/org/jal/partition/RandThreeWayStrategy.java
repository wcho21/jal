package org.jal.partition;

import static org.jal.util.Arrays.swap;

import java.util.Comparator;
import java.util.function.IntBinaryOperator;

import org.jal.util.IntPair;

public class RandThreeWayStrategy<T> implements ThreePartitionStrategy<T> {
  IntBinaryOperator rand;

  public RandThreeWayStrategy(IntBinaryOperator rand) {
    this.rand = rand;
  }

  public IntPair partition(T[] arr, int begin, int end, Comparator<T> comp) {
    // select a random number
    int pivotIndex = this.rand.applyAsInt(begin, end);

    swap(arr, begin, pivotIndex);

    ThreePartitionStrategy<T> strat = new ThreeWayStrategy<>();
    return strat.partition(arr, begin, end, comp);
  }
}

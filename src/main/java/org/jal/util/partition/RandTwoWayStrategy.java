package org.jal.util.partition;

import static org.jal.util.Arrays.swap;
import java.util.Comparator;
import java.util.random.RandomGenerator;
import java.util.Random;

public class RandTwoWayStrategy<T> implements PartitionStrategy<T> {
  RandIntSupplier rand;

  public RandTwoWayStrategy(RandIntSupplier rand) {
    this.rand = rand;
  }

  public RandTwoWayStrategy() {
    RandomGenerator randGen = new Random();
    this.rand = randGen::nextInt;
  }

  public int partition(T[] arr, int begin, int end, Comparator<T> comp) {
    // select random pivot and move it to `begin`
    int pivotIndex = this.rand.nextInt(begin, end);

    swap(arr, begin, pivotIndex);

    PartitionStrategy<T> strat = new TwoWayStrategy<>();
    return strat.partition(arr, begin, end, comp);
  }
}

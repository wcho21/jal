package org.jal.search;

import static org.jal.search.QuickSelectArray.select;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.IntBinaryOperator;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.junit.jupiter.api.Test;

public class QuickSelectArrayTestExample {
  @Test
  public void testSuccess() {
    Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };

    IntBinaryOperator chooseMid = (begin, end) -> begin + (end-begin)/2;
    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<Integer>(chooseMid);

    int selected = select(arr, 1, strat);

    assertEquals(2, selected);
  }
}

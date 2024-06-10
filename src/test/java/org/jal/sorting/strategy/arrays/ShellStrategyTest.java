package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Comparator;
import java.util.stream.Stream;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.Test;

public class ShellStrategyTest {
  static Comparator<Integer> rem8ordering = Comparator.comparing(v -> v % 8);

  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortInterval() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = 1;
    int end = unsorted.length-1;
    Integer[] expected = { 20, 10, 30, 40 };
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    ArraySorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testBadIntervalBegin() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = -1;
    int end = unsorted.length;
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArraySorter.sortArray(unsorted, begin, end, strat));
  }

  @Test
  public void testBadIntervalEnd() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = 0;
    int end = unsorted.length+1;
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> ArraySorter.sortArray(unsorted, begin, end, strat));
  }

  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    ArraySorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testReversedSortLarge() {
    Integer[] unsorted = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = new ShellStrategy<>();

    ArraySorter.sortArray(unsorted, strat, Comparator.comparing(v -> -v));

    assertArrayEquals(expected, unsorted);
  }
}

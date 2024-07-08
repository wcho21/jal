package org.jal.sorting.strategy.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.jal.partition.RandThreeWayStrategy;
import org.jal.partition.RandTwoWayStrategy;
import org.jal.partition.ThreeWayStrategy;
import org.jal.partition.TwoWayStrategy;
import org.jal.sorting.ArraySorter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

abstract class CommonSortTest {
  static private int ARRAY_SIZE = 300;

  abstract protected <T> ArraySortStrategy<T> createStrategy();

  @DisplayName("should sort an array")
  @Test
  public void testSort() {
    Integer[] toSort = Stream.iterate(ARRAY_SIZE-1, i -> i-1).limit(ARRAY_SIZE).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(ARRAY_SIZE).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, strat);

    assertArrayEquals(expected, toSort);
  }

  @DisplayName("should sort an array with an interval")
  @Test
  public void testSortInterval() {
    Integer[] toSort = Stream.iterate(ARRAY_SIZE-1, i -> i-1).limit(ARRAY_SIZE).toArray(Integer[]::new);
    Integer[] expected = Stream.concat(
      Stream.iterate(ARRAY_SIZE-1, i -> i-1).limit(ARRAY_SIZE/4),
      Stream.concat(
        Stream.iterate(ARRAY_SIZE/4, i -> i+1).limit(ARRAY_SIZE/2), // only mid is sorted
        Stream.iterate(ARRAY_SIZE/4-1, i -> i-1).limit(ARRAY_SIZE/4)
      )
    ).toArray(Integer[]::new);
    ArraySortStrategy<Integer> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, ARRAY_SIZE/4, 3*(ARRAY_SIZE/4), strat);

    assertArrayEquals(expected, toSort);
  }

  @DisplayName("should sort an array with a remainder-8 ordering")
  @Test
  public void testRem8DuplicateSort() {
    Integer[] toSort = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Integer[] expectedRems = { 0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7 };
    ArraySortStrategy<Integer> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, strat, Comparator.comparing(v -> v % 8));

    assertArrayEquals(expectedRems, Arrays.stream(toSort).map(i -> i % 8).toArray());
  }

  @DisplayName("should sort an array with an odd-even ordering")
  @Test
  public void testOddEvenSort() {
    Integer[] toSort = { 1, 4, 2, 3, 0, 7, 6, 5 };
    Integer[] expectedOddEven = { 1, 1, 1, 1, 0, 0, 0, 0 };
    ArraySortStrategy<Integer> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, strat, Comparator.comparing(v -> v % 2 == 0 ? 1 : 0));

    assertArrayEquals(expectedOddEven, Arrays.stream(toSort).map(i -> i % 2).toArray());
  }
}

abstract class CommonStabilityTest {
  abstract protected <T> ArraySortStrategy<T> createStrategy();

  @DisplayName("should be stable")
  @Test
  public void testStability() {
    Integer[] toSort = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Integer[] expected = { 2, 4, 6, 8, 10, 1, 3, 5, 7, 9 };
    Comparator<Integer> rem2 = Comparator.comparing(v -> v % 2);
    ArraySortStrategy<Integer> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, strat, rem2);

    assertArrayEquals(expected, toSort);
  }

  static class AnimalRecord {
    public String species;
    public String name;

    public AnimalRecord(String species, String name) {
      this.species = species;
      this.name = name;
    }
  }

  @DisplayName("should sort an animal record array with a custom ordering")
  @Test
  public void testAnimalRecordSort() {
    final AnimalRecord[] rec = {
      new AnimalRecord("Dog", "3"),
      new AnimalRecord("Dog", "2"),
      new AnimalRecord("Dog", "1"),
      new AnimalRecord("Cat", "A"),
      new AnimalRecord("Cat", "B"),
      new AnimalRecord("Cat", "C"),
    };

    AnimalRecord[] toSort = { rec[0], rec[5], rec[3], rec[1], rec[4], rec[2] };
    AnimalRecord[] expected = rec;
    ArraySortStrategy<AnimalRecord> strat = this.createStrategy();

    ArraySorter.sortArray(toSort, strat, (rec1, rec2) -> {
      int speciesOrder1 = rec1.species.equals("Dog") ? 0 : 1;
      int speciesOrder2 = rec2.species.equals("Dog") ? 0 : 1;

      if (speciesOrder1 == 0 || speciesOrder2 == 0) {
        return speciesOrder1 - speciesOrder2; // follow species ordering
      }

      return rec1.name.compareTo(rec2.name);
    });

    assertArrayEquals(expected, toSort);
  }
}

public class SortStrategyTest {
  @DisplayName("Sorting correctness")
  @Nested
  class SortingTest {
    @DisplayName("InsertionStrategy class")
    @Nested
    class InsertionTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new InsertionStrategy<>();
      }
    }

    @DisplayName("ShellStrategy class")
    @Nested
    class ShellTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new ShellStrategy<>();
      }
    }

    @DisplayName("BottomUpMergeStrategy class")
    @Nested
    class BottomUpMergeTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new BottomUpMergeStrategy<>();
      }
    }

    @DisplayName("TopDownMergeStrategy class")
    @Nested
    class TopDownMergeTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new TopDownMergeStrategy<>();
      }
    }

    @DisplayName("TopDownInsMergeStrategy class")
    @Nested
    class TopDownInsMergeTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new TopDownInsMergeStrategy<>();
      }
    }

    @DisplayName("QuickStrategy class")
    @Nested
    class QuickTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new QuickStrategy<>(new TwoWayStrategy<>());
      }
    }

    @DisplayName("QuickStrategy class with randomized")
    @Nested
    class RandQuickTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new QuickStrategy<>(new RandTwoWayStrategy<>((begin, end) -> begin + (end-begin)/2));
      }
    }

    @DisplayName("ThreeWayQuickStrategy class")
    @Nested
    class ThreeWayQuickTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new ThreeWayQuickStrategy<>(new ThreeWayStrategy<>());
      }
    }

    @DisplayName("ThreeWayQuickStrategy class with randomized")
    @Nested
    class RandThreeWayQuickTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new ThreeWayQuickStrategy<>(new RandThreeWayStrategy<>((begin, end) -> begin + (end-begin)/2));
      }
    }

    @DisplayName("HeapStrategy class")
    @Nested
    class HeapStreategyTest extends CommonSortTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new HeapStrategy<>();
      }
    }
  }

  @DisplayName("Stability")
  @Nested
  class StabilityTest {
    @DisplayName("InsertionStrategy class")
    @Nested
    class InsertionTest extends CommonStabilityTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new InsertionStrategy<>();
      }
    }

    @DisplayName("BottomUpMergeStrategy class")
    @Nested
    class BottomUpMergeTest extends CommonStabilityTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new BottomUpMergeStrategy<>();
      }
    }

    @DisplayName("TopDownMergeStrategy class")
    @Nested
    class TopDownMergeTest extends CommonStabilityTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new TopDownMergeStrategy<>();
      }
    }

    @DisplayName("TopDownInsMergeStrategy class")
    @Nested
    class TopDownInsMergeTest extends CommonStabilityTest {
      @Override
      protected <T> ArraySortStrategy<T> createStrategy() {
        return new TopDownInsMergeStrategy<>();
      }
    }
  }
}

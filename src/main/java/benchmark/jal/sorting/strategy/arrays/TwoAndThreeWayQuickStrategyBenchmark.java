package benchmark.jal.sorting.strategy.arrays;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.jal.sorting.ArraySorter;
import org.jal.sorting.strategy.arrays.ArraySortStrategy;
import org.jal.sorting.strategy.arrays.QuickStrategy;
import org.jal.sorting.strategy.arrays.ThreeWayQuickStrategy;
import org.jal.util.partition.RandThreeWayStrategy;
import org.jal.util.partition.RandTwoWayStrategy;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
public class TwoAndThreeWayQuickStrategyBenchmark {
  Integer[] reversed;
  Integer[] duplicate;
  Integer[] toSort;

  ArraySortStrategy<Integer> TWO_WAY_STRAT = new QuickStrategy<>(new RandTwoWayStrategy<>(new Random()::nextInt));
  ArraySortStrategy<Integer> THREE_WAY_STRAT = new ThreeWayQuickStrategy<>(new RandThreeWayStrategy<>(new Random()::nextInt));

  @Param({"128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072"})
  int size;

  @Setup(Level.Iteration)
  public void setup() {
    this.reversed = Stream.iterate(this.size, n -> n-1).limit(this.size).toArray(Integer[]::new);
    this.duplicate = Stream.iterate(0, n -> 0).limit(this.size).toArray(Integer[]::new);
    this.toSort = new Integer[this.size];
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public Integer[] measureTwoWayReversed() {
    System.arraycopy(this.reversed, 0, this.toSort, 0, this.size);

    ArraySorter.sortArray(this.toSort, TWO_WAY_STRAT);

    return this.toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureTwoWayDuplicate() {
    Integer[] sorted = ArraySorter.sortArray(this.duplicate, TWO_WAY_STRAT);

    return sorted;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public Integer[] measureThreeWayReversed() {
    System.arraycopy(this.reversed, 0, this.toSort, 0, this.size);

    ArraySorter.sortArray(this.toSort, THREE_WAY_STRAT);

    return this.toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureThreeWayDuplicate() {
    Integer[] sorted = ArraySorter.sortArray(this.duplicate, THREE_WAY_STRAT);

    return sorted;
  }
}

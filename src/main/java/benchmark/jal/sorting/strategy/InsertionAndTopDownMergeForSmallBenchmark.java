package org.jal.benchmark;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.InsertionStrategy;
import org.jal.sorting.strategy.TopDownMergeStrategy;
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
public class InsertionAndTopDownMergeForSmallBenchmark {
  Integer[] reversed;
  Integer[] sorted;

  @Param({"2", "4", "8", "16", "32", "64"})
  int size;

  @Setup(Level.Iteration)
  public void setup() {
    this.reversed = Stream.iterate(this.size, n -> n-1).limit(this.size).toArray(Integer[]::new);
    this.sorted = Stream.iterate(0, n -> n+1).limit(this.size).toArray(Integer[]::new);
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureTopDownMergeForReversed() {
    Integer[] toSort = this.reversed.clone();

    Sorter.sortArray(toSort, new TopDownMergeStrategy<>());

    return toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureInsertionForReversed() {
    Integer[] toSort = this.reversed.clone();

    Sorter.sortArray(toSort, new InsertionStrategy<>());

    return toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureTopDownMergeForSorted() {
    Integer[] sorted = Sorter.sortArray(this.sorted, new TopDownMergeStrategy<>());

    return sorted;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureInsertionForSorted() {
    Integer[] sorted = Sorter.sortArray(this.sorted, new InsertionStrategy<>());

    return sorted;
  }
}

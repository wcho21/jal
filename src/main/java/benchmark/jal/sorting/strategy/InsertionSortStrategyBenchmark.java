package org.jal.benchmark;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.InsertionSortStrategy;
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
public class InsertionSortStrategyBenchmark {
  Integer[] reversed;
  Integer[] sorted;

  @Param({"128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072"})
  int size;

  @Setup(Level.Iteration)
  public void setup() {
    this.reversed = Stream.iterate(this.size, n -> n-1).limit(this.size).toArray(Integer[]::new);
    this.sorted = Stream.iterate(0, n -> n+1).limit(this.size).toArray(Integer[]::new);
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public Integer[] measureWorst() {
    Integer[] toSort = this.reversed.clone();

    Sorter.sortArray(toSort, new InsertionSortStrategy());

    return toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.NANOSECONDS)
  public Integer[] measureBest() {
    Integer[] sorted = Sorter.sortArray(this.sorted, new InsertionSortStrategy());

    return sorted;
  }
}

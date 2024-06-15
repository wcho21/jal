package benchmark.jal.sorting.strategy.arrays;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.jal.sorting.ArraySorter;
import org.jal.sorting.strategy.arrays.TopDownInsMergeStrategy;
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
public class TopDownInsMergeStrategyBenchmark {
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
  public Integer[] measureReversed() {
    Integer[] toSort = this.reversed.clone();

    ArraySorter.sortArray(toSort, new TopDownInsMergeStrategy<>());

    return toSort;
  }

  @Benchmark
  @OutputTimeUnit(TimeUnit.MICROSECONDS)
  public Integer[] measureSorted() {
    Integer[] sorted = ArraySorter.sortArray(this.sorted, new TopDownInsMergeStrategy<>());

    return sorted;
  }
}

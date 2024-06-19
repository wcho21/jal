package benchmark.jal.search;

import static java.util.Collections.shuffle;
import static org.jal.search.QuickSelectArray.select;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jal.partition.PartitionStrategy;
import org.jal.partition.RandTwoWayStrategy;
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
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class QuickSelectArrayBenchmark {
  private Integer[] shuffled;
  private Integer[] input;

  @Param({"128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072"})
  int size;

  @Setup(Level.Iteration)
  public void setup() {
    // make shuffled array
    List<Integer> list = IntStream.range(0, this.size).boxed().collect(Collectors.toList());
    shuffle(list, new Random(0));
    this.shuffled = list.toArray(new Integer[0]);

    // initialize input size
    this.input = new Integer[this.size];
  }

  @Benchmark
  public int measure() {
    System.arraycopy(this.shuffled, 0, this.input, 0, this.size);

    PartitionStrategy<Integer> strat = new RandTwoWayStrategy<>(new Random()::nextInt);

    int first = select(input, 0, strat);

    return first;
  }
}

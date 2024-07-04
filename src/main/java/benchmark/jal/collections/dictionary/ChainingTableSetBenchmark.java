package benchmark.jal.collections.dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import org.jal.collections.dictionary.ChainingTable;
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
public class ChainingTableSetBenchmark {
  private ChainingTable<Integer, Integer> table;
  private Iterable<Integer> numsToSet;
  private Random rand = new Random();

  @Param({"128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072"})
  int size;

  @Setup(Level.Iteration)
  public void setup() {
    // initialize shuffled numbers
    Set<Integer> nums = new HashSet<>();
    while (nums.size() < this.size) {
      nums.add(this.rand.nextInt(Integer.MAX_VALUE));
    }
    this.numsToSet = new ArrayList<>(StreamSupport.stream(nums.spliterator(), false).toList());

    // initialize a table
    this.table = new ChainingTable<>(v -> v);
  }

  @Benchmark
  public void measureSet() {
    for (int num : this.numsToSet) {
      this.table.set(num);
    }
  }
}

package benchmark.jal.collections.dictionary;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;

import org.jal.collections.dictionary.LinearProbingTable;
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
public class LinearProbingTableGetLoadFactorBenchmark {
  private LinearProbingTable<Integer, Integer> table;
  private Random rand = new Random();
  private Integer[] nums;
  private int numSlots = 131072;
  private int size;

  // load factor must be >= 0.375 and < 0.75 due to implementation
  @Param({"0.375", "0.4", "0.425", "0.45", "0.475", "0.5", "0.525", "0.55", "0.575", "0.6", "0.625", "0.65", "0.675", "0.7", "0.725"})
  double loadFactor;

  @Setup(Level.Iteration)
  public void setup() {
    this.size = (int)(this.numSlots * loadFactor + 1);

    // initialize shuffled numbers
    Set<Integer> nums = new HashSet<>();
    while (nums.size() < this.size) {
      nums.add(this.rand.nextInt(Integer.MAX_VALUE));
    }
    this.nums = StreamSupport.stream(nums.spliterator(), false).toArray(Integer[]::new);

    // initialize a table
    this.table = new LinearProbingTable<>(v -> v);
    for (int num : this.nums) {
      this.table.set(num);
    }
  }

  @Benchmark
  public int measureGet() {
    int key = this.nums[this.rand.nextInt(this.size)];
    int value = this.table.get(key);
    return value;
  }
}

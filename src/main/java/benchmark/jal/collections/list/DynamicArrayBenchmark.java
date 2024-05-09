package benchmark.jal.collections.list;

import jal.collections.DynamicArray;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class DynamicArrayBenchmark {
  DynamicArray<Integer> arr;

  @Param({"128", "256", "512", "1024", "2048"})
  int size;

  @Benchmark
  public DynamicArray<Integer> measureAppend() {
    this.arr = new DynamicArray<>();
    for (int i = 0; i < this.size; ++i) {
      this.arr.append(0);
    }

    return this.arr;
  }

  @Benchmark
  public DynamicArray<Integer> measureAppendAndRemove() {
    this.arr = new DynamicArray<>();
    for (int i = 0; i < this.size; ++i) {
      this.arr.append(0);
    }
    for (int i = 0; i < this.size; ++i) {
      this.arr.remove();
    }

    return this.arr;
  }
}

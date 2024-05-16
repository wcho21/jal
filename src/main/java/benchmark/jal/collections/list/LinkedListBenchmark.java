package org.jal.benchmark;

import java.util.concurrent.TimeUnit;
import org.jal.collections.list.LinkedList;
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
public class LinkedListBenchmark {
  LinkedList<Integer> list;

  @Param({"128", "256", "512", "1024", "2048"})
  int size;

  @Benchmark
  public void measurePrepend() {
    this.list = new LinkedList<>();
    for (int i = 0; i < this.size; ++i) {
      this.list.prepend(0);
    }
  }

  @Benchmark
  public void measurePrependAndRemove() {
    this.list = new LinkedList<>();
    for (int i = 0; i < this.size; ++i) {
      this.list.prepend(0);
    }
    for (int i = 0; i < this.size; ++i) {
      this.list.remove();
    }
  }
}

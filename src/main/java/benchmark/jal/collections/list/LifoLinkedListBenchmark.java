package benchmark.jal.collections.list;

import java.util.concurrent.TimeUnit;

import org.jal.collections.list.LifoLinkedList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class LifoLinkedListBenchmark {
  LifoLinkedList<Integer> list;

  @Param({"128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536", "131072"})
  int size;

  @Benchmark
  public void measurePrepend() {
    this.list = new LifoLinkedList<>();
    for (int i = 0; i < this.size; ++i) {
      this.list.prepend(0);
    }
  }

  @Benchmark
  public void measurePrependAndRemove() {
    this.list = new LifoLinkedList<>();
    for (int i = 0; i < this.size; ++i) {
      this.list.prepend(0);
    }
    for (int i = 0; i < this.size; ++i) {
      this.list.remove();
    }
  }
}

package benchmark.jal.math;

import java.util.concurrent.TimeUnit;

import org.jal.math.Euclid;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class EuclidBenchmark {
  @Benchmark
  public int measure1() {
    int fib17 = 1597;
    int fib18 = 2584;
    return Euclid.getGCD(fib17, fib18);
  }

  @Benchmark
  public int measure2() {
    int fib21 = 10946;
    int fib22 = 17711;
    return Euclid.getGCD(fib21, fib22);
  }

  @Benchmark
  public int measure3() {
    int fib26 = 121393;
    int fib27 = 196418;
    return Euclid.getGCD(fib26, fib27);
  }

  @Benchmark
  public int measure4() {
    int fib31 = 1346269;
    int fib32 = 2178309;
    return Euclid.getGCD(fib31, fib32);
  }

  @Benchmark
  public int measure5() {
    int fib36 = 14930352;
    int fib37 = 24157817;
    return Euclid.getGCD(fib36, fib37);
  }

  @Benchmark
  public int measure6() {
    int fib40 = 102334155;
    int fib41 = 165580141;
    return Euclid.getGCD(fib40, fib41);
  }

  @Benchmark
  public int measure7() {
    int fib45 = 1134903170;
    int fib46 = 1836311903;
    return Euclid.getGCD(fib45, fib46);
  }
}

```
$ java -jar target/benchmarks.jar HeapStrategyBenchmark -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                              (size)  Mode  Cnt      Score   Error  Units
HeapStrategyBenchmark.measureReversed     128  avgt           6.436          us/op
HeapStrategyBenchmark.measureReversed     256  avgt          34.185          us/op
HeapStrategyBenchmark.measureReversed     512  avgt          95.113          us/op
HeapStrategyBenchmark.measureReversed    1024  avgt         229.396          us/op
HeapStrategyBenchmark.measureReversed    2048  avgt         524.036          us/op
HeapStrategyBenchmark.measureReversed    4096  avgt         881.654          us/op
HeapStrategyBenchmark.measureReversed    8192  avgt        2120.447          us/op
HeapStrategyBenchmark.measureReversed   16384  avgt        4674.993          us/op
HeapStrategyBenchmark.measureReversed   32768  avgt        8142.639          us/op
HeapStrategyBenchmark.measureReversed   65536  avgt       17509.782          us/op
HeapStrategyBenchmark.measureReversed  131072  avgt       37364.371          us/op
HeapStrategyBenchmark.measureSorted       128  avgt           7.280          us/op
HeapStrategyBenchmark.measureSorted       256  avgt          45.841          us/op
HeapStrategyBenchmark.measureSorted       512  avgt         137.573          us/op
HeapStrategyBenchmark.measureSorted      1024  avgt         271.065          us/op
HeapStrategyBenchmark.measureSorted      2048  avgt         588.812          us/op
HeapStrategyBenchmark.measureSorted      4096  avgt        1233.728          us/op
HeapStrategyBenchmark.measureSorted      8192  avgt        2621.094          us/op
HeapStrategyBenchmark.measureSorted     16384  avgt        4169.806          us/op
HeapStrategyBenchmark.measureSorted     32768  avgt        8903.692          us/op
HeapStrategyBenchmark.measureSorted     65536  avgt       19089.120          us/op
HeapStrategyBenchmark.measureSorted    131072  avgt       40860.837          us/op
```

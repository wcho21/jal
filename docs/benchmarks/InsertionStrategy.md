```
$ java -jar target/benchmarks.jar InsertionStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                (size)  Mode  Cnt         Score   Error  Units
InsertionStrategyBenchmark.measureBest      128  avgt             41.331          ns/op
InsertionStrategyBenchmark.measureBest      256  avgt             86.527          ns/op
InsertionStrategyBenchmark.measureBest      512  avgt            166.992          ns/op
InsertionStrategyBenchmark.measureBest     1024  avgt            328.061          ns/op
InsertionStrategyBenchmark.measureBest     2048  avgt            655.077          ns/op
InsertionStrategyBenchmark.measureBest     4096  avgt           1315.272          ns/op
InsertionStrategyBenchmark.measureBest     8192  avgt           3091.728          ns/op
InsertionStrategyBenchmark.measureBest    16384  avgt           6077.352          ns/op
InsertionStrategyBenchmark.measureBest    32768  avgt          12289.136          ns/op
InsertionStrategyBenchmark.measureBest    65536  avgt          25985.574          ns/op
InsertionStrategyBenchmark.measureBest   131072  avgt          59708.181          ns/op
InsertionStrategyBenchmark.measureWorst     128  avgt             15.193          us/op
InsertionStrategyBenchmark.measureWorst     256  avgt             72.249          us/op
InsertionStrategyBenchmark.measureWorst     512  avgt            262.639          us/op
InsertionStrategyBenchmark.measureWorst    1024  avgt           1322.160          us/op
InsertionStrategyBenchmark.measureWorst    2048  avgt           5873.502          us/op
InsertionStrategyBenchmark.measureWorst    4096  avgt          23125.643          us/op
InsertionStrategyBenchmark.measureWorst    8192  avgt          92194.907          us/op
InsertionStrategyBenchmark.measureWorst   16384  avgt         375706.650          us/op
InsertionStrategyBenchmark.measureWorst   32768  avgt        1556346.381          us/op
InsertionStrategyBenchmark.measureWorst   65536  avgt        6601758.459          us/op
InsertionStrategyBenchmark.measureWorst  131072  avgt       29108835.833          us/op
```

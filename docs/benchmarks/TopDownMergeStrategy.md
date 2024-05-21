```
$ java -jar target/benchmarks.jar TopDownMergeStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                      (size)  Mode  Cnt     Score   Error  Units
TopDownMergeStrategyBenchmark.measureReversed     128  avgt          3.339          us/op
TopDownMergeStrategyBenchmark.measureReversed     256  avgt          7.647          us/op
TopDownMergeStrategyBenchmark.measureReversed     512  avgt         16.422          us/op
TopDownMergeStrategyBenchmark.measureReversed    1024  avgt         36.621          us/op
TopDownMergeStrategyBenchmark.measureReversed    2048  avgt         76.350          us/op
TopDownMergeStrategyBenchmark.measureReversed    4096  avgt        167.422          us/op
TopDownMergeStrategyBenchmark.measureReversed    8192  avgt        339.917          us/op
TopDownMergeStrategyBenchmark.measureReversed   16384  avgt        744.971          us/op
TopDownMergeStrategyBenchmark.measureReversed   32768  avgt       1568.347          us/op
TopDownMergeStrategyBenchmark.measureReversed   65536  avgt       3340.317          us/op
TopDownMergeStrategyBenchmark.measureReversed  131072  avgt       8296.393          us/op
TopDownMergeStrategyBenchmark.measureSorted       128  avgt          3.384          us/op
TopDownMergeStrategyBenchmark.measureSorted       256  avgt          7.465          us/op
TopDownMergeStrategyBenchmark.measureSorted       512  avgt         15.666          us/op
TopDownMergeStrategyBenchmark.measureSorted      1024  avgt         35.110          us/op
TopDownMergeStrategyBenchmark.measureSorted      2048  avgt         75.537          us/op
TopDownMergeStrategyBenchmark.measureSorted      4096  avgt        159.563          us/op
TopDownMergeStrategyBenchmark.measureSorted      8192  avgt        339.642          us/op
TopDownMergeStrategyBenchmark.measureSorted     16384  avgt        728.562          us/op
TopDownMergeStrategyBenchmark.measureSorted     32768  avgt       1509.518          us/op
TopDownMergeStrategyBenchmark.measureSorted     65536  avgt       3268.032          us/op
TopDownMergeStrategyBenchmark.measureSorted    131072  avgt       7544.924          us/op
```

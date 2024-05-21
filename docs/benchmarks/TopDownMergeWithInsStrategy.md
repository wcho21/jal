```
$ java -jar target/benchmarks.jar TopDownMergeWithInsStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                             (size)  Mode  Cnt     Score   Error  Units
TopDownMergeWithInsStrategyBenchmark.measureReversed     128  avgt          2.596          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed     256  avgt          5.917          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed     512  avgt         13.157          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed    1024  avgt         28.144          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed    2048  avgt         64.028          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed    4096  avgt        141.827          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed    8192  avgt        294.040          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed   16384  avgt        626.597          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed   32768  avgt       1337.781          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed   65536  avgt       2790.782          us/op
TopDownMergeWithInsStrategyBenchmark.measureReversed  131072  avgt       7428.002          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted       128  avgt          1.979          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted       256  avgt          4.729          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted       512  avgt         10.365          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted      1024  avgt         23.717          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted      2048  avgt         51.678          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted      4096  avgt        113.840          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted      8192  avgt        248.030          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted     16384  avgt        542.785          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted     32768  avgt       1135.054          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted     65536  avgt       2452.124          us/op
TopDownMergeWithInsStrategyBenchmark.measureSorted    131072  avgt       6032.887          us/op
```

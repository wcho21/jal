```
$ java -jar target/benchmarks.jar TopDownInsMergeStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                         (size)  Mode  Cnt     Score   Error  Units
TopDownInsMergeStrategyBenchmark.measureReversed     128  avgt          2.596          us/op
TopDownInsMergeStrategyBenchmark.measureReversed     256  avgt          5.917          us/op
TopDownInsMergeStrategyBenchmark.measureReversed     512  avgt         13.157          us/op
TopDownInsMergeStrategyBenchmark.measureReversed    1024  avgt         28.144          us/op
TopDownInsMergeStrategyBenchmark.measureReversed    2048  avgt         64.028          us/op
TopDownInsMergeStrategyBenchmark.measureReversed    4096  avgt        141.827          us/op
TopDownInsMergeStrategyBenchmark.measureReversed    8192  avgt        294.040          us/op
TopDownInsMergeStrategyBenchmark.measureReversed   16384  avgt        626.597          us/op
TopDownInsMergeStrategyBenchmark.measureReversed   32768  avgt       1337.781          us/op
TopDownInsMergeStrategyBenchmark.measureReversed   65536  avgt       2790.782          us/op
TopDownInsMergeStrategyBenchmark.measureReversed  131072  avgt       7428.002          us/op
TopDownInsMergeStrategyBenchmark.measureSorted       128  avgt          1.979          us/op
TopDownInsMergeStrategyBenchmark.measureSorted       256  avgt          4.729          us/op
TopDownInsMergeStrategyBenchmark.measureSorted       512  avgt         10.365          us/op
TopDownInsMergeStrategyBenchmark.measureSorted      1024  avgt         23.717          us/op
TopDownInsMergeStrategyBenchmark.measureSorted      2048  avgt         51.678          us/op
TopDownInsMergeStrategyBenchmark.measureSorted      4096  avgt        113.840          us/op
TopDownInsMergeStrategyBenchmark.measureSorted      8192  avgt        248.030          us/op
TopDownInsMergeStrategyBenchmark.measureSorted     16384  avgt        542.785          us/op
TopDownInsMergeStrategyBenchmark.measureSorted     32768  avgt       1135.054          us/op
TopDownInsMergeStrategyBenchmark.measureSorted     65536  avgt       2452.124          us/op
TopDownInsMergeStrategyBenchmark.measureSorted    131072  avgt       6032.887          us/op
```

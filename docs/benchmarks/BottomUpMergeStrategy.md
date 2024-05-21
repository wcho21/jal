```
$ java -jar target/benchmarks.jar BottomUpMergeStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                       (size)  Mode  Cnt     Score   Error  Units
BottomUpMergeStrategyBenchmark.measureReversed     128  avgt          3.621          us/op
BottomUpMergeStrategyBenchmark.measureReversed     256  avgt          7.885          us/op
BottomUpMergeStrategyBenchmark.measureReversed     512  avgt         17.371          us/op
BottomUpMergeStrategyBenchmark.measureReversed    1024  avgt         38.164          us/op
BottomUpMergeStrategyBenchmark.measureReversed    2048  avgt         83.395          us/op
BottomUpMergeStrategyBenchmark.measureReversed    4096  avgt        173.268          us/op
BottomUpMergeStrategyBenchmark.measureReversed    8192  avgt        367.640          us/op
BottomUpMergeStrategyBenchmark.measureReversed   16384  avgt        778.188          us/op
BottomUpMergeStrategyBenchmark.measureReversed   32768  avgt       1645.252          us/op
BottomUpMergeStrategyBenchmark.measureReversed   65536  avgt       3601.670          us/op
BottomUpMergeStrategyBenchmark.measureReversed  131072  avgt       8696.493          us/op
BottomUpMergeStrategyBenchmark.measureSorted       128  avgt          3.559          us/op
BottomUpMergeStrategyBenchmark.measureSorted       256  avgt          7.787          us/op
BottomUpMergeStrategyBenchmark.measureSorted       512  avgt         16.697          us/op
BottomUpMergeStrategyBenchmark.measureSorted      1024  avgt         36.849          us/op
BottomUpMergeStrategyBenchmark.measureSorted      2048  avgt         80.524          us/op
BottomUpMergeStrategyBenchmark.measureSorted      4096  avgt        170.150          us/op
BottomUpMergeStrategyBenchmark.measureSorted      8192  avgt        370.079          us/op
BottomUpMergeStrategyBenchmark.measureSorted     16384  avgt        781.537          us/op
BottomUpMergeStrategyBenchmark.measureSorted     32768  avgt       1672.174          us/op
BottomUpMergeStrategyBenchmark.measureSorted     65536  avgt       3520.943          us/op
BottomUpMergeStrategyBenchmark.measureSorted    131072  avgt       8435.681          us/op
```

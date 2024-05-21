```
$ java -jar target/benchmarks.jar NaturalMergeStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                   (size)  Mode  Cnt      Score   Error  Units
NaturalMergeStrategyBenchmark.measureBest      128  avgt           0.055          us/op
NaturalMergeStrategyBenchmark.measureBest      256  avgt           0.109          us/op
NaturalMergeStrategyBenchmark.measureBest      512  avgt           0.211          us/op
NaturalMergeStrategyBenchmark.measureBest     1024  avgt           0.432          us/op
NaturalMergeStrategyBenchmark.measureBest     2048  avgt           1.114          us/op
NaturalMergeStrategyBenchmark.measureBest     4096  avgt           2.132          us/op
NaturalMergeStrategyBenchmark.measureBest     8192  avgt           4.437          us/op
NaturalMergeStrategyBenchmark.measureBest    16384  avgt           8.930          us/op
NaturalMergeStrategyBenchmark.measureBest    32768  avgt          17.008          us/op
NaturalMergeStrategyBenchmark.measureBest    65536  avgt          35.336          us/op
NaturalMergeStrategyBenchmark.measureBest   131072  avgt         193.033          us/op
NaturalMergeStrategyBenchmark.measureWorst     128  avgt           4.162          us/op
NaturalMergeStrategyBenchmark.measureWorst     256  avgt           9.125          us/op
NaturalMergeStrategyBenchmark.measureWorst     512  avgt          20.072          us/op
NaturalMergeStrategyBenchmark.measureWorst    1024  avgt          44.420          us/op
NaturalMergeStrategyBenchmark.measureWorst    2048  avgt          98.234          us/op
NaturalMergeStrategyBenchmark.measureWorst    4096  avgt         205.665          us/op
NaturalMergeStrategyBenchmark.measureWorst    8192  avgt         437.470          us/op
NaturalMergeStrategyBenchmark.measureWorst   16384  avgt         915.631          us/op
NaturalMergeStrategyBenchmark.measureWorst   32768  avgt        1957.540          us/op
NaturalMergeStrategyBenchmark.measureWorst   65536  avgt        4512.461          us/op
NaturalMergeStrategyBenchmark.measureWorst  131072  avgt       10501.068          us/op
```

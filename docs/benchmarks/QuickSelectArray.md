```
$ java -jar target/benchmarks.jar QuickSelectArrayBenchmark -f 1 -wi 0 -i 3
```

```
Benchmark                          (size)  Mode  Cnt        Score   Error  Units
QuickSelectArrayBenchmark.measure     128  avgt           951.570          ns/op
QuickSelectArrayBenchmark.measure     256  avgt          1870.909          ns/op
QuickSelectArrayBenchmark.measure     512  avgt          3862.364          ns/op
QuickSelectArrayBenchmark.measure    1024  avgt          7883.799          ns/op
QuickSelectArrayBenchmark.measure    2048  avgt         16207.256          ns/op
QuickSelectArrayBenchmark.measure    4096  avgt         31141.925          ns/op
QuickSelectArrayBenchmark.measure    8192  avgt         64285.067          ns/op
QuickSelectArrayBenchmark.measure   16384  avgt        133321.560          ns/op
QuickSelectArrayBenchmark.measure   32768  avgt        300842.262          ns/op
QuickSelectArrayBenchmark.measure   65536  avgt        593985.908          ns/op
QuickSelectArrayBenchmark.measure  131072  avgt       1209886.180          ns/op
```

```
$ java -jar target/benchmarks.jar "ChainingTableGetBenchmark" -f 1 -wi 0 -i 1 -r 5 -e "FixedChainingTable"
```

```
Benchmark                             (size)  Mode  Cnt   Score   Error  Units
ChainingTableGetBenchmark.measureGet     128  avgt       27.556          ns/op
ChainingTableGetBenchmark.measureGet     256  avgt       25.913          ns/op
ChainingTableGetBenchmark.measureGet     512  avgt       26.968          ns/op
ChainingTableGetBenchmark.measureGet    1024  avgt       29.904          ns/op
ChainingTableGetBenchmark.measureGet    2048  avgt       32.317          ns/op
ChainingTableGetBenchmark.measureGet    4096  avgt       34.262          ns/op
ChainingTableGetBenchmark.measureGet    8192  avgt       34.846          ns/op
ChainingTableGetBenchmark.measureGet   16384  avgt       35.829          ns/op
ChainingTableGetBenchmark.measureGet   32768  avgt       36.655          ns/op
ChainingTableGetBenchmark.measureGet   65536  avgt       31.790          ns/op
ChainingTableGetBenchmark.measureGet  131072  avgt       45.228          ns/op
```

```
$ java -jar target/benchmarks.jar "ChainingTableSetBenchmark" -f 1 -wi 0 -i 1 -r 5 -e "FixedChainingTable"
```

```
Benchmark                             (size)  Mode  Cnt        Score   Error  Units
ChainingTableSetBenchmark.measureSet     128  avgt          1123.103          ns/op
ChainingTableSetBenchmark.measureSet     256  avgt          2912.982          ns/op
ChainingTableSetBenchmark.measureSet     512  avgt          5714.810          ns/op
ChainingTableSetBenchmark.measureSet    1024  avgt         11755.098          ns/op
ChainingTableSetBenchmark.measureSet    2048  avgt         30629.113          ns/op
ChainingTableSetBenchmark.measureSet    4096  avgt         68213.073          ns/op
ChainingTableSetBenchmark.measureSet    8192  avgt        158018.157          ns/op
ChainingTableSetBenchmark.measureSet   16384  avgt        364474.666          ns/op
ChainingTableSetBenchmark.measureSet   32768  avgt        796101.218          ns/op
ChainingTableSetBenchmark.measureSet   65536  avgt       1661174.533          ns/op
ChainingTableSetBenchmark.measureSet  131072  avgt       3755545.324          ns/op
```

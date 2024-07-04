```
$ java -jar target/benchmarks.jar "FixedChainingTableGetBenchmark" -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                  (size)  Mode  Cnt      Score   Error  Units
FixedChainingTableGetBenchmark.measureGet     128  avgt          34.786          ns/op
FixedChainingTableGetBenchmark.measureGet     256  avgt          42.846          ns/op
FixedChainingTableGetBenchmark.measureGet     512  avgt          60.416          ns/op
FixedChainingTableGetBenchmark.measureGet    1024  avgt          91.794          ns/op
FixedChainingTableGetBenchmark.measureGet    2048  avgt         201.585          ns/op
FixedChainingTableGetBenchmark.measureGet    4096  avgt         591.176          ns/op
FixedChainingTableGetBenchmark.measureGet    8192  avgt        1441.377          ns/op
FixedChainingTableGetBenchmark.measureGet   16384  avgt        2938.349          ns/op
FixedChainingTableGetBenchmark.measureGet   32768  avgt        6152.936          ns/op
FixedChainingTableGetBenchmark.measureGet   65536  avgt       12974.841          ns/op
FixedChainingTableGetBenchmark.measureGet  131072  avgt       26659.197          ns/op
```

```
$ java -jar target/benchmarks.jar "FixedChainingTableSetBenchmark" -f 1 -wi 0 -i 1 -r 15
```

```
Benchmark                                  (size)  Mode  Cnt           Score   Error  Units
FixedChainingTableSetBenchmark.measureSet     128  avgt             2245.501          ns/op
FixedChainingTableSetBenchmark.measureSet     256  avgt             7461.650          ns/op
FixedChainingTableSetBenchmark.measureSet     512  avgt            32496.109          ns/op
FixedChainingTableSetBenchmark.measureSet    1024  avgt           143192.942          ns/op
FixedChainingTableSetBenchmark.measureSet    2048  avgt           577619.505          ns/op
FixedChainingTableSetBenchmark.measureSet    4096  avgt          2857839.673          ns/op
FixedChainingTableSetBenchmark.measureSet    8192  avgt          9422427.704          ns/op
FixedChainingTableSetBenchmark.measureSet   16384  avgt         55867059.015          ns/op
FixedChainingTableSetBenchmark.measureSet   32768  avgt        369972003.049          ns/op
FixedChainingTableSetBenchmark.measureSet   65536  avgt       1763542921.333          ns/op
FixedChainingTableSetBenchmark.measureSet  131072  avgt       6039339958.333          ns/op
```

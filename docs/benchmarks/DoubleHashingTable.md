```
$ java -jar target/benchmarks.jar "DoubleHashingTableGetBenchmark" -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                  (size)  Mode  Cnt   Score   Error  Units
DoubleHashingTableGetBenchmark.measureGet      48  avgt       13.486          ns/op
DoubleHashingTableGetBenchmark.measureGet      96  avgt       14.368          ns/op
DoubleHashingTableGetBenchmark.measureGet     192  avgt       14.359          ns/op
DoubleHashingTableGetBenchmark.measureGet     384  avgt       14.443          ns/op
DoubleHashingTableGetBenchmark.measureGet     768  avgt       14.846          ns/op
DoubleHashingTableGetBenchmark.measureGet    1536  avgt       15.104          ns/op
DoubleHashingTableGetBenchmark.measureGet    3072  avgt       17.224          ns/op
DoubleHashingTableGetBenchmark.measureGet    6144  avgt       19.424          ns/op
DoubleHashingTableGetBenchmark.measureGet   12288  avgt       21.711          ns/op
DoubleHashingTableGetBenchmark.measureGet   24576  avgt       22.095          ns/op
DoubleHashingTableGetBenchmark.measureGet   49152  avgt       23.383          ns/op
DoubleHashingTableGetBenchmark.measureGet   98304  avgt       25.525          ns/op
```

```
$ java -jar target/benchmarks.jar "DoubleHashingTableGetLoadFactorBenchmark" -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                            (loadFactor)  Mode  Cnt   Score   Error  Units
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.375  avgt       23.165          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet           0.4  avgt       24.209          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.425  avgt       25.194          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet          0.45  avgt       25.899          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.475  avgt       27.230          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet           0.5  avgt       25.865          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.525  avgt       28.543          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet          0.55  avgt       29.456          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.575  avgt       30.524          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet           0.6  avgt       31.673          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.625  avgt       32.846          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet          0.65  avgt       34.024          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.675  avgt       35.036          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet           0.7  avgt       36.247          ns/op
DoubleHashingTableGetLoadFactorBenchmark.measureGet         0.725  avgt       37.568          ns/op
```

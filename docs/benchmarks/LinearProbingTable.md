```
$ java -jar target/benchmarks.jar "LinearProbingTableGetBenchmark" -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                  (size)  Mode  Cnt   Score   Error  Units
LinearProbingTableGetBenchmark.measureGet      48  avgt       11.478          ns/op
LinearProbingTableGetBenchmark.measureGet      96  avgt       15.905          ns/op
LinearProbingTableGetBenchmark.measureGet     192  avgt       13.852          ns/op
LinearProbingTableGetBenchmark.measureGet     384  avgt       15.282          ns/op
LinearProbingTableGetBenchmark.measureGet     768  avgt       15.334          ns/op
LinearProbingTableGetBenchmark.measureGet    1536  avgt       15.242          ns/op
LinearProbingTableGetBenchmark.measureGet    3072  avgt       17.677          ns/op
LinearProbingTableGetBenchmark.measureGet    6144  avgt       19.561          ns/op
LinearProbingTableGetBenchmark.measureGet   12288  avgt       21.487          ns/op
LinearProbingTableGetBenchmark.measureGet   24576  avgt       22.208          ns/op
LinearProbingTableGetBenchmark.measureGet   49152  avgt       23.102          ns/op
LinearProbingTableGetBenchmark.measureGet   98304  avgt       26.547          ns/op
```

```
$ java -jar target/benchmarks.jar "LinearProbingTableGetLoadFactorBenchmark" -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                            (loadFactor)  Mode  Cnt   Score   Error  Units
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.375  avgt       23.412          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet           0.4  avgt       24.314          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.425  avgt       24.971          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet          0.45  avgt       25.996          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.475  avgt       26.501          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet           0.5  avgt       27.382          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.525  avgt       28.102          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet          0.55  avgt       29.236          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.575  avgt       30.179          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet           0.6  avgt       31.123          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.625  avgt       32.042          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet          0.65  avgt       33.058          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.675  avgt       33.145          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet           0.7  avgt       34.344          ns/op
LinearProbingTableGetLoadFactorBenchmark.measureGet         0.725  avgt       35.078          ns/op
```

```
$ java -jar target/benchmarks.jar "FixedChainingTableGetBenchmark" -f 1 -wi 0 -i 9
```

```
Benchmark                                  (size)  Mode  Cnt      Score       Error  Units
FixedChainingTableGetBenchmark.measureGet     128  avgt    9     28.858 ±     0.234  ns/op
FixedChainingTableGetBenchmark.measureGet     256  avgt    9     45.896 ±     2.581  ns/op
FixedChainingTableGetBenchmark.measureGet     512  avgt    9     57.648 ±     0.349  ns/op
FixedChainingTableGetBenchmark.measureGet    1024  avgt    9     88.158 ±     0.523  ns/op
FixedChainingTableGetBenchmark.measureGet    2048  avgt    9    152.477 ±     1.525  ns/op
FixedChainingTableGetBenchmark.measureGet    4096  avgt    9    309.435 ±    14.706  ns/op
FixedChainingTableGetBenchmark.measureGet    8192  avgt    9    716.303 ±   108.558  ns/op
FixedChainingTableGetBenchmark.measureGet   16384  avgt    9   1861.819 ±  1108.650  ns/op
FixedChainingTableGetBenchmark.measureGet   32768  avgt    9   4363.157 ±  2748.432  ns/op
FixedChainingTableGetBenchmark.measureGet   65536  avgt    9  11993.098 ±  3177.173  ns/op
FixedChainingTableGetBenchmark.measureGet  131072  avgt    9  22717.717 ± 12258.117  ns/op
```

```
$ java -jar target/benchmarks.jar "FixedChainingTableSetBenchmark" -f 1 -wi 0 -i 9
```

```
Benchmark                                  (size)  Mode  Cnt           Score            Error  Units
FixedChainingTableSetBenchmark.measureSet     128  avgt    9        2245.991 ±         76.228  ns/op
FixedChainingTableSetBenchmark.measureSet     256  avgt    9        7303.539 ±        218.012  ns/op
FixedChainingTableSetBenchmark.measureSet     512  avgt    9       31708.943 ±        368.580  ns/op
FixedChainingTableSetBenchmark.measureSet    1024  avgt    9      141534.340 ±       1177.159  ns/op
FixedChainingTableSetBenchmark.measureSet    2048  avgt    9      579573.213 ±       3820.547  ns/op
FixedChainingTableSetBenchmark.measureSet    4096  avgt    9     2905725.867 ±      88653.900  ns/op
FixedChainingTableSetBenchmark.measureSet    8192  avgt    9    10096777.174 ±     822540.305  ns/op
FixedChainingTableSetBenchmark.measureSet   16384  avgt    9    77103145.818 ±   29793652.229  ns/op
FixedChainingTableSetBenchmark.measureSet   32768  avgt    9   385598618.816 ±  184688234.687  ns/op
FixedChainingTableSetBenchmark.measureSet   65536  avgt    9  1575934296.278 ±  574039735.975  ns/op
FixedChainingTableSetBenchmark.measureSet  131072  avgt    9  5249668304.833 ± 1048195646.389  ns/op
```

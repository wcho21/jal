```
$ java -jar target/benchmarks.jar "ChainingTableGetBenchmark" -f 1 -wi 5 -i 3 -e "FixedChainingTable"
```

```
Benchmark                             (size)  Mode  Cnt   Score    Error  Units
ChainingTableGetBenchmark.measureGet     128  avgt    3  17.589 ±  0.353  ns/op
ChainingTableGetBenchmark.measureGet     256  avgt    3  23.379 ± 40.115  ns/op
ChainingTableGetBenchmark.measureGet     512  avgt    3  18.555 ±  0.351  ns/op
ChainingTableGetBenchmark.measureGet    1024  avgt    3  17.921 ±  0.879  ns/op
ChainingTableGetBenchmark.measureGet    2048  avgt    3  18.429 ±  1.474  ns/op
ChainingTableGetBenchmark.measureGet    4096  avgt    3  19.316 ±  0.486  ns/op
ChainingTableGetBenchmark.measureGet    8192  avgt    3  19.820 ±  1.929  ns/op
ChainingTableGetBenchmark.measureGet   16384  avgt    3  20.262 ±  0.817  ns/op
ChainingTableGetBenchmark.measureGet   32768  avgt    3  20.597 ±  0.038  ns/op
ChainingTableGetBenchmark.measureGet   65536  avgt    3  20.826 ±  1.057  ns/op
ChainingTableGetBenchmark.measureGet  131072  avgt    3  21.757 ±  3.333  ns/op
```

```
$ java -jar target/benchmarks.jar "ChainingTableSetBenchmark" -f 1 -wi 5 -i 3 -e "FixedChainingTable"
```

```
Benchmark                             (size)  Mode  Cnt        Score         Error  Units
ChainingTableSetBenchmark.measureSet     128  avgt    3     1228.422 ±     126.051  ns/op
ChainingTableSetBenchmark.measureSet     256  avgt    3     2786.464 ±    1694.633  ns/op
ChainingTableSetBenchmark.measureSet     512  avgt    3     5510.264 ±    2564.431  ns/op
ChainingTableSetBenchmark.measureSet    1024  avgt    3    11152.399 ±    2879.284  ns/op
ChainingTableSetBenchmark.measureSet    2048  avgt    3    26555.388 ±    3881.874  ns/op
ChainingTableSetBenchmark.measureSet    4096  avgt    3    76112.395 ±    6360.479  ns/op
ChainingTableSetBenchmark.measureSet    8192  avgt    3   170265.048 ±   12283.326  ns/op
ChainingTableSetBenchmark.measureSet   16384  avgt    3   377573.011 ±    2285.815  ns/op
ChainingTableSetBenchmark.measureSet   32768  avgt    3   781849.117 ±   15942.628  ns/op
ChainingTableSetBenchmark.measureSet   65536  avgt    3  1620281.151 ±   62820.428  ns/op
ChainingTableSetBenchmark.measureSet  131072  avgt    3  3700891.325 ± 1709171.912  ns/op
```

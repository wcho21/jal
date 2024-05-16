```
$ java -jar target/benchmarks.jar BinarySearchIntArrayBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                              (size)  Mode  Cnt   Score   Error  Units
BinarySearchIntArrayBenchmark.measure     128  avgt        5.047          ns/op
BinarySearchIntArrayBenchmark.measure     256  avgt        5.642          ns/op
BinarySearchIntArrayBenchmark.measure     512  avgt        6.239          ns/op
BinarySearchIntArrayBenchmark.measure    1024  avgt        6.832          ns/op
BinarySearchIntArrayBenchmark.measure    2048  avgt        7.427          ns/op
BinarySearchIntArrayBenchmark.measure    4096  avgt        8.027          ns/op
BinarySearchIntArrayBenchmark.measure    8192  avgt        8.631          ns/op
BinarySearchIntArrayBenchmark.measure   16384  avgt        9.225          ns/op
BinarySearchIntArrayBenchmark.measure   32768  avgt        9.820          ns/op
BinarySearchIntArrayBenchmark.measure   65536  avgt       10.422          ns/op
BinarySearchIntArrayBenchmark.measure  131072  avgt       11.031          ns/op
```

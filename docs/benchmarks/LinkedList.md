```
$ java -jar target/benchmarks.jar LinkedListBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                    (size)  Mode  Cnt     Score   Error  Units
LinkedListBenchmark.measurePrepend              128  avgt        270.977          ns/op
LinkedListBenchmark.measurePrepend              256  avgt        549.189          ns/op
LinkedListBenchmark.measurePrepend              512  avgt       1118.513          ns/op
LinkedListBenchmark.measurePrepend             1024  avgt       2315.228          ns/op
LinkedListBenchmark.measurePrepend             2048  avgt       4590.432          ns/op
LinkedListBenchmark.measurePrependAndRemove     128  avgt        601.452          ns/op
LinkedListBenchmark.measurePrependAndRemove     256  avgt       1395.408          ns/op
LinkedListBenchmark.measurePrependAndRemove     512  avgt       2436.951          ns/op
LinkedListBenchmark.measurePrependAndRemove    1024  avgt       4670.832          ns/op
LinkedListBenchmark.measurePrependAndRemove    2048  avgt       9369.192          ns/op
```

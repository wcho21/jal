```
$ java -jar target/benchmarks.jar LinkedListBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                    (size)  Mode  Cnt       Score   Error  Units
LinkedListBenchmark.measurePrepend              128  avgt          271.654          ns/op
LinkedListBenchmark.measurePrepend              256  avgt          549.275          ns/op
LinkedListBenchmark.measurePrepend              512  avgt         1116.604          ns/op
LinkedListBenchmark.measurePrepend             1024  avgt         2288.760          ns/op
LinkedListBenchmark.measurePrepend             2048  avgt         4571.190          ns/op
LinkedListBenchmark.measurePrepend             4096  avgt         8985.406          ns/op
LinkedListBenchmark.measurePrepend             8192  avgt        17868.746          ns/op
LinkedListBenchmark.measurePrepend            16384  avgt        35852.375          ns/op
LinkedListBenchmark.measurePrepend            32768  avgt        71866.007          ns/op
LinkedListBenchmark.measurePrepend            65536  avgt       144527.763          ns/op
LinkedListBenchmark.measurePrepend           131072  avgt       290323.052          ns/op
LinkedListBenchmark.measurePrependAndRemove     128  avgt          693.921          ns/op
LinkedListBenchmark.measurePrependAndRemove     256  avgt         1169.925          ns/op
LinkedListBenchmark.measurePrependAndRemove     512  avgt         2434.028          ns/op
LinkedListBenchmark.measurePrependAndRemove    1024  avgt         4672.151          ns/op
LinkedListBenchmark.measurePrependAndRemove    2048  avgt         9469.801          ns/op
LinkedListBenchmark.measurePrependAndRemove    4096  avgt        19211.594          ns/op
LinkedListBenchmark.measurePrependAndRemove    8192  avgt        38606.264          ns/op
LinkedListBenchmark.measurePrependAndRemove   16384  avgt        82153.622          ns/op
LinkedListBenchmark.measurePrependAndRemove   32768  avgt       170976.432          ns/op
LinkedListBenchmark.measurePrependAndRemove   65536  avgt       350461.804          ns/op
LinkedListBenchmark.measurePrependAndRemove  131072  avgt       705365.199          ns/op
```

```
$ java -jar target/benchmarks.jar LifoLinkedListBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                        (size)  Mode  Cnt       Score   Error  Units
LifoLinkedListBenchmark.measurePrepend              128  avgt          271.654          ns/op
LifoLinkedListBenchmark.measurePrepend              256  avgt          549.275          ns/op
LifoLinkedListBenchmark.measurePrepend              512  avgt         1116.604          ns/op
LifoLinkedListBenchmark.measurePrepend             1024  avgt         2288.760          ns/op
LifoLinkedListBenchmark.measurePrepend             2048  avgt         4571.190          ns/op
LifoLinkedListBenchmark.measurePrepend             4096  avgt         8985.406          ns/op
LifoLinkedListBenchmark.measurePrepend             8192  avgt        17868.746          ns/op
LifoLinkedListBenchmark.measurePrepend            16384  avgt        35852.375          ns/op
LifoLinkedListBenchmark.measurePrepend            32768  avgt        71866.007          ns/op
LifoLinkedListBenchmark.measurePrepend            65536  avgt       144527.763          ns/op
LifoLinkedListBenchmark.measurePrepend           131072  avgt       290323.052          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove     128  avgt          693.921          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove     256  avgt         1169.925          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove     512  avgt         2434.028          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove    1024  avgt         4672.151          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove    2048  avgt         9469.801          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove    4096  avgt        19211.594          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove    8192  avgt        38606.264          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove   16384  avgt        82153.622          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove   32768  avgt       170976.432          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove   65536  avgt       350461.804          ns/op
LifoLinkedListBenchmark.measurePrependAndRemove  131072  avgt       705365.199          ns/op
```

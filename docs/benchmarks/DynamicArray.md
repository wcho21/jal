```
$ java -jar target/benchmarks.jar DynamicArrayBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                     (size)  Mode  Cnt     Score   Error  Units
DynamicArrayBenchmark.measureAppend              128  avgt          309.755          ns/op
DynamicArrayBenchmark.measureAppend              256  avgt          619.542          ns/op
DynamicArrayBenchmark.measureAppend              512  avgt         1200.995          ns/op
DynamicArrayBenchmark.measureAppend             1024  avgt         2341.637          ns/op
DynamicArrayBenchmark.measureAppend             2048  avgt         4566.142          ns/op
DynamicArrayBenchmark.measureAppend             4096  avgt         9211.650          ns/op
DynamicArrayBenchmark.measureAppend             8192  avgt        18251.041          ns/op
DynamicArrayBenchmark.measureAppend            16384  avgt        36169.712          ns/op
DynamicArrayBenchmark.measureAppend            32768  avgt        71945.202          ns/op
DynamicArrayBenchmark.measureAppend            65536  avgt       144485.998          ns/op
DynamicArrayBenchmark.measureAppend           131072  avgt       522014.192          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     128  avgt          587.402          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     256  avgt         1157.823          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     512  avgt         2288.517          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    1024  avgt         4470.229          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    2048  avgt         8855.824          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    4096  avgt        17997.826          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    8192  avgt        35868.994          ns/op
DynamicArrayBenchmark.measureAppendAndRemove   16384  avgt        70658.440          ns/op
DynamicArrayBenchmark.measureAppendAndRemove   32768  avgt       139875.294          ns/op
DynamicArrayBenchmark.measureAppendAndRemove   65536  avgt       279283.107          ns/op
DynamicArrayBenchmark.measureAppendAndRemove  131072  avgt       739224.424          ns/op
```

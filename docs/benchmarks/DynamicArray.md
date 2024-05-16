```
$ java -jar target/benchmarks.jar DynamicArrayBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                     (size)  Mode  Cnt     Score   Error  Units
DynamicArrayBenchmark.measureAppend              128  avgt        309.757          ns/op
DynamicArrayBenchmark.measureAppend              256  avgt        622.256          ns/op
DynamicArrayBenchmark.measureAppend              512  avgt       1206.944          ns/op
DynamicArrayBenchmark.measureAppend             1024  avgt       2322.069          ns/op
DynamicArrayBenchmark.measureAppend             2048  avgt       4566.595          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     128  avgt        590.533          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     256  avgt       1173.396          ns/op
DynamicArrayBenchmark.measureAppendAndRemove     512  avgt       2290.011          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    1024  avgt       4478.524          ns/op
DynamicArrayBenchmark.measureAppendAndRemove    2048  avgt       8868.659          ns/op
```

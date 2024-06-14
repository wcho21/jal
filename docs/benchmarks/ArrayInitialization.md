```
$ java -jar target/benchmarks.jar "ArrayInitializationBenchmark" -f 1 -wi 0 -i 1 -prof gc
```

```
Benchmark                                                (size)  Mode  Cnt       Score   Error   Units
ArrayInitializationBenchmark.measure                        128  avgt           62.301           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate          128  avgt         8077.931          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm     128  avgt          528.002            B/op
ArrayInitializationBenchmark.measure:gc.count               128  avgt          322.000          counts
ArrayInitializationBenchmark.measure:gc.time                128  avgt          137.000              ms
ArrayInitializationBenchmark.measure                        256  avgt           84.916           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate          256  avgt        11674.345          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm     256  avgt         1040.003            B/op
ArrayInitializationBenchmark.measure:gc.count               256  avgt          405.000          counts
ArrayInitializationBenchmark.measure:gc.time                256  avgt          161.000              ms
ArrayInitializationBenchmark.measure                        512  avgt          108.066           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate          512  avgt        18205.283          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm     512  avgt         2064.004            B/op
ArrayInitializationBenchmark.measure:gc.count               512  avgt          514.000          counts
ArrayInitializationBenchmark.measure:gc.time                512  avgt          220.000              ms
ArrayInitializationBenchmark.measure                       1024  avgt          200.250           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate         1024  avgt        19572.985          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm    1024  avgt         4112.007            B/op
ArrayInitializationBenchmark.measure:gc.count              1024  avgt          482.000          counts
ArrayInitializationBenchmark.measure:gc.time               1024  avgt          207.000              ms
ArrayInitializationBenchmark.measure                       2048  avgt          226.689           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate         2048  avgt        34513.795          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm    2048  avgt         8208.008            B/op
ArrayInitializationBenchmark.measure:gc.count              2048  avgt          761.000          counts
ArrayInitializationBenchmark.measure:gc.time               2048  avgt          321.000              ms
ArrayInitializationBenchmark.measure                       4096  avgt          717.116           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate         4096  avgt        21799.148          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm    4096  avgt        16400.027            B/op
ArrayInitializationBenchmark.measure:gc.count              4096  avgt          578.000          counts
ArrayInitializationBenchmark.measure:gc.time               4096  avgt          233.000              ms
ArrayInitializationBenchmark.measure                       8192  avgt          660.051           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate         8192  avgt        47345.026          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm    8192  avgt        32784.025            B/op
ArrayInitializationBenchmark.measure:gc.count              8192  avgt          918.000          counts
ArrayInitializationBenchmark.measure:gc.time               8192  avgt          405.000              ms
ArrayInitializationBenchmark.measure                      16384  avgt          996.291           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate        16384  avgt        62717.164          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm   16384  avgt        65552.037            B/op
ArrayInitializationBenchmark.measure:gc.count             16384  avgt         1090.000          counts
ArrayInitializationBenchmark.measure:gc.time              16384  avgt          525.000              ms
ArrayInitializationBenchmark.measure                      32768  avgt         1726.621           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate        32768  avgt        72368.592          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm   32768  avgt       131088.064            B/op
ArrayInitializationBenchmark.measure:gc.count             32768  avgt         1233.000          counts
ArrayInitializationBenchmark.measure:gc.time              32768  avgt          632.000              ms
ArrayInitializationBenchmark.measure                      65536  avgt         3199.652           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate        65536  avgt        78099.744          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm   65536  avgt       262160.119            B/op
ArrayInitializationBenchmark.measure:gc.count             65536  avgt         1340.000          counts
ArrayInitializationBenchmark.measure:gc.time              65536  avgt          749.000              ms
ArrayInitializationBenchmark.measure                     131072  avgt        83511.870           ns/op
ArrayInitializationBenchmark.measure:gc.alloc.rate       131072  avgt         5971.678          MB/sec
ArrayInitializationBenchmark.measure:gc.alloc.rate.norm  131072  avgt       524307.190            B/op
ArrayInitializationBenchmark.measure:gc.count            131072  avgt          352.000          counts
ArrayInitializationBenchmark.measure:gc.time             131072  avgt         1271.000              ms
```

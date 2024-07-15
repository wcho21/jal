```
$ java -jar target/benchmarks.jar HeapPriorityQueueBenchmark -f 1 -wi 0 -i 1 -r 5
```

```
Benchmark                                     (size)  Mode  Cnt       Score   Error  Units
HeapPriorityQueueBenchmark.measureAdd            128  avgt            4.903          us/op
HeapPriorityQueueBenchmark.measureAdd            256  avgt           25.779          us/op
HeapPriorityQueueBenchmark.measureAdd            512  avgt           67.162          us/op
HeapPriorityQueueBenchmark.measureAdd           1024  avgt          150.690          us/op
HeapPriorityQueueBenchmark.measureAdd           2048  avgt          318.774          us/op
HeapPriorityQueueBenchmark.measureAdd           4096  avgt          706.567          us/op
HeapPriorityQueueBenchmark.measureAdd           8192  avgt         1552.314          us/op
HeapPriorityQueueBenchmark.measureAdd          16384  avgt         3421.817          us/op
HeapPriorityQueueBenchmark.measureAdd          32768  avgt         7584.630          us/op
HeapPriorityQueueBenchmark.measureAdd          65536  avgt        17629.830          us/op
HeapPriorityQueueBenchmark.measureAdd         131072  avgt        52156.152          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll     128  avgt           11.871          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll     256  avgt           59.539          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll     512  avgt          146.746          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll    1024  avgt          349.182          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll    2048  avgt          811.062          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll    4096  avgt         1803.634          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll    8192  avgt         3901.024          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll   16384  avgt         8702.189          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll   32768  avgt        19850.160          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll   65536  avgt        43868.287          us/op
HeapPriorityQueueBenchmark.measureAddAndPoll  131072  avgt       126896.377          us/op
```

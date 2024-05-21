```
$ java -jar target/benchmarks.jar InsertionAndTopDownMergeForSmallBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                                                                 (size)  Mode  Cnt     Score   Error  Units
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed          2  avgt          6.094          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed          4  avgt         17.611          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed          8  avgt         64.544          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed         16  avgt        218.199          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed         32  avgt        872.871          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForReversed         64  avgt       3487.888          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted            2  avgt          1.673          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted            4  avgt          2.358          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted            8  avgt          3.634          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted           16  avgt          6.189          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted           32  avgt         11.199          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureInsertionForSorted           64  avgt         21.223          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed       2  avgt         23.673          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed       4  avgt        126.999          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed       8  avgt        201.281          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed      16  avgt        300.356          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed      32  avgt        671.956          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForReversed      64  avgt       1549.582          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted         2  avgt         19.217          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted         4  avgt         53.891          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted         8  avgt        133.644          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted        16  avgt        300.684          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted        32  avgt        688.747          ns/op
InsertionAndTopDownMergeForSmallBenchmark.measureTopDownMergeForSorted        64  avgt       1516.245          ns/op
```

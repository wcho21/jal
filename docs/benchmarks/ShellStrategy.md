```
$ java -jar target/benchmarks.jar ShellStrategyBenchmark -f 1 -wi 0 -i 1
```

```
Benchmark                               (size)  Mode  Cnt       Score   Error  Units
ShellStrategyBenchmark.measureBest         128  avgt          223.236          ns/op
ShellStrategyBenchmark.measureBest         256  avgt          521.503          ns/op
ShellStrategyBenchmark.measureBest         512  avgt         1145.996          ns/op
ShellStrategyBenchmark.measureBest        1024  avgt         2547.677          ns/op
ShellStrategyBenchmark.measureBest        2048  avgt         5694.136          ns/op
ShellStrategyBenchmark.measureBest        4096  avgt        12740.414          ns/op
ShellStrategyBenchmark.measureBest        8192  avgt        32102.843          ns/op
ShellStrategyBenchmark.measureBest       16384  avgt        85733.542          ns/op
ShellStrategyBenchmark.measureBest       32768  avgt       152201.963          ns/op
ShellStrategyBenchmark.measureBest       65536  avgt       359099.158          ns/op
ShellStrategyBenchmark.measureBest      131072  avgt       860194.811          ns/op
ShellStrategyBenchmark.measureReversed     128  avgt            1.276          us/op
ShellStrategyBenchmark.measureReversed     256  avgt            3.070          us/op
ShellStrategyBenchmark.measureReversed     512  avgt            6.266          us/op
ShellStrategyBenchmark.measureReversed    1024  avgt           14.869          us/op
ShellStrategyBenchmark.measureReversed    2048  avgt           34.414          us/op
ShellStrategyBenchmark.measureReversed    4096  avgt           81.205          us/op
ShellStrategyBenchmark.measureReversed    8192  avgt          147.674          us/op
ShellStrategyBenchmark.measureReversed   16384  avgt          414.177          us/op
ShellStrategyBenchmark.measureReversed   32768  avgt          929.291          us/op
ShellStrategyBenchmark.measureReversed   65536  avgt         2338.755          us/op
ShellStrategyBenchmark.measureReversed  131072  avgt         5172.701          us/op
```

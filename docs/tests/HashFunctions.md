```
$ java -jar target/jal-1.0.0-SNAPSHOT.jar hashdiff
```

```
Hash function: modular hashing
  Dataset: first half
    1   1   1   1   1   1   1   1
    1   1   1   1   1   1   1   1
    0   0   0   0   0   0   0   0
    0   0   0   0   0   0   0   0
  Dataset: multiplies of 2
    8   0   8   0   8   0   8   0
    8   0   8   0   8   0   8   0
    8   0   8   0   8   0   8   0
    8   0   8   0   8   0   8   0
  Dataset: multiplies of 4
   16   0   0   0  16   0   0   0
   16   0   0   0  16   0   0   0
   16   0   0   0  16   0   0   0
   16   0   0   0  16   0   0   0
  Dataset: multiplies of size
  128   0   0   0   0   0   0   0
    0   0   0   0   0   0   0   0
    0   0   0   0   0   0   0   0
    0   0   0   0   0   0   0   0
  Dataset: multiplies of golden ratio
    5   5   3   6   3   5   4   4
    5   4   4   5   4   4   5   2
    5   4   3   4   3   4   4   3
    5   3   4   4   3   4   4   3
Hash function: fibonacci hashing (multiplication)
  Dataset: first half
    1   1   1   0   0   1   0   1
    1   0   1   0   0   1   0   1
    0   1   0   1   1   0   1   0
    0   1   0   1   0   0   1   0
  Dataset: multiplies of 2
    5   3   5   4   4   3   4   5
    4   3   4   5   3   4   3   6
    3   4   4   5   3   4   4   5
    3   4   4   4   4   3   5   4
  Dataset: multiplies of 4
    5   3   4   3   4   5   4   5
    3   4   3   4   3   5   4   6
    3   4   3   4   3   5   5   4
    4   3   4   3   4   4   6   4
  Dataset: multiplies of size
    2   5   5   3   4   5   5   0
    5   5   4   3   5   5   1   5
    5   4   2   5   5   2   5   5
    5   2   5   5   2   4   5   5
  Dataset: multiplies of golden ratio
    1   0   0   0   0   0   0   0
    0   0   0   0   4   7   6   7
    6   7   6   7   6   7   7   6
    6   7   6   7   6   6   6   7
Hash function: fibonacci hashing (shift)
  Dataset: first half
    1   1   1   0   0   1   0   1
    1   0   1   0   0   1   0   1
    0   1   0   1   1   0   1   0
    0   1   0   1   0   0   1   0
  Dataset: multiplies of 2
    5   3   5   4   4   3   4   5
    4   3   4   5   3   4   3   6
    3   4   4   5   3   4   4   5
    3   4   4   4   4   3   5   4
  Dataset: multiplies of 4
    5   3   4   3   4   5   4   5
    3   4   3   4   3   5   4   6
    3   4   3   4   3   5   5   4
    4   3   4   3   4   4   6   4
  Dataset: multiplies of size
    2   5   5   3   4   5   5   0
    5   5   4   3   5   5   1   5
    5   4   2   5   5   2   5   5
    5   2   5   5   2   4   5   5
  Dataset: multiplies of golden ratio
    1   0   0   0   0   0   0   0
    0   0   0   0   4   7   6   7
    6   7   6   7   6   7   7   6
    6   7   6   7   6   6   6   7
```

# JAL

자바 알고리즘 라이브러리.

## Catalog

- [알고리즘은 무엇을 얼마나 빨리 풀 수 있을까](https://drop.rooi.dev/posts/2024/05/07/01)

  - 유클리드 알고리즘: [Euclid.java](./src/main/java/org/jal/math/Euclid.java)

- [두 가지 방법으로 만드는 스택](https://drop.rooi.dev/posts/2024/05/09/01)

  - 링크드 리스트: [LinkedList.java](./src/main/java/org/jal/collections/list/LinkedList.java)

  - 링크드 리스트 스택: [ListStack.java](./src/main/java/org/jal/collections/stack/ListStack.java)

  - 다이나믹 배열: [DynamicArray.java](./src/main/java/org/jal/collections/array/DynamicArray.java)

  - 배열 스택: [ArrayStack.java](./src/main/java/org/jal/collections/stack/ArrayStack.java)

  - 피보나치 수: [Fibonacci.java](./src/main/java/org/jal/math/Fibonacci.java)

- [순서로 해결하는 두 가지 문제](https://drop.rooi.dev/posts/2024/05/16/01)

  - 바이너리 서치 (`int`): [BinarySearchIntArray.java](./src/main/java/org/jal/search/BinarySearchIntArray.java)

  - 바이너리 서치 (제네릭): [BinarySearchArray.java](./src/main/java/org/jal/search/BinarySearchArray.java)

  - 컴패러터 유틸: [Comparators.java](./src/main/java/org/jal/util/Comparators.java)

  - 인서션 소트: [InsertionStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/InsertionStrategy.java)

  - 스왑 유틸: [Comparators.java](./src/main/java/org/jal/util/Comparators.java)

  - 셸 소트: [ShellStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/ShellStrategy.java)

- [최악의 경우에 최적으로 비교하는 소트](https://drop.rooi.dev/posts/2024/05/21/01)

  - 탑 다운 머지 소트: [TopDownMergeStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/TopDownMergeStrategy.java)

  - 인서션 소트를 더한 탑 다운 머지 소트: [TopDownInsMergeStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/TopDownInsMergeStrategy.java)

  - 바텀 업 머지 소트: [BottomUpMergeStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/BottomUpMergeStrategy.java)

  - 인버전 카운트: [Inversion.java](./src/main/java/org/jal/sorting/util/Inversion.java)

- [운에 맡기는 파티셔닝](https://drop.rooi.dev/posts/2024/06/15/01)

  - 랜더마이즈드 파티셔닝: [RandTwoWayStrategy.java](./src/main/java/org/jal/partition/RandTwoWayStrategy.java)

  - 퀵셀렉트: [QuickSelectArray.java](./src/main/java/org/jal/search/QuickSelectArray.java)

  - 퀵소트: [QuickStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/QuickStrategy.java)

  - 랜더마이즈드 쓰리웨이 파티셔닝: [RandThreeWayStrategy.java](./src/main/java/org/jal/partition/RandThreeWayStrategy.java)

  - 쓰리웨이 퀵소트: [ThreeWayQuickStrategy.java](./src/main/java/org/jal/sorting/strategy/arrays/ThreeWayQuickStrategy.java)

- [링크드 리스트로 만드는 딕셔너리](https://drop.rooi.dev/posts/2024/06/29/01/)

  - 서큘러 링크드 리스트: [CircularLinkedList.java](./src/main/java/org/jal/collections/list/CircularLinkedList.java)

  - 연관 리스트: [AssocList.java](./src/main/java/org/jal/collections/dictionary/AssocList.java)

  - 고정 크기 체이닝 해시 테이블: [FixedChainingTable.java](./src/main/java/org/jal/collections/dictionary/FixedChainingTable.java)

  - 리사이징 체이닝 해시 테이블: [ChainingTable.java](./src/main/java/org/jal/collections/dictionary/ChainingTable.java)

  - 체이닝 해시 셋: [ChainingSet.java](./src/main/java/org/jal/collections/set/ChainingSet.java)

  - 체이닝 해시 맵: [ChainingMap.java](./src/main/java/org/jal/collections/map/ChainingMap.java)

- [배열로 만드는 딕셔너리](https://drop.rooi.dev/posts/2024/07/04/01/)

  - 리니어 프로빙 해시 테이블: [LinearProbingTable.java](./src/main/java/org/jal/collections/dictionary/LinearProbingTable.java)

  - 더블 해싱 해시 테이블: [DoubleHashTable.java](./src/main/java/org/jal/collections/dictionary/DoubleHashingTable.java)

  - 피보나치 해싱: [Hashes.java](./src/main/java/org/jal/util/Hashes.java)

  - 리니어 프로빙 셋: [LinearProbingSet.java](./src/main/java/org/jal/collections/set/LinearProbingSet.java)

  - 리니어 프로빙 맵: [LinearProbingMap.java](./src/main/java/org/jal/collections/map/LinearProbingMap.java)

  - 더블 해싱 셋: [DoubleHashingSet.java](./src/main/java/org/jal/collections/set/DoubleHashingSet.java)

  - 더블 해싱 맵: [DoubleHashingMap.java](./src/main/java/org/jal/collections/map/DoubleHashingMap.java)

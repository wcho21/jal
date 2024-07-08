package org.jal.collections.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class HeapifierTest {
  private static <T extends Comparable<? super T>> Heapifier<T> createArrayHeapifier(T[] arr) {
    return new Heapifier<>(i -> arr[i], (i, value) -> arr[i] = value, Comparator.comparing(v -> v));
  }

  @DisplayName("siftUp()")
  @Nested
  class SiftUp {
    @DisplayName("siftUp()")
    @ParameterizedTest(name = "should sift up at {1} with root {2}")
    @MethodSource("provider")
    public void testSiftUpWithRoot(Integer[] arr, int index, int root, int expected) {
      Heapifier<Integer> heapifier = createArrayHeapifier(arr);
      heapifier.siftUp(index, root);

      assertEquals(expected, arr[root]);
    }

    static Stream<Arguments> provider() {
      Integer[] arr     = { 9, 9, 9, 1, 2, 3, 4, 5, 6, 7 }; // 1 is the root

      Integer[] roots   = { 3, 3, 3, 3, 3, 3 };
      Integer[] indices = { 4, 5, 6, 7, 8, 9 };

      return Stream.iterate(0, i->i+1).limit(indices.length)
        .map(i -> arguments(arr.clone(), indices[i], roots[i], arr[indices[i]]));
    }
  }

  @DisplayName("siftDown()")
  @Nested
  class siftDown {
    @DisplayName("siftDown()")
    @ParameterizedTest(name = "should sift down at {1} with root {2}")
    @MethodSource("provider")
    public void testSiftDown(Integer[] arr, int index, int root, int last, int expected, int lastLevelBegin, int lastLevelEnd) {
      Heapifier<Integer> heapifier = createArrayHeapifier(arr);
      heapifier.siftDown(index, root, last);

      assertTrue(IntStream.range(lastLevelBegin, lastLevelEnd).anyMatch(i -> arr[i] == expected));
    }

    static Stream<Arguments> provider() {
      Integer[] arr     = { 9, 9, 9, 1, 2, 3, 4, 5, 6, 7 }; // 1 is the root

      Integer[] indices        = { 4, 5, 6, 7, 8, 9, 4, 4, 4, 4, 4 };
      Integer[] roots          = { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
      Integer[] lasts          = { 9, 9, 9, 9, 9, 9, 8, 7, 6, 5, 4 };
      Integer[] lastLevelBegin = { 6, 6, 6, 6, 6, 6, 6, 6, 6, 4, 4 };

      return Stream.iterate(0, i->i+1).limit(indices.length)
        .map(i -> arguments(arr.clone(), indices[i], roots[i], lasts[i], arr[indices[i]], lastLevelBegin[i], lasts[i]+1));
    }
  }
}

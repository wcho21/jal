package org.jal.collections.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ArrayTreeTest {
  @DisplayName("getParent()")
  @Nested
  class GetParent {
    @DisplayName("getParent()")
    @ParameterizedTest(name = "should get the parent of child at {0} with root {1}")
    @MethodSource("provider")
    public void testGetParent(int index, int root, int expected) {
      int parent = ArrayTree.getParent(index, root);

      assertEquals(expected, parent);
    }

    static Stream<Arguments> provider() {
      Integer[] indices = { 1, 2, 3, 4, 5, 6, 101, 102, 103, 104, 105, 106 };
      Integer[] root    = { 0, 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 100 };
      Integer[] parents = { 0, 0, 1, 1, 2, 2, 100, 100, 101, 101, 102, 102 };

      return Stream.iterate(0, i->i+1).limit(indices.length)
        .map(i -> arguments(indices[i], root[i], parents[i]));
    }
  }

  @DisplayName("getLeftChild()")
  @Nested
  class GetLeftChild {
    @DisplayName("getLeftChild()")
    @ParameterizedTest(name = "should get the left child of parent at {0} with root {1}")
    @MethodSource("provider")
    public void testGetLeftChild(int index, int root, int expected) {
      int child = ArrayTree.getLeftChild(index, root);

      assertEquals(expected, child);
    }

    static Stream<Arguments> provider() {
      Integer[] indices = { 0, 1, 2, 3, 4,  5,  6, 100, 101, 102, 103, 104, 105, 106 };
      Integer[] root    = { 0, 0, 0, 0, 0,  0,  0, 100, 100, 100, 100, 100, 100, 100 };
      Integer[] parents = { 1, 3, 5, 7, 9, 11, 13, 101, 103, 105, 107, 109, 111, 113 };

      return Stream.iterate(0, i->i+1).limit(indices.length)
        .map(i -> arguments(indices[i], root[i], parents[i]));
    }
  }

  @DisplayName("getRightChild()")
  @Nested
  class GetRightChild {
    @DisplayName("getRightChild()")
    @ParameterizedTest(name = "should get the right child of parent at {0} with root {1}")
    @MethodSource("provider")
    public void testGetRightChild(int index, int root, int expected) {
      int child = ArrayTree.getRightChild(index, root);

      assertEquals(expected, child);
    }

    static Stream<Arguments> provider() {
      Integer[] indices = { 0, 1, 2, 3,  4,  5,  6, 100, 101, 102, 103, 104, 105, 106 };
      Integer[] root    = { 0, 0, 0, 0,  0,  0,  0, 100, 100, 100, 100, 100, 100, 100 };
      Integer[] parents = { 2, 4, 6, 8, 10, 12, 14, 102, 104, 106, 108, 110, 112, 114 };

      return Stream.iterate(0, i->i+1).limit(indices.length)
        .map(i -> arguments(indices[i], root[i], parents[i]));
    }
  }

  @DisplayName("getLastInternalNode()")
  @Nested
  class GetLastInternalNode {
    @DisplayName("getLastInternalNode()")
    @ParameterizedTest(name = "should get the last internal node for last leaf at {0} and root {1}")
    @MethodSource("provider")
    public void testGetLastInternalNode(int lastLeafNode, int root, int expected) {
      int child = ArrayTree.getLastInternalNode(lastLeafNode, root);

      assertEquals(expected, child);
    }

    static Stream<Arguments> provider() {
      Integer[] lastLeafNodeIndices = { 1, 2, 3, 4, 5, 6, 101, 102, 103, 104, 105, 105 };
      Integer[] roots               = { 0, 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 100 };
      Integer[] expected            = { 0, 0, 1, 1, 2, 2, 100, 100, 101, 101, 102, 102 };

      return Stream.iterate(0, i->i+1).limit(roots.length)
        .map(i -> arguments(lastLeafNodeIndices[i], roots[i], expected[i]));
    }
  }
}

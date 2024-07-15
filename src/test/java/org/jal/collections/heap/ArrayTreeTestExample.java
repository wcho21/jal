package org.jal.collections.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayTreeTestExample {
  @Test
  public void testGetParentAndGetChild() {
    int root = 42;
    int leftChild = ArrayTree.getLeftChild(root, root);
    int rightChild = ArrayTree.getRightChild(root, root);

    assertEquals(root, ArrayTree.getParent(leftChild, root));
    assertEquals(root, ArrayTree.getParent(rightChild, root));
  }
}

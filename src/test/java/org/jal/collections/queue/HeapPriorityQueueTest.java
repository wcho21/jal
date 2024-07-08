package org.jal.collections.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class HeapPriorityQueueTest {
  @Test
  public void testPoll() {
    HeapPriorityQueue<Integer> q = new HeapPriorityQueue<>(Comparator.comparing(v -> v));

    q.add(3);
    q.add(1);
    q.add(2);

    assertEquals(3, q.poll());
    assertEquals(2, q.poll());
    assertEquals(1, q.poll());
  }
}

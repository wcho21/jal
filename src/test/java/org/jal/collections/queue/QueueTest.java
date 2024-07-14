package org.jal.collections.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

abstract class CommonTest {
  abstract protected Queue<Integer> createQueue();

  @DisplayName("getSize() should get the size")
  @Test
  public void testGetSize() {
    Queue<Integer> q = this.createQueue();
    for (int n : new int[] { 1, 2, 3 }) {
      q.add(n);
    }

    assertEquals(3, q.getSize());
  }

  @DisplayName("isEmpty() should be true if empty")
  @Test
  public void testIsEmptyTrue() {
    Queue<Integer> q = this.createQueue();

    assertEquals(true, q.isEmpty());
  }

  @DisplayName("isEmpty() should be false if not empty")
  @Test
  public void testIsEmptyFalse() {
    Queue<Integer> q = this.createQueue();

    q.add(1);

    assertEquals(false, q.isEmpty());
  }
}

public class QueueTest {
  private static Named<List<Integer>> INC_NUMS  = named("increasing numbers", Arrays.asList(1, 2, 3, 4, 5, 6, 7));
  private static Named<List<Integer>> DEC_NUMS  = named("decreasing numbers", Arrays.asList(7, 6, 5, 4, 3, 2, 1));
  private static Named<List<Integer>> SHUF_NUMS = named("shuffled numbers",   Arrays.asList(1, 7, 2, 6, 3, 5, 4));

  @DisplayName("HeapPriorityQueue")
  @Nested
  class HeapPriorityQueueTest extends CommonTest {
    @Override
    protected Queue<Integer> createQueue() {
      return new HeapPriorityQueue<>(Comparator.comparing(v -> v));
    }

    @DisplayName("poll() should pop out elements in a specific order")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("pollProvider")
    public void testPoll(Iterable<Integer> toAdd, Iterable<Integer> expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      Iterable<Integer> polled = Stream.generate(() -> q.poll()).limit(q.getSize()).toList();
      assertIterableEquals(expected, polled);
    }

    static Stream<Arguments> pollProvider() {
      List<Integer> largestFirst = Arrays.asList(7, 6, 5, 4, 3, 2, 1);

      return Stream.of(
        arguments(INC_NUMS,  largestFirst),
        arguments(DEC_NUMS,  largestFirst),
        arguments(SHUF_NUMS, largestFirst)
      );
    }

    @DisplayName("peek() should get the next value")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("peekProvider")
    public void testPeek(Iterable<Integer> toAdd, int expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      assertEquals(expected, q.peek());
    }

    static Stream<Arguments> peekProvider() {
      int largest = 7;

      return Stream.of(
        arguments(INC_NUMS,  largest),
        arguments(DEC_NUMS,  largest),
        arguments(SHUF_NUMS, largest)
      );
    }
  }

  @DisplayName("LifoQueue")
  @Nested
  class LifoQueueTest extends CommonTest {
    @Override
    protected Queue<Integer> createQueue() {
      return new LifoQueue<>();
    }

    @DisplayName("poll() should pop out elements in a specific order")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("pollProvider")
    public void testPoll(Iterable<Integer> toAdd, Iterable<Integer> expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      Iterable<Integer> polled = Stream.generate(() -> q.poll()).limit(q.getSize()).toList();
      assertIterableEquals(expected, polled);
    }

    static Stream<Arguments> pollProvider() {
      return Stream.of(
        arguments(INC_NUMS,  Arrays.asList(7, 6, 5, 4, 3, 2, 1)),
        arguments(DEC_NUMS,  Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
        arguments(SHUF_NUMS, Arrays.asList(4, 5, 3, 6, 2, 7, 1))
      );
    }

    @DisplayName("peek() should get the next value")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("peekProvider")
    public void testPeek(Iterable<Integer> toAdd, int expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      assertEquals(expected, q.peek());
    }

    static Stream<Arguments> peekProvider() {
      return Stream.of(
        arguments(INC_NUMS, 7),
        arguments(DEC_NUMS, 1),
        arguments(SHUF_NUMS, 4)
      );
    }
  }

  @DisplayName("FifoQueue")
  @Nested
  class FifoQueueTest extends CommonTest {
    @Override
    protected Queue<Integer> createQueue() {
      return new FifoQueue<>();
    }

    @DisplayName("poll() should pop out elements in a specific order")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("pollProvider")
    public void testPoll(Iterable<Integer> toAdd, Iterable<Integer> expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      Iterable<Integer> polled = Stream.generate(() -> q.poll()).limit(q.getSize()).toList();
      assertIterableEquals(expected, polled);
    }

    static Stream<Arguments> pollProvider() {
      return Stream.of(
        arguments(INC_NUMS,  Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
        arguments(DEC_NUMS,  Arrays.asList(7, 6, 5, 4, 3, 2, 1)),
        arguments(SHUF_NUMS, Arrays.asList(1, 7, 2, 6, 3, 5, 4))
      );
    }

    @DisplayName("peek() should get the next value")
    @ParameterizedTest(name = "for {0}")
    @MethodSource("peekProvider")
    public void testPeek(Iterable<Integer> toAdd, int expected) {
      Queue<Integer> q = this.createQueue();
      for (Integer n : toAdd) {
        q.add(n);
      }

      assertEquals(expected, q.peek());
    }

    static Stream<Arguments> peekProvider() {
      return Stream.of(
        arguments(INC_NUMS, 1),
        arguments(DEC_NUMS, 7),
        arguments(SHUF_NUMS, 1)
      );
    }
  }
}

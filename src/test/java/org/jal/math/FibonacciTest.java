package org.jal.math;

import static org.jal.math.Fibonacci.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.jal.collections.stack.ArrayStack;
import org.jal.collections.stack.ListStack;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciTest {
  @Nested
  class WithListStack {
    @ParameterizedTest
    @CsvSource({"-1,0","0,0","1,1","2,1","3,2","4,3","5,5","6,8","7,13","8,21"})
    public void testFibonacci(int n, int expected) {
      int fib = get(n, new ListStack<Integer>());

      assertEquals(expected, fib);
    }
  }

  @Nested
  class WithArrayStack {
    @ParameterizedTest
    @CsvSource({"-1,0","0,0","1,1","2,1","3,2","4,3","5,5","6,8","7,13","8,21"})
    public void testFibonacci(int n, int expected) {
      int fib = get(n, new ArrayStack<Integer>());

      assertEquals(expected, fib);
    }
  }
}

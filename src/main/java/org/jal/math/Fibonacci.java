package org.jal.math;

import org.jal.collections.Stack;

public class Fibonacci {
  public static int get(int n, Stack<Integer> stack) {
    if (n <= 0) {
      return 0;
    }

    stack.push(n);
    int fib = 0;

    while (!stack.isEmpty()) {
      int m = stack.pop();

      if (m >= 3) {
        stack.push(m-2);
        stack.push(m-1);
      } else {
        fib++;
      }
    }

    return fib;
  }
}

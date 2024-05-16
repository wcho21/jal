package org.jal.math;

import org.jal.collections.Stack;

public class Fibonacci {
  public static int getWithStack(int n, Stack<Integer> stack) {
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

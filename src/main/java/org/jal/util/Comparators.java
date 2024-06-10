package org.jal.util;

import java.util.Comparator;

public class Comparators {
  public static <T> boolean isLessThan(T source, T target, Comparator<T> comparator) {
    return comparator.compare(source, target) < 0;
  }

  public static <T> boolean isLessThanOrEqualTo(T source, T target, Comparator<T> comparator) {
    return comparator.compare(source, target) <= 0;
  }

  public static <T> boolean isEqualTo(T source, T target, Comparator<T> comparator) {
    return comparator.compare(source, target) == 0;
  }

  public static <T> boolean isGreaterThanOrEqualTo(T source, T target, Comparator<T> comparator) {
    return comparator.compare(source, target) >= 0;
  }

  public static <T> boolean isGreaterThan(T source, T target, Comparator<T> comparator) {
    return comparator.compare(source, target) > 0;
  }
}

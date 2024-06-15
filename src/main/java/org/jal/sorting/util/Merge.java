package org.jal.sorting.util;

import static org.jal.util.Comparators.isLessThanOrEqualTo;

import java.util.Comparator;

public class Merge {
  public static <T> boolean isLessOrEqualLowerBegin(T[] arr, int lowerBegin, int lowerEnd, int upperBegin, int upperEnd, Comparator<T> comp) {
    assert lowerEnd >= lowerBegin;
    assert upperBegin >= lowerEnd;
    assert upperEnd >= upperBegin;
    assert upperEnd > lowerBegin;

    if (lowerBegin == lowerEnd) {
      return false;
    }
    if (upperBegin == upperEnd) {
      return true;
    }

    return isLessThanOrEqualTo(arr[lowerBegin], arr[upperBegin], comp);
  }
}

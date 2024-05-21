package org.jal.util.sorting;

import static org.jal.util.Comparators.isLessThan;
import static org.jal.util.Comparators.isLessThanOrEqualTo;
import java.util.Comparator;

public class Arrays {
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

  public static <T extends Comparable<? super T>> int countInversions(T[] arr) {
    T[] aux = arr.clone();
    int end = arr.length;
    int numInv = 0;

    for (int mergeSize = 1; mergeSize < end; mergeSize *= 2) {
      for (int mergeBegin = 0; mergeBegin < end; mergeBegin += 2*mergeSize) {
        int mergeMid = mergeBegin + mergeSize;
        if (mergeMid >= end) {
          break;
        }

        int mergeEnd = Math.min(mergeMid + mergeSize, end);

        numInv += mergeAndCountInversions(arr, aux, mergeBegin, mergeMid, mergeEnd);
      }
    }

    return numInv;
  }

  private static <T extends Comparable<? super T>> int mergeAndCountInversions(T[] arr, T[] aux, int begin, int mid, int end) {
    int numInv = 0;
    Comparator<T> comp = Comparator.comparing(v -> v);

    // lower <- [lowerBegin, lowerEnd)
    int lowerBegin = begin;
    int lowerEnd = mid;
    // upper <- [upperBegin, upperEnd)
    int upperBegin = mid;
    int upperEnd = end;

    for (int i = begin; i < end; ++i) {
      if (isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, comp)) {
        aux[i] = arr[lowerBegin++];
      } else {
        aux[i] = arr[upperBegin++];
        numInv += lowerEnd - lowerBegin;
      }
    }

    return numInv;
  }
}

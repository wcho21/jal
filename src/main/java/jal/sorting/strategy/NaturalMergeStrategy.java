package org.jal.sorting.strategy;

import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class NaturalMergeStrategy<T> extends AbstractMergeStrategy<T> {
  @Override
  protected void mergeSortArray(T[] arr, int begin, int end, Comparator<T> comparator) {
    while (true) {
      int runBegin = this.mergeAndGetNextBegin(arr, begin, end, comparator);
      if (runBegin == end) {
        break;
      }

      while (true) {
        runBegin = this.mergeAndGetNextBegin(arr, runBegin, end, comparator);
        if (runBegin == end) {
          break;
        }
      }
    }
  }

  private int mergeAndGetNextBegin(T[] arr, int begin, int end, Comparator<T> comparator) {
    int lowerRunEnd = this.getRunEnd(arr, begin, end, comparator);
    if (lowerRunEnd == end) {
      return end;
    }

    int upperRunEnd = this.getRunEnd(arr, lowerRunEnd, end, comparator);
    this.mergeArrays(arr, begin, lowerRunEnd, upperRunEnd, comparator);

    return upperRunEnd; // return next begin
  }

  private int getRunEnd(T[] arr, int begin, int end, Comparator<T> comparator) {
    for (int i = begin+1; i < end; ++i) {
      if (isGreaterThan(arr[i-1], arr[i], comparator)) {
        return i;
      }
    }

    return end;
  }
}

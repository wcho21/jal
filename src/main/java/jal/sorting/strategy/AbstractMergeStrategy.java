package org.jal.sorting.strategy;

import static org.jal.sorting.util.Merge.isLessOrEqualLowerBegin;
import java.util.Comparator;

public abstract class AbstractMergeStrategy<T> implements SortStrategy<T> {
  private T[] aux;

  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    this.aux = arr.clone();

    this.mergeSortArray(arr, begin, end, comp);

    this.aux = null;

    return arr;
  }

  abstract protected void mergeSortArray(T[] arr, int begin, int end, Comparator<T> comp);

  protected void mergeArrays(T[] arr, int begin, int mid, int end, Comparator<T> comp) {
    // lower <- [lowerBegin, lowerEnd)
    int lowerBegin = begin;
    int lowerEnd = mid;
    // upper <- [upperBegin, upperEnd)
    int upperBegin = mid;
    int upperEnd = end;

    for (int i = begin; i < end; ++i) {
      if (isLessOrEqualLowerBegin(arr, lowerBegin, lowerEnd, upperBegin, upperEnd, comp)) {
        this.aux[i] = arr[lowerBegin++];
      } else {
        this.aux[i] = arr[upperBegin++];
      }
    }

    System.arraycopy(this.aux, begin, arr, begin, end-begin);
  }
}

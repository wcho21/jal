package org.jal.sorting.strategy.arrays;

import java.util.Comparator;

public class BottomUpMergeStrategy<T> extends AbstractMergeStrategy<T> {
  @Override
  protected void mergeSortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    int size = end - begin;

    for (int mergeSize = 1; mergeSize < size; mergeSize *= 2) {
      for (int mergeBegin = begin; mergeBegin < end; mergeBegin += 2*mergeSize) {
        int mergeMid = mergeBegin + mergeSize;
        if (mergeMid >= end) {
          break;
        }

        int mergeEnd = Math.min(mergeMid + mergeSize, end);

        this.mergeArrays(arr, mergeBegin, mergeMid, mergeEnd, comp);
      }
    }
  }
}

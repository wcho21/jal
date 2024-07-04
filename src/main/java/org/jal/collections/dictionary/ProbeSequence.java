package org.jal.collections.dictionary;

import java.util.Iterator;

class ProbeSequence<K> implements Iterable<Integer> {
  private int length;
  private int begin;
  private int step;

  public ProbeSequence(int begin, int step, int length) {
    this.begin = begin;
    this.length = length;
    this.step = step;
  }

  class ProbeSeqIterator implements Iterator<Integer> {
    private int i = 0;

    public ProbeSeqIterator() {
      this.i = 0;
    }

    public boolean hasNext() {
      return i < length;
    }

    public Integer next() {
      int next = (begin + i*step) % length;
      i++;

      return next;
    }
  }

  public Iterator<Integer> iterator() {
    return new ProbeSeqIterator();
  }
}

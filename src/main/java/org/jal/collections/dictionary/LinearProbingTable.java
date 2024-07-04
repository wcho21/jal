package org.jal.collections.dictionary;

import static org.jal.util.Hashes.multShiftHash;

import java.util.function.Function;

public class LinearProbingTable<K, V> extends AbstractOpenAddressingTable<K, V> {
  public LinearProbingTable(Function<V, K> getKey) {
    super(getKey);
  }

  @Override
  protected Iterable<Integer> getProbeSequence(K key) {
    int n = key.hashCode();

    int length = this.slots.length;
    int begin = multShiftHash(n, length);
    int step = 1;

    return new ProbeSequence<>(begin, step, length);
  }
}

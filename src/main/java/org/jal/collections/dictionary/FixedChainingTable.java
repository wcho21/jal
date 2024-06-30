package org.jal.collections.dictionary;

import java.util.function.Function;

public class FixedChainingTable<K, V> extends AbstractChainingTable<K, V> {
  public FixedChainingTable(Function<V, K> getKey) {
    super(getKey);
  }

  @Override
  protected int getHash(K key) {
    return key.hashCode() % this.slots.length;
  }
}

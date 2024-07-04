package org.jal.collections.set;

import org.jal.collections.dictionary.Dictionary;
import org.jal.collections.dictionary.DoubleHashingTable;

public class DoubleHashingSet<K> implements Set<K> {
  private Dictionary<K, K> dict;

  public DoubleHashingSet() {
    this.dict = new DoubleHashingTable<>(v -> v);
  }

  public void set(K key) {
    this.dict.set(key);
  }

  public boolean has(K key) {
    return this.dict.get(key) != null;
  }

  public void remove(K key) {
    this.dict.remove(key);
  }

  public int getSize() {
    return this.dict.getSize();
  }

  public Iterable<K> getKeys() {
    return this.dict.getValues();
  }
}

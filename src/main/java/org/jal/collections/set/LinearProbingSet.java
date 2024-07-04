package org.jal.collections.set;

import org.jal.collections.dictionary.Dictionary;
import org.jal.collections.dictionary.LinearProbingTable;

public class LinearProbingSet<K> implements Set<K> {
  private Dictionary<K, K> dict;

  public LinearProbingSet() {
    this.dict = new LinearProbingTable<>(v -> v);
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

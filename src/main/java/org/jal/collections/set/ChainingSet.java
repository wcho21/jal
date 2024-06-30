package org.jal.collections.set;

import org.jal.collections.dictionary.ChainingTable;
import org.jal.collections.dictionary.Dictionary;

public class ChainingSet<K> implements Set<K> {
  private Dictionary<K, K> dict;

  public ChainingSet() {
    this.dict = new ChainingTable<>(v -> v);
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

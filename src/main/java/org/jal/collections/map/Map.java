package org.jal.collections.map;

import org.jal.util.Pair;

public interface Map<K, V> {
  public void set(K key, V value);
  public V get(K key);
  public void remove(K key);
  public int getSize();
  public Iterable<Pair<K, V>> getEntries();
}

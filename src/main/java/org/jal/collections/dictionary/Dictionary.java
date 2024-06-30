package org.jal.collections.dictionary;

public interface Dictionary<K, V> {
  public void set(V value);
  public V get(K key);
  public void remove(K key);
  public int getSize();
  public Iterable<V> getValues();
}

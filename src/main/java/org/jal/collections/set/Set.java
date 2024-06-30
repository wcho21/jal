package org.jal.collections.set;

public interface Set<K> {
  public void set(K key);
  public boolean has(K key);
  public void remove(K key);
  public int getSize();
  public Iterable<K> getKeys();
}

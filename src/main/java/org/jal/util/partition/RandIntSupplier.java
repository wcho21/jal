package org.jal.util.partition;

@FunctionalInterface
public interface RandIntSupplier {
  public int nextInt(int begin, int end);
}

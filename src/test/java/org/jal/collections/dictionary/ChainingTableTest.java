package org.jal.collections.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ChainingTableTest {
  @DisplayName("string")
  @Nested
  class PlainStringTest {
    private ChainingTable<String, String> createStringTable() {
      ChainingTable<String, String> table = new ChainingTable<>(v -> v);
      table.set("foo");
      table.set("bar");
      table.set("baz");

      return table;
    }

    private ChainingTable<Integer, String> createLengthToStringTable() {
      ChainingTable<Integer, String> table = new ChainingTable<>(v -> v.length());
      table.set("foo");
      table.set("quux");

      return table;
    }

    private ChainingTable<Integer, Integer> createLargeIntTable(int size) {
      ChainingTable<Integer, Integer> table = new ChainingTable<>(v -> v);
      for (int i = 0; i < size; ++i) {
        table.set(i);
      }

      return table;
    }

    @DisplayName("get() should get the item if found")
    @Test
    public void testSetAndGets() {
      Dictionary<String, String> table = createStringTable();

      assertEquals("foo", table.get("foo"));
      assertEquals("bar", table.get("bar"));
      assertEquals("baz", table.get("baz"));
    }

    @DisplayName("get() should get null if not found")
    @Test
    public void testGetNull() {
      Dictionary<String, String> table = createStringTable();

      assertEquals(null, table.get("qux"));
    }

    @DisplayName("set() should update if there already is")
    @Test
    public void testSetUpdate() {
      Dictionary<Integer, String> table = createLengthToStringTable();

      assertEquals("foo", table.get(3));
    }

    @DisplayName("set() should set a large numbers of items")
    @Test
    public void testSetLarge() {
      int size = 100;
      Dictionary<Integer, Integer> table = createLargeIntTable(size);

      for (int i = 0; i < size; ++i) {
        assertEquals(i, table.get(i));
      }
    }

    @DisplayName("remove() should remove a large numbers of items")
    @Test
    public void testRemoveLarge() {
      int size = 100;
      Dictionary<Integer, Integer> table = createLargeIntTable(size);

      for (int i = 0; i < size; ++i) {
        table.remove(i);
      }
      for (int i = 0; i < size; ++i) {
        assertEquals(null, table.get(i));
      }
    }

    @DisplayName("remove() should remove items")
    @Test
    public void testRemove() {
      Dictionary<String, String> table = createStringTable();

      table.remove("baz");

      assertEquals("foo", table.get("foo"));
      assertEquals("bar", table.get("bar"));
      assertEquals(null, table.get("baz"));

      table.remove("foo");

      assertEquals(null, table.get("foo"));
      assertEquals("bar", table.get("bar"));

      table.remove("bar");

      assertEquals(null, table.get("bar"));
    }

    @DisplayName("getSize() should get the size")
    @Test
    public void testGetSize() {
      Dictionary<String, String> table = createStringTable();

      assertEquals(3, table.getSize());

      table.remove("foo");

      assertEquals(2, table.getSize());

      table.remove("baz");

      assertEquals(1, table.getSize());

      table.remove("bar");

      assertEquals(0, table.getSize());
    }

    @DisplayName("getSize() should get the size for a large number of data")
    @Test
    public void testGetSizeLarge() {
      int size = 100;
      Dictionary<Integer, Integer> table = createLargeIntTable(size);

      assertEquals(size, table.getSize());
    }

    @DisplayName("getSize() should get the size for a large number of removes")
    @Test
    public void testGetSizeLargeRemoves() {
      int size = 100;
      Dictionary<Integer, Integer> table = createLargeIntTable(size);

      for (int i = 0; i < size; ++i) {
        table.remove(i);
      }
      assertEquals(0, table.getSize());
    }

    @DisplayName("should be iterable")
    @Test
    public void testIterable() {
      int size = 100;
      ChainingTable<Integer, Integer> table = createLargeIntTable(size);
      Iterable<Integer> values = table.getValues();

      Iterable<Integer> expected = Stream.iterate(0, i->i+1).limit(size).toList();
      Iterable<Integer> sortedValues = StreamSupport.stream(values.spliterator(), false).sorted().toList();
      assertIterableEquals(expected, sortedValues);
    }
  }
}

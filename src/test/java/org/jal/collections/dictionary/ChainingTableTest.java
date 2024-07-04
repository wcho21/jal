package org.jal.collections.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ChainingTableTest {
  @DisplayName("Student attendance scenario")
  @Test
  public void testAttendance() {
    ChainingTable<String, String> table = new ChainingTable<>(v -> v);

    table.set("John");
    table.set("Jane");

    assertNotEquals(null, table.get("John"));
    assertNotEquals(null, table.get("Jane"));
    assertEquals(null, table.get("Tom"));

    table.set("Tom");

    assertNotEquals(null, table.get("John"));
    assertNotEquals(null, table.get("Jane"));
    assertNotEquals(null, table.get("Tom"));

    table.remove("John");

    assertEquals(null, table.get("John"));
    assertNotEquals(null, table.get("Jane"));
    assertNotEquals(null, table.get("Tom"));
  }

  @DisplayName("string")
  @Nested
  class PlainStringTest {
    private Dictionary<String, String> createStringTable() {
      Dictionary<String, String> table = new ChainingTable<>(v -> v);
      table.set("foo");
      table.set("bar");
      table.set("baz");

      return table;
    }

    private Dictionary<Integer, String> createLengthToStringTable() {
      Dictionary<Integer, String> table = new ChainingTable<>(v -> v.length());
      table.set("foo");
      table.set("quux");

      return table;
    }

    private Dictionary<Integer, Integer> createLargeIntTable(int size) {
      Dictionary<Integer, Integer> table = new ChainingTable<>(v -> v);
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
      Dictionary<Integer, Integer> table = createLargeIntTable(size);
      Iterable<Integer> values = table.getValues();

      Iterable<Integer> expected = Stream.iterate(0, i->i+1).limit(size).toList();
      Iterable<Integer> sortedValues = StreamSupport.stream(values.spliterator(), false).sorted().toList();
      assertIterableEquals(expected, sortedValues);
    }
  }

  @DisplayName("single hash object")
  @Nested
  class SingleHashTest {
    static class SingleHashString {
      private String string;
      public SingleHashString(String string) {
        this.string = string;
      }

      public String getString() {
        return this.string;
      }

      @Override
      public int hashCode() {
        return 0;
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof SingleHashString)) {
          return false;
        }

        SingleHashString that = (SingleHashString) obj;
        return this.getString().equals(that.getString());
      }
    }

    private Dictionary<SingleHashString, String> createFirstCharToStringTable() {
      Dictionary<SingleHashString, String> table = new FixedChainingTable<>(v -> new SingleHashString(v.substring(0, 1)));
      table.set("foo");
      table.set("bar");
      table.set("qux");

      return table;
    }

    @DisplayName("get() should get the item if found")
    @Test
    public void testSetAndGets() {
      Dictionary<SingleHashString, String> table = createFirstCharToStringTable();

      assertEquals("foo", table.get(new SingleHashString("f")));
      assertEquals("bar", table.get(new SingleHashString("b")));
      assertEquals("qux", table.get(new SingleHashString("q")));
    }

    @DisplayName("get() should get null if not found")
    @Test
    public void testNull() {
      Dictionary<SingleHashString, String> table = createFirstCharToStringTable();

      assertEquals(null, table.get(new SingleHashString("a")));
    }

    @DisplayName("set() should update if there already is")
    @Test
    public void testSetUpdate() {
      Dictionary<SingleHashString, String> table = createFirstCharToStringTable();

      table.set("baz");
      table.set("quux");
      table.set("quuux");
      table.set("quuuux");

      assertEquals("foo", table.get(new SingleHashString("f")));
      assertEquals("baz", table.get(new SingleHashString("b")));
      assertEquals("quuuux", table.get(new SingleHashString("q")));
    }

    @DisplayName("remove() should remove items")
    @Test
    public void testRemove() {
      Dictionary<SingleHashString, String> table = createFirstCharToStringTable();

      table.remove(new SingleHashString("b"));

      assertEquals("foo", table.get(new SingleHashString("f")));
      assertEquals(null, table.get(new SingleHashString("b")));
      assertEquals("qux", table.get(new SingleHashString("q")));

      table.remove(new SingleHashString("q"));

      assertEquals("foo", table.get(new SingleHashString("f")));
      assertEquals(null, table.get(new SingleHashString("q")));

      table.remove(new SingleHashString("f"));

      assertEquals(null, table.get(new SingleHashString("f")));
    }

    @DisplayName("getSize() should get the size")
    @Test
    public void testGetSize() {
      Dictionary<SingleHashString, String> table = createFirstCharToStringTable();

      assertEquals(3, table.getSize());

      table.remove(new SingleHashString("b"));

      assertEquals(2, table.getSize());

      table.remove(new SingleHashString("f"));

      assertEquals(1, table.getSize());

      table.remove(new SingleHashString("q"));

      assertEquals(0, table.getSize());
    }
  }
}

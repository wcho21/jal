package org.jal.collections.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CircularLinkedListTest {
  @DisplayName("string list scenario")
  @Nested
  class StringListTest {
    @DisplayName("should set and get data")
    @Test
    public void testStringList() {
      // initailize
      CircularLinkedList<String> list = new CircularLinkedList<>();
      list.prepend("foo");
      list.prepend("bar");
      list.prepend("quux");

      // query
      assertEquals("quux", list.get(data -> true)); // first data
      assertEquals(true, list.has(data -> data.length() == 4));

      // size
      assertEquals(3, list.getSize());
      assertEquals(false, list.isEmpty());

      // modify
      list.change(data -> data.equals("bar"), "baz");
      assertEquals(true, list.has(data -> data.equals("baz")));
      list.remove(data -> data.equals("quux"));
      assertEquals(false, list.has(data -> data.equals("quux")));
    }
  }

  @DisplayName("integer list")
  @Nested
  class IntegerListTest {
    private CircularLinkedList<Integer> createList() {
      CircularLinkedList<Integer> list = new CircularLinkedList<>();
      list.prepend(42);
      list.prepend(43);
      list.prepend(44);

      return list;
    }

    @DisplayName("get() should null if empty")
    @Test
    public void testGetHeadForEmptyList() {
      CircularLinkedList<Integer> list = new CircularLinkedList<>();

      assertEquals(null, list.get(data -> true));
    }

    @DisplayName("get() should get the first data")
    @Test
    public void testGetFirstDataForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(44, list.get(data -> true));
    }

    @DisplayName("get() should get data")
    @Test
    public void testGetDataForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(42, list.get(data -> data == 42));
      assertEquals(43, list.get(data -> data == 43));
      assertEquals(44, list.get(data -> data == 44));
    }

    @DisplayName("get() should get null if not matched")
    @Test
    public void testGetNullForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(null, list.get(data -> data == 45));
    }

    @DisplayName("has() should be true if true condition")
    @Test
    public void testHasTrue() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(true, list.has(data -> data == 42));
      assertEquals(true, list.has(data -> data == 43));
      assertEquals(true, list.has(data -> data == 44));
    }

    @DisplayName("has() should be false if false condition")
    @Test
    public void testHasFalse() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(false, list.has(data -> data == 45));
    }

    @DisplayName("change() should change")
    @Test
    public void testChange() {
      CircularLinkedList<Integer> list = createList();

      list.change(data -> data == 43, 9);

      assertEquals(null, list.get(data -> data == 43));
      assertEquals(9, list.get(data -> data == 9));
    }

    @DisplayName("remove() should remove the first data")
    @Test
    public void testRemoveFirstForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      list.remove(data -> true);

      assertEquals(43, list.get(data -> true));
    }

    @DisplayName("remove() should remove data")
    @Test
    public void testRemoveForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      list.remove(data -> data == 42);
      assertEquals(null, list.get(data -> data == 42));
      assertEquals(44, list.get(data -> true));
      assertEquals(43, list.get(data -> data == 43));
      assertEquals(44, list.get(data -> data == 44));

      list.remove(data -> data == 44);
      assertEquals(null, list.get(data -> data == 44));
      assertEquals(43, list.get(data -> true));
      assertEquals(43, list.get(data -> data == 43));

      list.remove(data -> data == 43);
      assertEquals(null, list.get(data -> data == 43));
    }

    @DisplayName("getSize() should get the size as zero if empty")
    @Test
    public void testGetSizeForEmptyList() {
      CircularLinkedList<Integer> list = new CircularLinkedList<>();

      assertEquals(0, list.getSize());
    }

    @DisplayName("getSize() should get the size")
    @Test
    public void testGetSizeForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      list.remove(data -> true);

      assertEquals(2, list.getSize());
    }

    @DisplayName("isEmpty() should be true if empty")
    @Test
    public void testIsEmptyForEmptyList() {
      CircularLinkedList<Integer> list = new CircularLinkedList<>();

      assertEquals(true, list.isEmpty());
    }

    @DisplayName("isEmpty() should be false if nonempty")
    @Test
    public void testIsEmptyForNonemptyList() {
      CircularLinkedList<Integer> list = createList();

      assertEquals(false, list.isEmpty());
    }

    @DisplayName("should be iterable")
    @Test
    public void testIterable() {
      CircularLinkedList<Integer> list = createList();

      assertIterableEquals(Arrays.asList(44, 43, 42), list);
    }

    @SuppressWarnings("unused")
    @DisplayName("should be fail-fast iterable")
    @Test
    public void testFailFastIterable() {
      CircularLinkedList<Integer> list = createList();

      assertThrows(ConcurrentModificationException.class, () -> {
        for (int value : list) {
          list.prepend(45);
        }
      });
    }
  }
}

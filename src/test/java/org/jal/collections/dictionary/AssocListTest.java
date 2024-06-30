package org.jal.collections.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class AssocListTest {
  @DisplayName("integers")
  @Nested
  class CustomObjectTest {
    private Dictionary<Integer, Integer> createTable() {
      // key is the one's digit
      Dictionary<Integer, Integer> table = new AssocList<>(v -> v % 10);
      table.set(42);
      table.set(43);
      table.set(44);

      return table;
    }

    @DisplayName("get() should get items if found")
    @Test
    public void testSetAndGets() {
      Dictionary<Integer, Integer> table = createTable();

      assertEquals(42, table.get(2));
      assertEquals(43, table.get(3));
      assertEquals(44, table.get(4));
    }

    @DisplayName("get() should get null if nout found")
    @Test
    public void testGetNull() {
      Dictionary<Integer, Integer> table = createTable();

      assertEquals(null, table.get(5));
    }

    @DisplayName("set() should update if there already is")
    @Test
    public void testSetToUpdate() {
      Dictionary<Integer, Integer> table = createTable();

      table.set(52);

      assertEquals(52, table.get(2));
    }

    @DisplayName("remove() should remove items")
    @Test
    public void testRemove() {
      Dictionary<Integer, Integer> table = createTable();

      table.remove(2);

      assertEquals(null, table.get(2));
      assertEquals(43, table.get(3));
      assertEquals(44, table.get(4));

      table.remove(3);

      assertEquals(null, table.get(3));
      assertEquals(44, table.get(4));

      table.remove(4);

      assertEquals(null, table.get(4));
    }

    @DisplayName("getSize() should get the size")
    @Test
    public void testGetSize() {
      Dictionary<Integer, Integer> table = createTable();

      assertEquals(3, table.getSize());
    }

    @DisplayName("should be iterable")
    @Test
    public void testIterable() {
      AssocList<Integer, Integer> list = new AssocList<>(v -> v);
      list.set(42);
      list.set(43);
      list.set(44);

      // value = 44, 43, 42
      int i = 44;
      for (int value : list.getValues()) {
        assertEquals(i--, value);
      }
    }
  }

  @DisplayName("students attendance scenario")
  @Nested
  class StudentsAttendanceTest {
    private class Student {
      private String name;
      private boolean attended;

      public Student(String name, boolean attended) {
        this.name = name;
        this.attended = attended;
      }

      public String getName() {
        return this.name;
      }

      public boolean getAttended() {
        return this.attended;
      }
    }

    @DisplayName("should set and get attendance")
    @Test
    public void testAttendance() {
      // initialize students
      Dictionary<String, Student> table = new AssocList<>(Student::getName);
      table.set(new Student("John", false));
      table.set(new Student("Jane", false));
      table.set(new Student("Tom", false));

      // query
      assertEquals(false, table.get("John").getAttended());

      // update
      table.set(new Student("Jane", true));
      assertEquals(true, table.get("Jane").getAttended());

      // remove
      table.remove("Tom");
      assertEquals(null, table.get("Tom"));

      // size
      assertEquals(2, table.getSize());
    }
  }
}

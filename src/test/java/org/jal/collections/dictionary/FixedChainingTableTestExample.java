package org.jal.collections.dictionary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FixedChainingTableTestExample {
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

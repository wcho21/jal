import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import jal.collections.list.LinkedList;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
  @Test
  public void testGetHeadForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.getData());
  }

  @Test
  public void testGetHeadForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(list.getData(), 43);
  }

  @Test
  public void testRemoveForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertThrows(NoSuchElementException.class, () -> list.remove());
  }

  @Test
  public void testRemoveForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.remove();

    assertEquals(list.getData(), 42);
  }

  @Test
  public void testGetSizeForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(list.getSize(), 0);
  }

  @Test
  public void testGetSizeForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);

    assertEquals(list.getSize(), 3);
  }

  @Test
  public void testIsEmptyForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(list.isEmpty(), true);
  }

  @Test
  public void testIsEmptyForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(list.isEmpty(), false);
  }
}

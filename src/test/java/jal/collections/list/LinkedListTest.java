import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.jal.collections.list.LinkedList;
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

    assertEquals(43, list.getData());
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

    assertEquals(42, list.getData());
  }

  @Test
  public void testGetSizeForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(0, list.getSize());
  }

  @Test
  public void testGetSizeForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);
    list.prepend(44);

    assertEquals(3, list.getSize());
  }

  @Test
  public void testIsEmptyForEmptyList() {
    LinkedList<Integer> list = new LinkedList<>();

    assertEquals(true, list.isEmpty());
  }

  @Test
  public void testIsEmptyForNonemptyList() {
    LinkedList<Integer> list = new LinkedList<>();
    list.prepend(42);
    list.prepend(43);

    assertEquals(false, list.isEmpty());
  }
}

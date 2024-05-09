import static org.junit.jupiter.api.Assertions.assertEquals;
import jal.collections.list.LinkedListNode;
import org.junit.jupiter.api.Test;

public class LinkedListNodeTest {
  @Test
  public void testInitWithoutArguments() {
    LinkedListNode<Integer> node = new LinkedListNode<>();

    assertEquals(node.data, null);
    assertEquals(node.next, null);
  }

  @Test
  public void testInitWithArguments() {
    LinkedListNode<Integer> next, node;
    next = new LinkedListNode<>(42, null);
    node = new LinkedListNode<>(43, next);

    assertEquals(node.data, 43);
    assertEquals(node.next, next);
  }
}
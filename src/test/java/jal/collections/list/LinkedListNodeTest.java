import static org.junit.jupiter.api.Assertions.assertEquals;
import org.jal.collections.list.LinkedListNode;
import org.junit.jupiter.api.Test;

public class LinkedListNodeTest {
  @Test
  public void testInitWithoutArguments() {
    LinkedListNode<Integer> node = new LinkedListNode<>();

    assertEquals(null, node.data);
    assertEquals(null, node.next);
  }

  @Test
  public void testInitWithArguments() {
    LinkedListNode<Integer> next, node;
    next = new LinkedListNode<>(42, null);
    node = new LinkedListNode<>(43, next);

    assertEquals(43, node.data);
    assertEquals(next, node.next);
  }
}

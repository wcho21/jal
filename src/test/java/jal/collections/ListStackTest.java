import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import jal.collections.ListStack;
import org.junit.jupiter.api.Test;

public class ListStackTest {
  @Test
  public void testPushAndPeek() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.peek(), 43);
  }

  @Test
  public void testPushAndPop() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.pop(), 43);
  }

  @Test
  public void testPopForEmptyStack() {
    ListStack<Integer> stack = new ListStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @Test
  public void testGetSize() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.getSize(), 2);
  }

  @Test
  public void testIsEmptyForEmptyStack() {
    ListStack<Integer> stack = new ListStack<>();

    assertEquals(stack.isEmpty(), true);
  }

  @Test
  public void testIsEmptyForNonemptyStack() {
    ListStack<Integer> stack = new ListStack<>();
    stack.push(42);

    assertEquals(stack.isEmpty(), false);
  }
}

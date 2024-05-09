import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import jal.collections.ArrayStack;
import org.junit.jupiter.api.Test;

public class ArrayStackTest {
  @Test
  public void testPushAndPeek() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.peek(), 43);
  }

  @Test
  public void testPushAndPop() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.pop(), 43);
  }

  @Test
  public void testPopForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertThrows(NoSuchElementException.class, () -> stack.pop());
  }

  @Test
  public void testGetSize() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);
    stack.push(43);

    assertEquals(stack.getSize(), 2);
  }

  @Test
  public void testIsEmptyForEmptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();

    assertEquals(stack.isEmpty(), true);
  }

  @Test
  public void testIsEmptyForNonemptyStack() {
    ArrayStack<Integer> stack = new ArrayStack<>();
    stack.push(42);

    assertEquals(stack.isEmpty(), false);
  }
}

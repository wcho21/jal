import static org.jal.search.BinarySearchIntArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BinarySearchIntArrayTest {
  static int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
  static int badValue = 0;

  @Test
  public void testFound() {
    int[] arr = BinarySearchIntArrayTest.arr;
    int valueAt2 = arr[2];

    int index = search(arr, valueAt2);

    assertEquals(2, index);
  }

  @Test
  public void testNotFound() {
    int[] arr = BinarySearchIntArrayTest.arr;
    int badValue = BinarySearchIntArrayTest.badValue;

    int index = search(arr, badValue);

    assertEquals(-1, index);
  }
}

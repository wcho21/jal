import static org.jal.search.BinarySearchArray.search;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BinarySearchArrayTest {
  static Integer[] arr = { 9, 26, 43, 84, 93, 110 };
  static Integer badValue = 0;
  static Comparator<Integer> rem8ordering = Comparator.comparing(v -> v % 8);

  @Nested
  class WithoutComparator {
    @Test
    public void testFound() {
      Integer[] arr = BinarySearchArrayTest.arr;
      Integer valueAt2 = arr[2];

      int index = search(arr, valueAt2);

      assertEquals(2, index);
    }

    @Test
    public void testNotFound() {
      Integer[] arr = BinarySearchArrayTest.arr;
      Integer badValue = BinarySearchArrayTest.badValue;

      int index = search(arr, badValue);

      assertEquals(-1, index);
    }
  }

  @Nested
  class WithRem8Ordering {
    @Test
    public void testFound() {
      Integer[] arr = BinarySearchArrayTest.arr;
      Integer valueAt2 = arr[2];

      int index = search(arr, valueAt2, rem8ordering);

      assertEquals(2, index);
    }

    @Test
    public void testNotFound() {
      Integer[] arr = BinarySearchArrayTest.arr;
      Integer badValue = BinarySearchArrayTest.badValue;

      int index = search(arr, badValue, rem8ordering);

      assertEquals(-1, index);
    }
  }
}

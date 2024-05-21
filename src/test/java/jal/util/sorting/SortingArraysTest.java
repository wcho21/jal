import static org.junit.jupiter.api.Assertions.assertEquals;
import org.jal.util.sorting.Arrays;
import org.junit.jupiter.api.Test;

public class SortingArraysTest {
  @Test
  public void testCountEmpty() {
    Integer[] arr = {};

    int count = Arrays.countInversions(arr);

    assertEquals(0, count);
  }

  @Test
  public void testCountZero() {
    Integer[] arr = { 1, 2 };

    int count = Arrays.countInversions(arr);

    assertEquals(0, count);
  }

  @Test
  public void testCountTiny() {
    Integer[] arr = { 4, 3, 2, 1 };

    int count = Arrays.countInversions(arr);

    assertEquals(6, count);
  }
}

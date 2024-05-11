import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.jal.collections.DynamicArray;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
  @Test
  public void testAppend() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(arr.get(0), 42);
    assertEquals(arr.get(1), 43);
  }

  @Test
  public void testAppendLarge() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    for (int i = 0; i < 100; ++i) {
      arr.append(i);
    }

    assertEquals(arr.get(99), 99);
  }

  @Test
  public void testGetOutOfRange() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(2));
  }

  @Test
  public void testSet() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.set(1, 9);

    assertEquals(arr.get(0), 42);
    assertEquals(arr.get(1), 9);
  }

  @Test
  public void testGetSize() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);

    assertEquals(arr.getSize(), 2);
  }

  @Test
  public void testRemove() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    arr.append(42);
    arr.append(43);
    arr.remove();

    assertEquals(arr.get(0), 42);
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
  }

  @Test
  public void testAppendAndRemoveLarge() {
    DynamicArray<Integer> arr = new DynamicArray<>();

    for (int i = 0; i < 100; ++i) {
      arr.append(i);
    }
    for (int i = 0; i < 99; ++i) {
      arr.remove();
    }

    assertEquals(arr.get(0), 0);
    assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
  }
}

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Comparator;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.ShellSortStrategy;
import org.junit.jupiter.api.Test;

public class ShellSortStrategyTest {
  static Comparator<Integer> rem8ordering = Comparator.comparing(v -> v % 8);

  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };

    Sorter.sortArray(unsorted, new ShellSortStrategy<>());

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);

    Sorter.sortArray(unsorted, new ShellSortStrategy<>());

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testReversedSortLarge() {
    Integer[] unsorted = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);

    Sorter.sortArray(unsorted, new ShellSortStrategy<>(), Comparator.comparing(v -> -v));

    assertArrayEquals(expected, unsorted);
  }
}

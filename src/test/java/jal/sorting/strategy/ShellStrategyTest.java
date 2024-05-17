import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Comparator;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.SortStrategy;
import org.jal.sorting.strategy.ShellStrategy;
import org.junit.jupiter.api.Test;

public class ShellStrategyTest {
  static Comparator<Integer> rem8ordering = Comparator.comparing(v -> v % 8);

  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };
    SortStrategy<Integer> strat = new ShellStrategy<>();

    Sorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortInterval() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = 1;
    int end = unsorted.length-1;
    Integer[] expected = { 20, 10, 30, 40 };
    SortStrategy<Integer> strat = new ShellStrategy<>();

    Sorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testBadIntervalBegin() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = -1;
    int end = unsorted.length;
    SortStrategy<Integer> strat = new ShellStrategy<>();

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> Sorter.sortArray(unsorted, begin, end, strat));
  }

  @Test
  public void testBadIntervalEnd() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    int begin = 0;
    int end = unsorted.length+1;
    SortStrategy<Integer> strat = new ShellStrategy<>();

    assertThrows(ArrayIndexOutOfBoundsException.class, () -> Sorter.sortArray(unsorted, begin, end, strat));
  }

  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    SortStrategy<Integer> strat = new ShellStrategy<>();

    Sorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testReversedSortLarge() {
    Integer[] unsorted = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    SortStrategy<Integer> strat = new ShellStrategy<>();

    Sorter.sortArray(unsorted, strat, Comparator.comparing(v -> -v));

    assertArrayEquals(expected, unsorted);
  }
}

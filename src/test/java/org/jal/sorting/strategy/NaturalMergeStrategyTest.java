import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Comparator;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.SortStrategy;
import org.jal.sorting.strategy.NaturalMergeStrategy;
import org.junit.jupiter.api.Test;

public class NaturalMergeStrategyTest {
  @Test
  public void testSortTiny() {
    Integer[] unsorted = { 20, 10 };
    Integer[] expected = { 10, 20 };
    SortStrategy<Integer> strat = new NaturalMergeStrategy<>();

    Sorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSort() {
    Integer[] unsorted = { 2, 3, 1, 6, 4, 5 };
    Integer[] expected = { 1, 2, 3, 4, 5, 6 };
    SortStrategy<Integer> strat = new NaturalMergeStrategy<>();

    Sorter.sortArray(unsorted, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testStability() {
    Integer[] unsorted = { 1, 2, 3, 4, 7, 6, 5 };
    Integer[] expected = { 2, 4, 6, 1, 3, 7, 5 };
    SortStrategy<Integer> strat = new NaturalMergeStrategy<>();
    Comparator<Integer> rem2 = Comparator.comparing(v -> v % 2);

    Sorter.sortArray(unsorted, strat, rem2);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortInterval() {
    Integer[] unsorted = { -1, -2, 20, 30, 10, 40, -3, -4 };
    int begin = 2;
    int end = unsorted.length-2;
    Integer[] expected = { -1, -2, 10, 20, 30, 40, -3, -4 };
    SortStrategy<Integer> strat = new NaturalMergeStrategy<>();

    Sorter.sortArray(unsorted, begin, end, strat);

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);

    Sorter.sortArray(unsorted, new NaturalMergeStrategy<>());

    assertArrayEquals(expected, unsorted);
  }
}

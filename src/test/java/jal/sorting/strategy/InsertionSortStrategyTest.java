import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.Comparator;
import java.util.stream.Stream;
import org.jal.sorting.Sorter;
import org.jal.sorting.strategy.InsertionSortStrategy;
import org.junit.jupiter.api.Test;

public class InsertionSortStrategyTest {
  @Test
  public void testSort() {
    Integer[] unsorted = { 20, 30, 10, 40 };
    Integer[] expected = { 10, 20, 30, 40 };

    Sorter.sortArray(unsorted, new InsertionSortStrategy());

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testSortLarge() {
    Integer[] unsorted = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);

    Sorter.sortArray(unsorted, new InsertionSortStrategy());

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testReversedSortLarge() {
    Integer[] unsorted = Stream.iterate(0, i -> i+1).limit(1000).toArray(Integer[]::new);
    Integer[] expected = Stream.iterate(999, i -> i-1).limit(1000).toArray(Integer[]::new);

    Sorter.sortArray(unsorted, new InsertionSortStrategy(), Comparator.comparing(v -> -v));

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testRem8OrderingDistinctSort() {
    Integer[] unsorted = { 110, 93, 84, 43, 26, 9 };
    Integer[] expected = { 9, 26, 43, 84, 93, 110 };

    Sorter.sortArray(unsorted, new InsertionSortStrategy(), Comparator.comparing(v -> v % 8));

    assertArrayEquals(expected, unsorted);
  }

  @Test
  public void testRem8OrderingDuplicateSort() {
    Integer[] unsorted = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    Integer[] expected = { 0, 8, 1, 9, 2, 10, 3, 4, 5, 6, 7 };

    Sorter.sortArray(unsorted, new InsertionSortStrategy(), Comparator.comparing(v -> v % 8));

    assertArrayEquals(expected, unsorted);
  }

  class AnimalRecord {
    public String species;
    public String name;

    public AnimalRecord(String species, String name) {
      this.species = species;
      this.name = name;
    }

    @Override
    public String toString() {
      return "[" + species + ": " + name + "]";
    }
  }

  @Test
  public void testAnimalRecordSorting() {
    final AnimalRecord[] rec = {
      new AnimalRecord("Dog", "3"),
      new AnimalRecord("Dog", "2"),
      new AnimalRecord("Dog", "1"),
      new AnimalRecord("Cat", "A"),
      new AnimalRecord("Cat", "B"),
      new AnimalRecord("Cat", "C"),
    };

    AnimalRecord[] unsorted = { rec[0], rec[5], rec[3], rec[1], rec[4], rec[2] };
    AnimalRecord[] expected = rec;

    Sorter.sortArray(unsorted, new InsertionSortStrategy(), (rec1, rec2) -> {
      int speciesOrder1 = rec1.species.equals("Dog") ? 0 : 1;
      int speciesOrder2 = rec2.species.equals("Dog") ? 0 : 1;

      if (speciesOrder1 == 0 || speciesOrder2 == 0) {
        return speciesOrder1 - speciesOrder2; // follow species ordering
      }

      return rec1.name.compareTo(rec2.name);
    });

    assertArrayEquals(expected, unsorted);
  }
}

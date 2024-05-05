import static org.junit.jupiter.api.Assertions.assertEquals;
import jal.math.Euclid;
import org.junit.jupiter.api.Test;

public class EuclidTest {
  @Test
  public void testLargeNums() {
    int m = 200000000;
    int n = 100000000;
    int gcd = Euclid.getGCD(m, n);

    assertEquals(gcd, 100000000);
  }

  @Test
  public void testZeroNum() {
    int gcd = Euclid.getGCD(1, 0);

    assertEquals(gcd, 0);
  }
}

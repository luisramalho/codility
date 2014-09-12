import java.util.HashSet;
import java.util.Set;

/**
 * Checks whether array a is a permutation.
 * 
 * @author luisramalho
 *
 */
public final class PermCheck {
  
  /**
   * Private constructor.
   */
  private PermCheck() { }
  
  /**
   * Main method.
   * @param args Arguments 
   */
  public static void main(final String[] args) {
    int[] test = { 4, 1, 3, 2 };
    System.out.println(solution(test));
  }
  
  /**
   * Checks whether array a is a permutation.
   * @param a Non-empty zero-indexed array.
   * @return <code>1</code> if array a is a permutation;
   *         <code>0</code> otherwise.
   */
  public static int solution(final int[] a) {
    Set<Integer> count = new HashSet<Integer>();
    int n = a.length;
    int expectedSum = (n * (n + 1)) / 2;
    int actualSum = 0;

    for (int i = 0; i < a.length; i++) {
      if (!count.add(a[i])) {
        return 0;
      }
      actualSum += a[i];
    }
    
    if (expectedSum == actualSum) {
      return 1;
    } else {
      return 0;
    }
  }

}

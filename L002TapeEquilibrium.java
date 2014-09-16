/**
 * Solution for TapeEquilibrium.
 * @author luisramalho
 *
 */
public final class L002TapeEquilibrium {
  
  /**
   * Test case(s).
   */
  static final int[] ARY = {3, 1, 2, 4, 3};
  
  /**
   * Private constructor.
   */
  private L002TapeEquilibrium() {
    
  }

  /**
   * Main method.
   * @param args arguments
   */
  public static void main(final String[] args) {
    System.out.println(solution(ARY));
  }
  
  /**
   * Solution.
   * @param a non-empty zero-indexed array, consisting of N integers.
   * @return The minimal difference that can be achieved.
   */
  private static int solution(final int[] a) {
    int totalSum = 0;
    for (int i = 0; i < a.length; i++) {
      totalSum += a[i];
    }
    
    int leftSum = 0;
    int rightSum = totalSum;
    int lowest = Integer.MAX_VALUE;
    int absDiff = 0;
    
    for (int i = 0; i < a.length - 1; i++) {
      leftSum += a[i];
      rightSum -= a[i];
      absDiff = Math.abs(leftSum - rightSum);
      if (absDiff < lowest) {
        lowest = absDiff;
      }
    }
    return lowest;
  }

}

/**
 * Counts minimal number of jumps from position X to Y.
 * @author luisramalho
 *
 */
public final class FrogJmp {
  
  /**
   * Private constructor.
   */
  private FrogJmp() {
    
  }
  
  /**
   * Current position.
   */
  public static final int X = 10;
  
  /**
   * Final position.
   */
  public static final int Y = 85;
  
  /**
   * Number of jumps.
   */
  public static final int D = 30;
  
  
  /**
   * Main method.
   * @param args    arguments
   */

  public static void main(final String[] args) {
    System.out.println(solution(X, Y, D));
  }

  /**
   * Counts the minimal number of jumps from position X to Y.
   * @param     x   current position
   * @param     y   final position
   * @param     d   jump distance
   * @return        number of jumps
   */
  private static int solution(final int x, final int y, final int d) {
    final int distance = y - x;
    final int jumps = distance / d;

    if (distance % D == 0) {
      return jumps;
    } else {
      return jumps + 1;
    }
  }

}

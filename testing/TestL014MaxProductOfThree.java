package testing;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import codility.L014MaxProductOfThree;

/**
 * Tests for L014MaxProductOfThree.
 *
 * @author luisramalho
 *
 */
public class TestL014MaxProductOfThree {

    @Test
    public void testExample() {
        int result = 2 * 5 * 6;
        int[] a = { -3, 1, 2, -2, 5, 6 };
        Assert.assertEquals(result, L014MaxProductOfThree.solution(a));
    }

    @Test
    public void testZeros() {
        int[] a = { 0, 0, 0 };
        Assert.assertEquals(0, L014MaxProductOfThree.solution(a));
    }

    @Test
    public void test2Negatives() {
        int result = -200 * -100 * 200;
        int[] a = { -200, -100, -10, 10, 50, 200 };
        Assert.assertEquals(result, L014MaxProductOfThree.solution(a));
    }

    @Test
    public void testMediumRange() {
        int result = -1000 * -999 * 1000;
        int[] a = new int[2001];
        for (int i = 0; i < 2001; i++) {
            a[i] = i - 1000;
        }
        Assert.assertEquals(result, L014MaxProductOfThree.solution(a));
    }

    @Test
    public void testExtremeLarge() {
        int result = 1000 * 999 * 10;
        int[] a = new int[99_998];
        Random rand = new Random();
        for (int i = 3; i < 99_998; i++) {
            a[i - 3] = rand.nextInt((10 - -10) + 1) + -10;
        }
        a[99_996] = 1000;
        a[99_997] = 999;
        Assert.assertEquals(result, L014MaxProductOfThree.solution(a));
    }
}

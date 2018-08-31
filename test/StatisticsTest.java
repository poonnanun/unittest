import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.Array;

public class StatisticsTest {
    /**
     * A small tolerance for floating point round-off (precision) error.
     */
    static final double TOL = 1.0E-6;

    @Test
    public void testAverageTinyArray() {
        double[] x = {123.01};
        assertEquals(x[0], Statistics.average(x), TOL);
        double[] y = {123.01, 123.02};
        assertEquals(123.015, Statistics.average(y), TOL);
    }

    @Test
    public void testAverageMixedValues() {
        double[] x = new double[99];
        java.util.Arrays.fill(x, 12.5);
        assertEquals(12.5, Statistics.average(x), TOL);
        // many values spaced around a known mean
        double avg = 1.125;
        int n = x.length;
        java.util.Arrays.fill(x, avg);
        for (int k = 0; k <= n / 2; k++) {
            x[k] -= 0.5 * k;
            x[n - k - 1] += 0.5 * k;
        }
        assertEquals(avg, Statistics.average(x), TOL);
    }

    //TODO add test cases:
    //1. slightly illegal case. What if array is empty?
    //2. extrame case: very large array or very different values
    @Test
    public void testEmptyArray() {
        double a [] = new double[]{};
        assertEquals(0,Statistics.average(a),TOL);
    }

    @Test
    public void testLargeArray() {
        double[] a  = new double[1000];
        for (int i = 1; i <= 1000; i++) a[i-1] = i;
        assertEquals(500.50,Statistics.average(a),TOL);

    }


    //TODO add test for variance.
    // What are test cases?
    @Test
    public void testVariance() {
        double a[] = new double[]{600, 470, 170, 430, 300};
        assertEquals(21704, Statistics.variance(a), TOL);
        a = new double[]{75, 83, 96, 100, 121, 125};
        assertEquals(332.67, Statistics.variance(a), TOL);
        a = new double[]{271, 285, 287, 296, 298, 301, 314, 316, 326, 327, 333, 354};
        assertEquals(512.17, Statistics.variance(a), TOL);
        a = new double[]{-9, -7, -4, -1, 0, 2, 7, 9, 12};
        assertEquals(46.22, Statistics.variance(a), TOL);
        a = new double[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        assertEquals(109.56, Statistics.variance(a), TOL);
    }

    @Test
    public void testCovariance() {
        double a[] = new double[]{2.1, 2.5, 3.6, 4.0};
        double b[] = new double[]{8, 10, 12, 14};
        assertEquals(2.27, Statistics.covariance(a, b), TOL);
        a = new double[]{5, 20, 40, 80, 100};
        b = new double[]{10, 24, 33, 54, 10};
        assertEquals(187.75, Statistics.covariance(a, b), TOL);
        a = new double[]{65.21, 64.75, 65.26, 65.76, 65.96};
        b = new double[]{67.25, 66.39, 66.12, 65.70, 66.64};
        assertEquals(-0.06, Statistics.covariance(a, b), TOL);

    }

}

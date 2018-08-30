import java.util.Arrays;

/**
 * Methods for computing some common statistics,
 * such as average, variance, and correlation.
 */
public class Statistics {

    /**
     * Compute the arithmetic average of an array of numbers.
     *
     * @param x is array to compute average of.  Must not be null.
     * @return the arithmetic average of values in x, or 0 if x is empty.
     */
    public static double average(double[] x) {
        // Some fun: sum using a Stream instead of a loop.
        if (x.length == 0) return 0;
        else {
            double sum = Arrays.stream(x).sum();
            return sum / x.length;
        }
    }

    /**
     * Compute the variance of values in an array.
     * Variance uses the formula sum(x[k]*x[k])/length(x) - average(x)^2.
     *
     * @param x is the array of values. Must contain at least 1 element.
     * @return the variance of x
     * @throws IllegalArgumentException if x is empty
     */
    public static double variance(double[] x) {
        if (x.length == 0) {
            throw new IllegalArgumentException("Array mustn't empty");
        } else {
            double mean = average(x);
            double sum = 0;
            for (double i : x) sum += i * i;
            return Math.sqrt((sum / x.length) - (mean * mean));
        }
    }

    /**
     * Compute the covariance between arrays x and y.
     * The covariance is defined by
     * <p>
     * sum[ (x[k] - average(x)) * (y[k] - average(y)) ]/n
     * where n is number of elements in the arrays.
     * <p>
     * But it is more efficient to compute using the equivalent formula:
     * <p>
     * sum( x[k]*y[k] )/n - average(x)*average(y)
     * <p>
     * Note that if x == y, this is the variance.
     *
     * @param x is the first array of values.
     * @param y is the second array of values
     * @return the covariance between x and y
     * @throws IllegalArgumentException if arrays are not same length or length is 0.
     */
    public static double covariance(double[] x, double[] y) {
        if (x.length != y.length || x.length == 0 || y.length == 0)
            throw new IllegalArgumentException("Array should have the same length and have element more than 0");
        else {
            double mean_x = average(x);
            double mean_y = average(y);
            double sum = 0;
            for (int i = 0; i < x.length; i++) sum += (x[i] - mean_x) * (y[i] - mean_y);
            return sum / (x.length - 1);
        }
    }


//    public static void main(String[] args) {
//        double[] a = new double[]{2.1, 2.5, 4.0, 3.6};
//        double[] b = new double[]{8, 12, 14, 10};
//        System.out.println(covariance(a, b));
//    }

}

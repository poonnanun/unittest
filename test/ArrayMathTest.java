import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * Test methods in the ArrayMath class.
 */
public class ArrayMathTest {
	/** A small tolerance for floating point round-off (precision) error. */
	static final double TOL = 1.0E-6;

	@Test
	public void testDotProductTinyVectors() {
		// vector of length one
		double[] x = {5.2};
		double[] y = {-7.5};
		double expected = x[0]*y[0];
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// vector of size 0?
		x = new double[] { };
		y = new double[] { };
		assertEquals( 0.0, ArrayMath.dotProduct(x, y), TOL);
	}
	// Please don't copy my tests. You don't need random numbers (not a good idea
	// because test results may not be reproducible). 
	
	@Test
	public void testDotProductMultipleVectors() {
		// 2 length vector
		double[] x = {2.2, 5.1};
		double[] y = {3.1, -5.2};
		double expected = (x[0]*y[0])+(x[1]*y[1]);
		assertEquals( expected, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( expected, ArrayMath.dotProduct(y, x), TOL);
		
		// Max value 2 length vector
		double[] tx = {Double.MAX_VALUE, Double.MIN_VALUE};
		double[] ty = {Double.MIN_VALUE, Double.MAX_VALUE};
		double txpected = (tx[0]*ty[0])+(tx[1]*ty[1]);
		assertEquals( txpected, ArrayMath.dotProduct(tx, ty), TOL);
		assertEquals( txpected, ArrayMath.dotProduct(ty, tx), TOL);
		
		// 3 length vector
		double[] j = {1.1 ,2.2, 3.3};
		double[] k = {-1.1, 3.1, -4.1};
		assertEquals( -7.92, ArrayMath.dotProduct(j, k), TOL);
		assertEquals( -7.92, ArrayMath.dotProduct(k, j), TOL);
	}

	@Test
	public void testDotProductHugeVectors() {
		int len = 1_000_000;
		double[] x = new double[len];
		double[] y = new double[len];
		Random rand = new Random();
		double product = 0.0;
		for(int k=0; k<len; k++) {
			// to avoid overflowing the product using floats for elements
			double xk = (double) rand.nextFloat();
			double yk = (double) rand.nextFloat();
			x[k] = xk;
			y[k] = yk;
			product += xk*yk;
		}
		assertEquals( product, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( product, ArrayMath.dotProduct(y, x), TOL);
	}

	/** 
	 * This test should throw an exception,
	 * but not after you change the spec for dotProduct!
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testDotProductLengthsNotSame() {
		double[] x = new double[] {1, 3, 5, 7, 9};
		double[] y = new double[] {-2, 0.5, 4};
		assertEquals( 19.5, ArrayMath.dotProduct(x, y), TOL);
		assertEquals( 19.5, ArrayMath.dotProduct(y, x), TOL);
	}

}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}

	@Test  
	public void testIndexIsEmpty() {
		String[] fruit = { };
		assertEquals(-1, StringUtil.indexOf(" ", fruit));
	}
	
	@Test
	public void testIndexOfAllItem() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		
		for(int i=0 ; i<fruit.length ; i++) {
			assertEquals(i, StringUtil.indexOf(fruit[i], fruit));
		}
		
	}
	
	@Test
	public void testLastIndexOf() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(2, StringUtil.indexOf("Grapes", fruit));
	}
	
	@Test  
	public void testNotInArray() {
		String[] fruit = {"Apple", "Banana", "Grapes"};
		assertEquals(-1, StringUtil.indexOf("Orange", fruit));
	}

	@Test
	public void testIndexOfSameItem() {
		String[] fruit = {"Apple", "Banana", "Banana", "Grapes"};
		
		for(int i=0 ; i<fruit.length ; i++) {
			for(int j=i+1 ; j<fruit.length ; j++) {
				if(fruit[i].equals(fruit[j])) {
					assertEquals(i, StringUtil.indexOf(fruit[i], fruit));
				}
			}
		}
	}
}

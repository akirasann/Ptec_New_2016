package sortedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedObjectTest {

	@Test
	public void IntegerSortedtest() {
		int key = 1;
		String value = "test";

		int keytwo = 0;
		String valuetow = "test";

		IntegerSorted intsort = new IntegerSorted(key, value);
		IntegerSorted intsortTwo = new IntegerSorted(keytwo, valuetow);


		boolean actual  = intsort.compare(intsortTwo);
		assertTrue(actual);


	}

}

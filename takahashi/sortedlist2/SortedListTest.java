package sortedlist;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortedListTest<T> {
	@Before


	@Test
	public void addTest(){
		SortedList sort = new SortedList();
		T obj ;
	}

	@Test
	public void getTest() {
		int pos = 1;
		SortedList sort = new SortedList();
		T actual = (T) sort.get(pos);
		String expect = "1";
		assertThat(actual.key,is(Integer.parseInt(expect)));
	}

	@Test
	public void removeTest(){
		SortedList sort = new SortedList();
		sort.remove()
		T  expect;
		assertFase(data[i]==expect);

	}

}

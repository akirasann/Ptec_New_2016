package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Model_hashTest {

	@Test
	public void test() {
		Model_hash mh = new Model_hash("test");
		String expect = "test";
		String actual = mh.toString();
		assertThat(actual,is(expect));
	}

}

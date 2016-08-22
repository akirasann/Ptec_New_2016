package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.IOException;

import org.junit.Test;


public class Hash_viewTest {
		/**
		 * 処理内容: 標準入力のテスト。
		 *
		 * @throws IOException
		 */
		@Test
		public void Numtest() throws IOException {
			Hash_view hv = new Hash_view();
			int expect = 1;
			System.out.print("NUm: ");
			int actual=hv.getOperationNum();
			assertThat(actual, is(expect));
		}
		@Test
		public void test() throws IOException {
			Hash_view hv = new Hash_view();
			String expect = "test";
			System.out.print("Name: ");
			Person person=hv.getPerson();
			String actual = person.getName();
			assertThat(actual,is(expect));
		}
	}



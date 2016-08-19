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
		public void Nametest() throws IOException {
			Hash_view hv = new Hash_view();
			String expect = "test";
			assertThat(hv.getOperationNum().toString(), is(expect));
		}

		@Test
		public void Numtest() throws IOException {
			Hash_view hv = new Hash_view();
			String expect = "100";
			assertThat(hv.getOperationNum().toString(), is(expect));
		}

		@Test
		public void initilizeGender() throws IOException {
			Hash_view hv = new Hash_view();
			String expect = "男";
			assertThat(hv.getOperationNum().toString(), is(expect));
		}
	}



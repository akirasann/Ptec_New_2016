package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Hash_viewTest {
	/**
	 * 処理内容: 標準入力のテスト。
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		Hash_view hv= new Hash_view();
		Model_hash key=hv.initilizeName();

		assertThat(key,is("test"));
	}
}

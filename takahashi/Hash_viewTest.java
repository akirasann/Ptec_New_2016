package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Hash_viewTest {
	/**
	 * 前提: 標準入力からデータを得る。
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		Hash_view hv= new Hash_view();
		String key=hv.initilize();

		assertThat("test",is(key));
	}

}

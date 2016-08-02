package junit.framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutoExecuter_synchronizedTest {
	private boolean judge = true;
	/**
	 * 引数がtrueかどうかのテスト
	 */
	@Test
	public void test() {
		assertTrue(judge);
	}

}

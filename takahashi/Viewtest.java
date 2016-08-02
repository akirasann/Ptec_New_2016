package junit.framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class Viewtest {
	Model2 model2 = new Model2("test");
	/**
	 * 引数がnullでないかチェック
	 */
	@Test
	public void test() {
		assertNotNull(model2);
	}

}

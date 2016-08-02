package junit.framework;

import static org.junit.Assert.*;

import org.junit.Test;

public class Model2test {
	Model2 model2;
	String str;

	/**
	 * Model2のインスタンスオブジェクトを生成して
	 * 実装した時の値の確認
	 */
	@Test
	public void test() {
		model2 = new Model2("test");
		assertEquals("test",model2.toString());
	}
	public void nulltest() {

		assertNotNull(str);
	}
}

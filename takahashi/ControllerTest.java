package db2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControllerTest {
	View view = new View();
	Interface_access db =Db.getInstance();
	/**
	 * 引数がnullでないかテスト
	 */
	@Test
	public void test() {
		assertNotNull(view);

	}
	public void Nulltest() {
		assertNotNull(db);
	}
}

package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	/**
	 * 処理内容: 戻り値テスト
	 */

	public void femaletest(){
		Person pson = new Person("test",true);
		boolean actual = pson.getisFemale();
		assertTrue(actual);
	}
	@Test
	public void getNametest(){
		Person pson = new Person("test",true);
		String expect="test";
		String actual=pson.getName();
		assertThat(actual,is(expect));
	}

}

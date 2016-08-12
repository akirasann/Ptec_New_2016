package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class HashtableTest {
	int code;
	int args = 6;
	List<Person>[] list;

	@Before
	public void setup() {
		Person[] person = {
				new Person("Sue", true),
				new Person("Nell", true),
				new Person("Array", true),
				new Person("Joe", false),
				new Person("Dan", false),
				new Person("Bob", false)
				};
		list = new List[args];
		for (int i = 0; i < args; i++) {
			list[i] = new ArrayList<Person>();
		}

		for (Person p : person) {
			list[(p.getName().hashCode()) % (args - 1)].add(p);
		}
	}

	@DataPoints
	public static String[] param = { "Sue", "Nell", "Array", "Joe", "Dan", "Bob" };

	/**
	 * 前提条件: 指定したメソッドの初期化
	 * 処理内容: 名前から性別を得る。
	 * @param key
	 */
	@Theory
	public void Hashtest(String key) {
		String expect = null;
		for (Person p : list[(key.hashCode()) % (args - 1)]) {
			if (p.getName().equals(key)) {
				if (p.getisFemale() == true) {
					expect = "女";
					assertThat("女", is(expect));
				} else {
					expect = "男";
					assertThat("男", is(expect));
				}
			}
		}
	}
}

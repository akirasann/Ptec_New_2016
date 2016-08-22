package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Hashtest {

	@RunWith(Theories.class)
	public static class HashtableTest {
		Hashtable hs;

		@Before
		public void setup() {
			hs = new Hashtable("6");
			hs.initilize();
			Person[] person = {
					new Person("Sue", true),
					new Person("Nell", true),
					new Person("Array", true),
					new Person("Joe", false),
					new Person("Dan", false),
					new Person("Bob", false)
			};

			for (Person p : person) {
				hs.storage(p);
			}
		}

		@DataPoints
		public static final String[] param = { "Sue", "Nell", "Array", "Joe", "Dan", "Bob" };

		@Theory
		public void Hashtest(String key) {

			Person ac = hs.read(key);
			String actual = ac.getName();
			String expect = key;
			assertThat(actual,is(expect));
		}
	}

	@RunWith(Theories.class)
	public  class Deletetest {
		Hashtable hs;

		@Before
		public void setup() {
			hs = new Hashtable("6");
			hs.initilize();
			Person[] person = {
					new Person("Sue", true),
					new Person("Nell", true),
					new Person("Array", true),
					new Person("Joe", false),
					new Person("Dan", false),
					new Person("Bob", false)
			};

			for (Person p : person) {
				hs.storage(p);
			}
		}

		@DataPoints
		public final Person[] param = {
			new Person("Sue",true),
			new Person("Nell", true),
			new Person("Array", true),
			new Person("Joe", false),
			new Person("Dan", false),
			new Person("Bob", false)
		};

		@Theory
		public void DeleteTest(Person key){
			Person actual=hs.delete(key);
			String actualtwo = actual.toString();
			String expect = key.toString();

			assertThat(actualtwo,is(expect));

		}
	}
}

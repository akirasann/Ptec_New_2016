package hashtable;

import java.util.ArrayList;
import java.util.List;

public class Hashmain {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<Person>();
		list.add(new Person("Joe", true));
		list.add(new Person("Nell", true));
		list.add(new Person("Array", true));
		list.add(new Person("Joe", false));
		list.add(new Person("Dan", false));
		list.add(new Person("Bob", false));

		Hashtable hs = new Hashtable(args[0]);
		hs.initilize();
		for (Person p : list)
			hs.storage(p);

		Hash_view hv = new Hash_view();

		Hashcontroller hcon = new Hashcontroller(hs, hv);
		try {
			hcon.proc();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
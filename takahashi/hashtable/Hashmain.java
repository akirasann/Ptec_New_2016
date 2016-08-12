package hashtable;

import java.io.IOException;


public class Hashmain {
	static Person[] person = {
			new Person("Sue",true),
			new Person("Nell",true),
			new Person("Array",true),
			new Person("Joe",false),
			new Person("Dan",false),
			new Person("Bob",false)
	};

	public static void main(String[] args) {
		try {
			Hashtable hs = new Hashtable(args[0]);

			hs.initilize();

			for (Person p : person) {
				hs.storage(p);
			}

			Hashcontroller hcon = new Hashcontroller();
			hcon.proc(hs);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
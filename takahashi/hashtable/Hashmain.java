package hashtable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Hashmain {

	public static void main(String[] args) {
		try {
			List<Person> list = new ArrayList<Person>();
			list.add(new Person("Sue", true));
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

			hcon.proc();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(NumberFormatException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
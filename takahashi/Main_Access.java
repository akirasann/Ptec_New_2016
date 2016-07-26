
package Access_interface;

import java.sql.SQLException;

public class Main_Access {

	public static void main(String[] args) {


		DB db = new DB();
		try {
			/** javadog */
			db.initilize();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		View view = new View();
		view.intilize();

		Controller ctrl = new Controller(view, db);
		try {

			ctrl.proc();

		} catch (Exception e) {
			System.out.println("終了");
			e.printStackTrace();
		}
	}

}

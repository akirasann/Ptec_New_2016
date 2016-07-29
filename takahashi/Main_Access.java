
package Access_Syncronized;

import java.sql.SQLException;

public class Main_Access {

	public static void main(String[] args) {

		Interface_access db = DB.getInstance();
		AutoExecuter aex = new AutoExecuter();

		try {
			/** javadoc */
			db.initilize();

			Thread t = new Thread(aex);
			Thread t2 = new Thread(aex);
			t.start();
			t2.start();

			View view = new View();
			view.intilize();

			Controller ctrl = new Controller(view, db);
			ctrl.proc();
			System.out.println(100);
		} catch (NumberFormatException e1) {

			e1.printStackTrace();

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();

		} catch (Exception e) {
			System.out.println("終了");
			e.printStackTrace();

		} finally {
			System.out.println(">終了");
			aex.threadFinish();
			db.closed();
		}

	}
}

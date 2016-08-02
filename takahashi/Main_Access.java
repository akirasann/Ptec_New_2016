
package junit.framework;

import java.sql.SQLException;

public class Main_access {

	public static void main(String[] args) {

		Interface_access db = Db.getInstance();
		AutoExecuter_synchronized aex = new AutoExecuter_synchronized();

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

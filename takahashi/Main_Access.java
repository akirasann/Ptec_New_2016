
package Access_AutoExecuter;

import java.sql.SQLException;

public class Main_Access {

	public static void main(String[] args) {

		Interface_access db = DB.getInstance();
		AutoExecuter aex  = new AutoExecuter();



//		DB db = new DB();
		try {
			/** javadog */
			db.initilize();

			Thread t = new Thread(aex);
			t.start();

			View view = new View();
			view.intilize();

			Controller ctrl = new Controller(view, db);
			ctrl.proc();

		} catch (ClassNotFoundException | SQLException e1) {

			e1.printStackTrace();
		} catch (Exception e) {
			System.out.println("終了");
			e.printStackTrace();

		}finally {
  			System.out.println(">終了");
  			aex.threadFinish();
  			db.closed();
		}


	}
}

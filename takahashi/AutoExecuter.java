package Access_AutoExecuter;

import java.sql.SQLException;

public class AutoExecuter implements Runnable {


	Interface_access db = DB.getInstance();
	private boolean  judge=true;

	public void run(){
		try {
			while(judge){

			db.write(new Model2("3秒後write()"));
			Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void threadFinish(){
		judge = false;
	}

}

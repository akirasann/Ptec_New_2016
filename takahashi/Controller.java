package Access_AutoExecuter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {

	private View view;
	private Interface_access db;
	// DB接続、SQL発行に必要となるインターフェースの宣言
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	/** 引数 Viewインスタンスオブジェクト DBインスタンスオブジェクト*/
	public Controller(View view, Interface_access db2) {

		this.view = view;
		this.db = db2;
	}

	public void proc() throws Exception {


			while (true) {

				Model2 model2 = view.input();

				db.write(model2);

				model2 = db.read();

				view.display(model2);
			}

	}

}

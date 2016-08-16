package hashtable;

import java.io.IOException;
import java.sql.SQLException;

public class Hashcontroller {
	private Model_hash model;
	private Model_hash model_num;
	private Hash_view hv;
	private Hashcontroller hashcon;
	private static Hashtable hs;

	/**
	 * 前提条件: DB接続の準備 initilize関数の呼び出し。
	 *           格納するコレクションの準備
	 *         	 initilize関数の呼び出し
	 *			 データをコレクションに格納する
	 *           hashinitilize関数を呼び出しておくこと
	 * 引数: Hashtableクラス、Hashcontrollerのオブジェクトとする
	 * 処理内容: 標準入力から分岐処理。
	 * @param hs
	 * @throws Exception
	 */
	public void proc(Hashtable hs, Db_hash db,Hashcontroller hascon,Hash_view hv) throws Exception {

		while (true) {
			Person[] person = db.hashinitilize(db,hashcon);
			for (Person p : person) {
				hs.storage(p);
			}
			System.out.println("検索1 削除2 登録3 終了4");
			model_num = hv.initilizeNum();
			// 検索時
			if (1 == (Integer.parseInt(model_num.toString()))) {
				model = hv.initilizeName();
				if (model.toString().equals("finish")) {
				}
				hv.display(hs.getGender(model));

			}
			// 削除時
			if (2 == (Integer.parseInt(model_num.toString()))) {
				Model_hash model_name = hv.initilizeName();
				db.deleted(model_name, person);
				// hs.di(model_name);
			}
			// 登録時
			if (3 == (Integer.parseInt(model_num.toString()))) {
				hashcon.insert(db);
			}
			//終了
			if (4 == (Integer.parseInt(model_num.toString()))) {
				throw new Exception("終了");
			}
		}
	}

	public void insert(Db_hash db) throws IOException, InterruptedException, SQLException {
		Model_hash model_name = hv.initilizeName();
		Model_hash model_gender = hv.initilizeGender();
		db.write(model_name, model_gender);
	}

}

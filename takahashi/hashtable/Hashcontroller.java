package hashtable;

import java.io.IOException;
import java.sql.SQLException;

public class Hashcontroller {

	private int model_num;
	private Hash_view hv;
	private  Hashtable hs;


	Hashcontroller(Hashtable hs,Hash_view hv){
		this.hs=hs;
		this.hv=hv;
	}
	/**
	 * 前提条件: DB接続の準備 initilize関数の呼び出し。
	 *           格納するコレクションの準備
	 *         	 initilize関数の呼び出し
	 *			 データをコレクションに格納する
	 *           hashinitilize関数を呼び出しておくこと
	 * 引数: Hashtableクラス、Hashcontrollerのオブジェクトとする
	 * 処理内容: 標準入力から分岐処理。
	 * @param hs
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SQLException
	 * @throws Exception
	 */
	public void proc()throws SQLException, IOException, NumberFormatException,InterruptedException,Exception  {

		while (true) {
			System.out.println("検索1 削除2  終了3");
			System.out.print("上記から選んでを入力してください:");
			model_num = hv.getOperationNum();

			// 検索時
			if (model_num==1) {
				System.out.print("名前を入力してください:");
				hv.display(hs.read((hv.getPerson()).getName()));
			}

			// 削除時
			if (model_num==2){
				System.out.print("名前を入力してください:");
				hs.delete(hv.getPerson());
			}

			//終了
			if (model_num==3) {
				throw new Exception("終了");
			}
		}
	}
}

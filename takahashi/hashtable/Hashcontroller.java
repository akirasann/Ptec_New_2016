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

	 * 前提条件: 格納するコレクションの準備
	 *			 データをコレクションに格納する
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
				try{
					hv.display(hs.read((hv.getPerson()).getName()));
				}catch(NullPointerException e){
					System.out.println("名前はありません");
				}
			}
			// 削除時
			if (model_num==2){
				System.out.print("名前を入力してください:");
				Person p = hs.delete(hv.getPerson());
				System.out.println(p.getName()+"削除しました");
			}
			//終了
			if (model_num==3) {
				throw new Exception("終了");
			}
		}
	}
}

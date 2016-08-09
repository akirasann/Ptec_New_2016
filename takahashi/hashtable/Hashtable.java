package hashtable;

import java.util.HashMap;
import java.util.Map;

class Hashtable {
	private int args;
	private int args_two;
	private Map<String,String> map[];
	/**
	 * 前提条件: コマンドライン引数を使う。
	 * 処理内容: 格納する名前の配列の数
	 * 			 mapを格納する配列の数
	 * @param args
	 * @param args_two
	 */
	Hashtable(String args,String args_two) {
		this.args = Integer.parseInt(args);
		this.args_two = Integer.parseInt(args_two);
	}

	/**
	 * 処理内容: ハッシュコードから格納する場所を決める。
	 * 			 名前と性別をセットにして格納する。
	 */
	public void initilize() {
		// Map の作成
		map = new Map[args];
		String[] out = { "Sue", "Nell", "Array", "Joe", "Dan", "Bob" };
		// Mapインスタンス化
		for (int i = 0; i < 6; i++) {
			map[i] = new HashMap<String, String>();
		}

		for (int j= 0; j < 3;j++) {
			// ハッシュコードで与えられた配列に格納する。
			map[ (out[j].hashCode()) % args_two].put(out[j], "Female");
		}

		for (int j = 3; j < 6; j++) {
			map[(out[j].hashCode()) % args_two].put(out[j], "Man");
		}
	}

	/**
	 * 前提条件:initilize()関数を呼び出しておくこと。
	 * アウトプット: 名前から性別を得る。
	 * @param key
	 */
	// 一致するもの取り出す。
	public void getA(String key) {
		for (int k= 0; k < 6; k++) {
			if (map[k]!= null && ((String) map[k].get(key) != null)) {
					System.out.println("性別:"+(String) map[k].get(key));
			}
		}
	}
}

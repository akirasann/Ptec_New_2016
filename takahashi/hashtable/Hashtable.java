package hashtable;

import java.util.ArrayList;
import java.util.List;

class Hashtable {
	private int args;
	private List<Person>[] list;

	/**
	 * 前提条件: コマンドライン引数を使う。
	 * 処理内容: 格納する名前の配列の数
	 * @param args
	 *            // TODO : agrs_two必要なし。
	 */
	Hashtable(String args) {
		this.args = Integer.parseInt(args);
	}
	/**
	 * 格納する配列を作成する。
	 */
	public void initilize(){
		list = new List[args];
		for (int i = 0; i < args; i++) {
			list[i] = new ArrayList<Person>();
		}
	}

	/**
	 * 前提条件: initilize()呼び出しておくこと
	 * 処理内容: ハッシュコードから格納する場所を決める
	 */
	public void storage(Person p) {
		// TODO : mainから与えるように変更。
		// TODO : Personクラスを作成。private final String name; private final boolean
		// isFemale; getterは作って。setterはいらない。
		// TODO :コンストラクタで作成した後は不変。
		list[(p.getName().hashCode()) % (args - 1)].add(p);
	}

	/**
	 * 前提条件:initilize(),Storage()関数を呼び出しておくこと。
	 * アウトプット: 名前から性別を得る。
	 * 処理内容: ハッシュコードから配列特定する。
	 * @param key
	 */
	public String getGender(String key) {
		// TODO : keyのhashcode/argsから配列を特定するロジックに変更する。
		String ptr = "該当なし";
			for (Person p : list[(key.hashCode()) % (args - 1)]) {
				if (p.getName().equals(key)) {
					if (p.getisFemale() == true) {
						ptr = "女";
					} else {
						ptr = "男";
					}
				}
			}return ptr;
		}
	}

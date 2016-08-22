package hashtable;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
	// TODO: 戻り値はPersonに変更, 引数はString nameに変更
	public Person read(String name) {
		// TODO : keyのhashcode/argsから配列を特定するロジックに変更する。
		List<Person> plist = list[(name.hashCode()) % (args -1)];

		for (Person p : plist){
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * 前提条件:initilize(),Storage()関数を呼び出しておくこと。
	 * 処理内容:remove()で要素を削除する。
	 * @param model
	 */
	public Person delete(Person p){

		try{
			for(Person p2:list[(p.getName().hashCode()) % (args -1)]){

				if(p2.getName().equals(p.getName())){
					list[(p.getName().hashCode()) % (args -1)].remove(p2);
					break;
				}
			}
		}catch(ConcurrentModificationException e){
			e.printStackTrace();
		}
		return p;
	}

}


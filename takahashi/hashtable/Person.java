package hashtable;

public class Person {
	private final String name;
	//女性かどうか
	private final boolean isFemale;

	Person(String name,boolean isFemale){
		this.name=name;
		this.isFemale=isFemale;
	}
	/**
	 * アウトプット:性別の取得
	 * 処理内容: boolean型で受け取る。
	 * @return
	 */
	public boolean getisFemale() {
		return isFemale;
	}

	/**
	 * アウトプット: 名前の取得
	 * @return
	 */
	public String getName(){
		return name;
	}
}

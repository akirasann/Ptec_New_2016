package sortedlist;

public class SortedList<T extends SortedObject> {

	private T[] datas;
	private SortedObject insort;


	/**
	 * 処理内容: 配列に追加する。
	 *           最大値と比べて入れ替える作業
	 */
	public void add(T obj){
		int i;
		T data;
		datas[datas.length] = obj;
		for(i=0;i<datas.length;i++){
			/*	memo: <T>型変数にある機能のオブジェクトの型が入ると想定する。
			 * 	 	  8/24 数字なのでint かIntegerではないか
			*         配列は数字が順番に並んでいるとする。
			*		  配列なのであらたに追加はできない
			*	      新しくインスタンス フィールドで定義しているので、新しく更新されている。
			*/
			insort = new IntegerSorted(datas[i].key,datas[i].value);
			/*memo: 上記のdatas[i]と加えたものと比べている。
			 *      datas[i]が上まったら、交換をする。
			 */
			if(insort.compare(new IntegerSorted(datas[datas.length].key,datas[datas.length].value))){
				data = datas[i];
				datas[i] = datas[datas.length];
				datas[datas.length] = data;
				//8月24日 この後並び替えで昇順にする。
			}
		}
	}
	/**
	 * 処理内容: SortedListから引数posと等しいものを取り出す。
	 * @param pos
	 */
	public T get(int pos){
		for(int i=0;i<datas.length;i++){
			if(datas[i].key == pos){
				return datas[i];
			}
		}
	}
	/**
	 * 処理内容: 引数のオブジェクトフィールドと同じ値を削除する。
	 * @param obj
	 */
	public void remove(T obj){
		// memo: 処理内容: オブジェクトのkeyフィールドと等しいdatas配列から見つける。あったら+1する。
		for(int i=0; i<datas.length;i++){
			if(datas[i].key.equals(obj.key)){
				datas[i]=datas[i-1];
				//8月24日 この後並び替えて昇順にする。
			}
		}

	}


}

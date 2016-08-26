package sortedlist;

public class SortedList<T extends SortedObject> {

	private T[] datas;
	private SortedObject insort;


	/**
	 * 処理内容: 配列に追加する。
	 *           最大値と比べて入れ替える作業
	 *           バブルソートで昇順に並び替える。
	 */
	public void add(T obj){
		int i;
		T data;
		datas[datas.length] = obj;
		for(i=0;i<datas.length;i++){
			/*	memo: <T>型変数にはsortedObjectの子クラスに限定される。
			*		  配列なのであらたに追加はできない
			*	      新しくインスタンス フィールドで定義しているので、新しく更新されている。
			*/
			insort = new IntegerSorted(datas[i].getKey(),datas[i].getValue());
			/*memo: 上記のdatas[i]と加えたものと比べている。
			 *      datas[i]が上まったら、交換をする。
			 */
			if(insort.compare(new IntegerSorted(datas[datas.length].getKey(),datas[datas.length].getValue()))){
				data = datas[i];
				datas[i] = datas[datas.length];
				datas[datas.length] = data;
				//8月24日 この後並び替えで昇順にする。
			}
		}
		//バブルソート
		for(int j=0; j<datas.length; j++){
			for(int k=0;k<datas.length - j -1;k++){
				if(datas[k].getKey()>datas[k+1].getKey()){
					T t = datas[k];
					datas[k] = datas[k+1];
					datas[k+1] = t;
				}
			}
		}

	}
	/**
	 * 処理内容: SortedListから引数posと等しいものを取り出す。
	 * @param pos
	 */
	public T get(int pos){
		for(int i=0;i<datas.length;i++){
			if(datas[i].getKey() == pos){
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
			if(datas[i].getKey()==obj.getKey()){
				datas[i]=datas[i-1];
				//8月24日 この後並び替えて昇順にする。
			}
		}
		//バブルソート
		for(int j=0; j<datas.length; j++){
			for(int k=0;k<datas.length - j -1;k++){
				if(datas[k].key>datas[k+1].key){
					T t = datas[k];
					datas[k] = datas[k+1];
					datas[k+1] = t;
				}
			}
		}
	}
}

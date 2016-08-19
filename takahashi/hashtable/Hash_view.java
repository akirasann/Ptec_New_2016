package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hash_view {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String key = null;

	/**
	 * アウトプット: 標準入力でデータを取得する。
	 * 処理内容: 結果を画面に表示する。
	 * @return
	 * @throws IOException
	 */
	public int getOperationNum() throws IOException{
		key = br.readLine();
		return Integer.parseInt(key);
	}

	public Person getPerson() throws IOException {
		// TODO : implement
		key=br.readLine();
		return new Person(key,true);
	}

	public void display(Person  model){
		System.out.println("性別:"+model.getisFemale());
	}
}

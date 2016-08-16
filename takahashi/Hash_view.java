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
	public Model_hash initilizeNum() throws IOException{
		System.out.print("番号:");
		key = br.readLine();
		return new Model_hash(key);
	}

	public Model_hash initilizeName() throws IOException{
		System.out.print("名前:");
		key = br.readLine();
		return new Model_hash(key);
	}
	public Model_hash initilizeGender() throws IOException{
		System.out.print("性別:");
		key = br.readLine();
		return new Model_hash(key);
	}

	public void display(Model_hash  model){
		System.out.println("性別:"+model.toString());
	}
}

package hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hash_view {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String key = null;

	/**
	 * アウトプット: 標準入力でデータを取得する。
	 * @return
	 * @throws IOException
	 */
	public String initilize() throws IOException{
		System.out.print("名前:");
		key = br.readLine();
		return key;
	}
}

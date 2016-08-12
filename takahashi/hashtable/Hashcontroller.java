package hashtable;

import java.io.IOException;

public class Hashcontroller {
	/**
	 * 引数: Hashtableクラスのオブジェクトとする
	 * 処理内容: 標準入力finishで処理終了する。
	 * @param hs
	 * @throws IOException
	 */
	public void proc(Hashtable hs) throws IOException {
		Hash_view hv = new Hash_view();
		while (true) {
			String key = hv.initilize();
			if (key.equals("finish")) {
				break;
			}
			hv.display(hs.getGender(key));
		}
	}
}

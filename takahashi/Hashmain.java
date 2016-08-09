package hashtable;

import java.io.IOException;

public class Hashmain {
	public static void main(String[] args) {

		try {
			Hashtable hs = new Hashtable(args[0],args[1]);
			hs.initilize();

			Hash_view hv = new Hash_view();
			while(true){
				String key=hv.initilize();
				if(key.equals("finish")){
					break;
				}
				hs.getA(key);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
package hashtable;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class HashtableTest {
	int code;
	int args=6;
	int args_two=5;
	Map[] map ;

	@Before
	public void setup() {
		map = new Map[args];
		String[] out = { "Sue", "Nell", "Array", "Joe", "Dan", "Bob" };
		// Mapインスタンス化
		for (int i = 0; i < 6; i++) {
			map[i] = new HashMap<String, String>();
		}

		for (int j= 0; j < 3;j++) {
			// ハッシュコードで与えられた配列に格納する。
			map[ (out[j].hashCode()) % args_two].put(out[j], "Female");
		}

		for (int j = 3; j < 6; j++) {
			map[(out[j].hashCode()) % args_two].put(out[j], "Man");
		}
	}

	@DataPoints
	public static String [] param ={"Sue", "Nell", "Array", "Joe", "Dan", "Bob"};

	/**
	 * 前提条件:指定したメソッドの初期化
	 * 処理内容: 名前から性別を得る。
	 * @param key
	 */
	@Theory
	public void Hashtest(String key){
		for(int i=0;i<6;i++){
			String expect=((String)map[i].get(key));
			if(expect!=null){
				if(key=="Sue"||key=="Nell"||key=="Array"){
					assertThat("Female",is(expect));
				}else{
					assertThat("Man",is(expect));
				}
			}
		}
	}

}

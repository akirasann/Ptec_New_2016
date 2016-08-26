package sortedlist;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SortedListTest<T> {

	@Test
	public void addTest(){
		IntegerSorted [] datas =  {
				new IntegerSorted(1,"test"),
				new IntegerSorted(2,"test"),
				new IntegerSorted(3,"test"),
				new IntegerSorted(4,"test"),
				};

		datas[datas.length] = new IntegerSorted(2,"test");
		int i;
		IntegerSorted t;

		for(i=0;i<datas.length;i++){
			SortedObject insort = new IntegerSorted(datas[i].getKey(),datas[i].getValue());
			if(insort.compare(new IntegerSorted(datas[datas.length].getKey(),datas[datas.length].getValue()))){
				t = datas[i];
				datas[i] = datas[datas.length];
				datas[datas.length] = t;
			}
			String expect = "2";
			assertThat(datas[3].getKey(),is(Integer.parseInt(expect)));
		}

	}

	@Test
	public void getTest() {
		IntegerSorted [] datas =  {
				new IntegerSorted(1,"test"),
				new IntegerSorted(2,"test"),
				new IntegerSorted(3,"test"),
				new IntegerSorted(4,"test"),
				};
		int pos = 1;
		String expect = "1";
		for(int i=0;i<datas.length;i++){
			if(datas[i].getKey() == pos){
				assertThat(datas[i].getKey(),is(Integer.parseInt(expect)));
			}
		}
	}

	@Test
	public void removeTest(){
		IntegerSorted [] datas =  {
				new IntegerSorted(1,"test"),
				new IntegerSorted(2,"test"),
				new IntegerSorted(3,"test"),
				new IntegerSorted(4,"test"),
				};
		String exepct ="1";
		IntegerSorted obj = new IntegerSorted(2,"test");
		for(int i=0; i<datas.length;i++){
			if(datas[i].getKey()==obj.getKey()){
				datas[i]=datas[i-1];
				assertThat(datas[i].getKey(),is(Integer.parseInt(exepct)));
			}

		}
	}

}

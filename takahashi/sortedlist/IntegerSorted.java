package sortedlist;

public class IntegerSorted implements SortedObject {

	private int key;
	private String value;

	public IntegerSorted(int key,String value){
		this.key=key;
		this.value=value;
	}

	@Override
	public boolean compare(IntegerSorted x) {
		// TODO 自動生成されたメソッド・スタブ
		return this.key > x.key;
	}




}

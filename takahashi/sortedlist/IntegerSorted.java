package sortedlist;

public class IntegerSorted implements SortedObject {

	private int key;
	private String value;

	public IntegerSorted(int key,String value){
		this.key=key;
		this.value=value;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



	@Override
	public boolean compare(IntegerSorted x) {
		// TODO 自動生成されたメソッド・スタブ
		return this.key > x.key;
	}


}

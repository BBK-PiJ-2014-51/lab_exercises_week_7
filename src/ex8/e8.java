package ex8;
public class e8{
	public static void main(String[] args) {
		int[] testArray = new int[15];
		for (int i = 0; i < testArray.length; i++){
			testArray[i] = (i + 1) * 3;
		}
		
		Stack linkedList = new Stack();
		linkedList.push(new Stack(99));
		for (int i = 2; i < testArray.length; i++){
			linkedList.push(new Stack(i * 3));
		}
		linkedList.push(new Stack(19));
		linkedList.push(new Stack(1));
		linkedList.push(new Stack(190));
		linkedList.push(new Stack(18));
		System.out.println("List before popping all: ");
		linkedList.listObjectsFromHead();
		if (linkedList.isEmpty()) System.out.println("List is now empty");
		while (!linkedList.isEmpty()){
			Stack poppedItem = linkedList.pop();
			System.out.println("Popped: " + poppedItem.value);
		}
		if (linkedList.isEmpty()) System.out.println("List is now empty");
	}
	
}
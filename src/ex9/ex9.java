package ex9;
public class ex9{
	public static void main(String[] args) {
	int[] testArray = new int[15];
	for (int i = 0; i < testArray.length; i++){
		testArray[i] = i + 1;
	}
	
	System.out.print("array output:");
	for (int i = 0; i < testArray.length; i++){
		System.out.print(String.valueOf(testArray[i]));
		if (i != testArray.length -1) System.out.print(", ");
	}
	System.out.println();
	
	System.out.print("list output:");
	ListUtilities linkedList = ListUtilities.arrayToLinkedList(testArray);
	linkedList.listObjectsFromHead();
	}
	
}
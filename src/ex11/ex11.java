package ex11;
public class ex11{
	public static void main(String[] args) {
	int[] testArray = new int[15];
	for (int i = 0; i < testArray.length; i++){
		testArray[i] = (int) (Math.random() * 100);
	}
	
	System.out.print("unsorted list: ");
	ListUtilities linkedList = ListUtilities.arrayToLinkedList(testArray);
	linkedList.listObjectsFromHead();
	linkedList.tail.listObjectsFromTail();
	System.out.print("bubble sorted list:");
	ListUtilities bubblesort = ListUtilities.bubbleSort(linkedList);
	bubblesort.listObjectsFromHead();
	}
	
}
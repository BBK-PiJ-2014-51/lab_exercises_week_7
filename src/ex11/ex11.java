package ex11;
public class ex11{
	int[] testArray;
	public static void main(String[] args) {
		ex11 exercise = new ex11();
		for (int i = 500; i < 50000; i *= 2){
			exercise.test(i);
		}
	}
	

	private void sortIt(int[] testArray) {
		//System.out.print(testArray.length + " ints, unsorted list: ");
		ListUtilities linkedList = ListUtilities.arrayToLinkedList(testArray);
		//linkedList.listObjectsFromHead();
		//System.out.print("bubble sorted list:");
		ListUtilities bubblesort = ListUtilities.bubbleSort(linkedList);
		//bubblesort.listObjectsFromHead();
		System.out.println(testArray.length + " items sorted in " + bubblesort.getLastExecTime() + "ms.");
	}
	
	private void test(int length){
		testArray = new int[length];
		for (int i = 0; i < testArray.length; i++){
			testArray[i] = (int) (Math.random() * 100);
		}
		this.sortIt(testArray);
	}
	
}
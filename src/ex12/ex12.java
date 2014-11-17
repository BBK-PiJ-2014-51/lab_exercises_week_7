package ex12;
public class ex12{
	int[] testArray;
	public static void main(String[] args) {
		ex12 exercise = new ex12();
		for (int i = 500; i < 50000; i *= 2){
			exercise.test(i);
		}
	}
	

	private void sortIt(int[] testArray) {
		//System.out.print(testArray.length + " ints, unsorted list: ");
		//ListUtilities linkedList = ListUtilities.arrayToLinkedList(testArray);
		//linkedList.listObjectsFromHead();
		System.out.print("bubble sorted list:");
		ListUtilities bubblesort = ListUtilities.bubbleSort(ListUtilities.arrayToLinkedList(testArray));
		System.out.println(testArray.length + " items sorted in " + bubblesort.getLastExecTime() + "ms.");
		ListUtilities cocktailsort = ListUtilities.cocktailSort(ListUtilities.arrayToLinkedList(testArray));
		//cocktailsort.listObjectsFromHead();
		System.out.print("cocktail sorted list:");
		System.out.println(testArray.length + " items sorted in " + cocktailsort.getLastExecTime() + "ms.");
	}
	
	private void test(int length){
		testArray = new int[length];
		for (int i = 0; i < testArray.length; i++){
			testArray[i] = (int) (Math.random() * 100);
		}
		this.sortIt(testArray);
	}
	
}